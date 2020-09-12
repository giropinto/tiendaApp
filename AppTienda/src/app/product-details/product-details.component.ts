import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {LGDto, Videojuego} from '../Models/Videojuego';
import { HttpServiceService } from '../Services/http-service.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  titulo: string = null;
  videojuego: Videojuego = {
    idvideojuego: null,
    titulo: null,
    precio: null,
    fecha_lanzamiento: null,
    desarrolladora: null,
    urlimg: null,
  };
  lgdto: LGDto;
  constructor(private route: ActivatedRoute, private http:HttpServiceService) {
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
<<<<<<< HEAD
    }
    videojuego.titulo=this.titulo;
    this.http.VideojuegogetByName(videojuego).subscribe(data=>{
      this.videojuego=data;
      console.log(data);
   });
=======
    };
    const lgdto: LGDto = {
      lenguaje: null,
      genero: null
    };
    videojuego.titulo = this.titulo;
    this.http.VideojuegogetByName(videojuego).subscribe(data => {
      this.videojuego = data;
      videojuego.idvideojuego = this.videojuego.idvideojuego;
      this.http.VideojuegoData(videojuego).subscribe(res => {
        this.lgdto = res;
        console.log(this.lgdto);
      });
    });
>>>>>>> ce19b031f5265077237c6bb2880b6899fb852dd7
  }
}
