import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {LGDto, Videojuego} from '../Models/Videojuego';
import { HttpServiceService } from '../Services/http-service.service';
import { ProductsellService } from '../Services/productsell.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  titulo: string = null;
  Allreadyadded:boolean = false;
  videojuego: Videojuego = {
    idvideojuego: null,
    titulo: null,
    precio: null,
    fecha_lanzamiento: null,
    desarrolladora: null,
    urlimg: null,
  };
  lgdto: LGDto;
  constructor(private route: ActivatedRoute, private http:HttpServiceService,private sellservice:ProductsellService) {
     this.titulo = this.route.snapshot.params['id'];
  }
  
  ngOnInit(): void {
    const videojuego: Videojuego = {
      idvideojuego: null,
      titulo: null,
        precio: null,
        fecha_lanzamiento: null,
      desarrolladora: null,
      urlimg: null,
    };
    const lgdto: LGDto = {
      lenguaje: null,
      genero: null
    };
    videojuego.titulo = this.titulo;
    this.http.VideojuegogetByName(videojuego).subscribe(data => {
      this.videojuego = data;
      videojuego.idvideojuego = this.videojuego.idvideojuego;
      if(this.sellservice.Carrito!=null){
        for(let i=0;i<this.sellservice.Carrito.value.productId.length;i++){
          if(this.sellservice.Carrito.value.productId[i]==this.videojuego.idvideojuego){
            this.Allreadyadded=true;
          } 
        }
      } 
      this.http.VideojuegoData(videojuego).subscribe(res => {
        this.lgdto = res;
        console.log(this.lgdto);
      });
    });
  }
  addToCart(){
    this.sellservice.Addtocart(this.videojuego.precio,this.videojuego.idvideojuego);
    this.Allreadyadded=true;
  }
  RemovefromCart(){
    this.sellservice.RemoveFromcart(this.videojuego.idvideojuego,this.videojuego.precio);
    this.Allreadyadded=false;
  }
}

