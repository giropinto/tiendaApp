import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { SellCart, Totalprice } from '../Models/Cart';

@Injectable({
  providedIn: 'root'
})
export class ProductsellService {

  constructor(private router:Router) { }
  Carrito = new BehaviorSubject<SellCart>(null);
  private expirationTimer :any;
  expiresIn = 3600;
  Addtocart(price: number,gameId: string
  ) {
    let carrito:SellCart = new SellCart();
    if(this.Carrito.getValue()!=null){
      carrito = this.Carrito.getValue();
      carrito.totalprice.amount = Number((carrito.totalprice.amount + price).toFixed(2));
    }else{
      const expirationDate = new Date(new Date().getTime() + this.expiresIn * 100);
      carrito.productId =[];
      carrito.totalprice = new Totalprice();
      carrito.totalprice.amount = price;
      carrito.totalprice.expirationTime = expirationDate ;
      this.CartSesionEnded(this.expiresIn * 100)
    }
    carrito.productId.push(gameId);

    carrito.totalprice.isEmpty=false;
    this.Carrito.next(carrito);
    localStorage.setItem('a2bcar', JSON.stringify(carrito));
  }

  RemoveFromcart(gameId:string, price:number){
    let carrito = new SellCart();
    carrito = this.Carrito.getValue();
    let products = [];
    for(let i=0;i<carrito.productId.length;i++){
      if(carrito.productId[i]!=gameId){
        products.push(carrito.productId[i]);
      }
    }
    carrito.productId = products;
    carrito.totalprice.amount= Number((carrito.totalprice.amount - price).toFixed(2));
    if(carrito.totalprice.amount==0){
      carrito.totalprice.isEmpty=true;
    }
    this.Carrito.next(carrito);
    localStorage.setItem('a2bcar',JSON.stringify(carrito))
  }
  loadCart(){
    const cartdata:SellCart= JSON.parse(localStorage.getItem('a2bcar'));
    if (!cartdata) {
      const cart:SellCart ={
        productId: [],
        totalprice: null
      }
      return ;
    }
    this.Carrito.next(cartdata);
    const expirationDuration =
        new Date(cartdata.totalprice.expirationTime).getTime() -
        new Date().getTime();
      this.CartSesionEnded(expirationDuration);
  }
  DropCart(){
    localStorage.removeItem('a2bcar');
    this.Carrito.next(null);
    this.router.navigateByUrl("/producto");
    if (this.expirationTimer) {
      clearTimeout(this.expirationTimer);
      alert("Sesion de compra caduca");
    }
    this.expirationTimer = null;
  }
  CartSesionEnded(expirationDuration: number) {
    this.expirationTimer = setTimeout(() => {
      this.DropCart();
    }, expirationDuration);
  }

}
