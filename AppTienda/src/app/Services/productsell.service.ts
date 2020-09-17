import { HttpBackend, HttpClient } from '@angular/common/http';
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
  
  Addtocart(price: number,gameId: string
  ) {
    let carrito:SellCart = new SellCart();
    if(this.Carrito.getValue()!=null){
      carrito = this.Carrito.getValue();
      carrito.totalprice.amount = carrito.totalprice.amount + price;
    }else{
      carrito.productId =[];
      carrito.totalprice = new Totalprice();
      carrito.totalprice.amount = price;
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
    carrito.totalprice.amount= carrito.totalprice.amount - price;
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
      return cart;
    }
    this.Carrito.next(cartdata);
  }
  DropCart(){
    localStorage.removeItem('a2bcar');
    this.Carrito.next(null);
    this.router.navigateByUrl("/producto");
  }
}
