import { Component, OnInit } from '@angular/core';
import { Arraylistid } from '../Models/Filter';
import { Videojuego } from '../Models/Videojuego';
import { HttpServiceService } from '../Services/http-service.service';
import { ProductsellService } from '../Services/productsell.service';
import {CulqiTokenResponse} from '../Models/Inteface';
declare var Culqi: any;
declare var culqijs: any;
@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {
  idarraylist:Arraylistid = new Arraylistid();
  monto: number;
  total: number;
  currency: string;
  cantidadproducto: number;
  hayproductos: boolean = false;
  igv: number;
  email: string;
  constructor(private sellservice: ProductsellService,private apiService:HttpServiceService) {

    if(this.sellservice.Carrito.value!=null){
      if(!this.sellservice.Carrito.value.totalprice.isEmpty){
        this.hayproductos = true;
        this.monto = this.sellservice.Carrito.value.totalprice.amount;
        this.igv = Number((0.18 * this.monto).toFixed(2));
        this.total =  Number((this.monto + this.igv).toFixed(2));
        //this.currency = this.sellservice.Carrito.value.totalprice.currency; aqui va el tipo de moneda
        this.idarraylist.idarray = this.sellservice.Carrito.value.productId;
        this.cantidadproducto = this.idarraylist.idarray.length;
        this.apiService.VideojuegosbyId(this.idarraylist).pipe().subscribe(res => {
          this.videojuegos = res.listaVideojuego;
        });
      }
    }
   }
  videojuegos: Videojuego[] = [];
  ngOnInit(): void {
  }
  abrirpago():void{
    Culqi.publicKey = 'pk_test_1f34f9d5710278fe';
    Culqi.settings({
      title: 'A2B Store',
      currency: 'USD',
      description: 'A2B Selected Games',
      amount: (this.total * 1000) / 10
    });

      Culqi.open();

  }
  culqi():void {
    if (Culqi.token) { // ¡Objeto Token creado exitosamente!
        var token = Culqi.token.id;
        alert('Se ha creado un token:' + token);
        //En esta linea de codigo debemos enviar el "Culqi.token.id"
        //hacia tu servidor con Ajax
    } else { // ¡Hubo algún problema!
        // Mostramos JSON de objeto error en consola
        console.log(Culqi.error);
        alert(Culqi.error.user_message);
    }
  };
  DropCart(){
    this.sellservice.DropCart();
  }
  RemoveFromCart(gameId:string, price:number){
    this.sellservice.RemoveFromcart(gameId,price);

    if(this.sellservice.Carrito.value!=null){
      if(!this.sellservice.Carrito.value.totalprice.isEmpty){
        this.hayproductos = true;
        this.monto = this.sellservice.Carrito.value.totalprice.amount;
        this.igv = Number((0.18 * this.monto).toFixed(2));
        this.total =  Number((this.monto + this.igv).toFixed(2));
        //this.currency = this.sellservice.Carrito.value.totalprice.currency; aqui va el tipo de moneda
        this.idarraylist.idarray = this.sellservice.Carrito.value.productId;
        this.cantidadproducto = this.idarraylist.idarray.length;
        this.apiService.VideojuegosbyId(this.idarraylist).pipe().subscribe(res => {
          this.videojuegos = res.listaVideojuego;
        });
      }else{
        this.hayproductos = false;
        this.monto = this.sellservice.Carrito.value.totalprice.amount;
        this.igv = Number((0.18 * this.monto).toFixed(2));
        this.total =  Number((this.monto + this.igv).toFixed(2));
        this.videojuegos = [];
      }

    }
  }
  pagar(): void{
    if(Culqi.token) {
      var token = Culqi.token.id;
      let vprecio: number = this.total * 100;
      let monto: string = vprecio.toString();
      let pago: CulqiTokenResponse = {
        amount: monto,
        currency_code: 'USD',
        email: '',
        source_id: token
      }
    }
  }
}
