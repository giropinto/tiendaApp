import { Component, OnInit } from '@angular/core';
import {ApiService} from '../Models/ApiService';
import {UsuarioResponse, UsuarioRequest} from '../Models/Inteface';
import {Router} from '@angular/router';
declare var $: any;
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  usuario: string;
  password: string;
  loginsuccess: boolean;
  ingresar(): void{
      const client: UsuarioRequest = {
        username: this.usuario,
        contrasenia: this.password,
        nombres: null,
        apellidos: null
      };
      this.api.obtenerSuscriptor(client).subscribe( data => {
        if (this.usuario === data.username && this.password === data.contrasenia){
          alert('Login completed!');
          this.route.navigate(['/about']);
          // tslint:disable-next-line:only-arrow-functions
          $(document).ready(function(){
            $('#myModal').modal('hide');
          });
        }
        else{
          this.loginsuccess = false;
          setTimeout(() => {this.loginsuccess = true; }, 2000);
       }
    });
  }
  constructor(private api: ApiService, private route: Router) { }

  ngOnInit(): void {
  }

}
