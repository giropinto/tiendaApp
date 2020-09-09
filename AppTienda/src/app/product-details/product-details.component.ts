import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from '../Models/Videojuego';
import { HttpServiceService } from '../Services/http-service.service';
import { RelacionTv } from '../Models/RelacionTv';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  productoid;
  videojuegos:RelacionTv[];
  constructor(private route:ActivatedRoute, private http:HttpServiceService) {
     this.productoid = this.route.snapshot.params['id'];
    }

  ngOnInit(): void {
    this.http.VideojuegogetById(this.productoid).subscribe(data =>{
      this.videojuegos=data; console.log(data);
    });
  }

}
