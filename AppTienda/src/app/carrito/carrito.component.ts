import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../Services/http-service.service';
import { ProductsellService } from '../Services/productsell.service';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  constructor(private sellservice: ProductsellService,private apiService:HttpServiceService) { }

  ngOnInit(): void {
  }

}
