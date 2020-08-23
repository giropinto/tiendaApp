import { Component, OnInit } from '@angular/core';
import {ApiService} from '../Models/ApiService';
import {SuscriptorRequest} from '../Models/Inteface';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  usuario: string;
  password: string;
  pintar(): void{
      alert(this.usuario);
      alert(this.password);
      const peticion: SuscriptorRequest = {
        dni: this.usuario,
        nombres: null,
        apellidos: null
      };
  }
  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }

}
