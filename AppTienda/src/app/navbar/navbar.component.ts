import { Component, OnInit } from '@angular/core';

import {UsuarioResponse, UsuarioRequest} from '../Models/Inteface';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import { AuthResponseData, AuthServiceService} from "../Services/auth-service.service"
import { Observable, Subscription } from 'rxjs';
import { ProductsellService } from '../Services/productsell.service';
declare var $: any;
declare var Culqi: any;
declare var culqijs: any;
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  constructor(private authService: AuthServiceService, private route: Router,private sellservice:ProductsellService) {
   }

  ngOnInit(): void {
    this.userSub = this.authService.user.subscribe(user => {
      this.isAuthenticated = !!user;
      console.log(!user);
      console.log(!!user);
    });
    
  }
  DropCart(){
    this.sellservice.DropCart();
  }
  LoginMode = "Sign In";
  isAuthenticated = false;
  isLoginMode = true;
  LoginStringMode = "Don't have an account?";
  error: string = null;
  private userSub: Subscription;
  SwitchMode(){
    this.isLoginMode= !this.isLoginMode;
    this.LoginStringMode = this.isLoginMode? "Don't have an account?":" Already have an account?";
    this.LoginMode = this.isLoginMode? "Sign In":" Sign Up";
  }
  onLogout(){
    this.authService.logout();
    this.isLoginMode = true;
  }
  onSubmit(form: NgForm){
    if(!form.valid){
      return;
    }
    const email = form.value.email;
    const password = form.value.password;
    let authObs: Observable<AuthResponseData>
    
    if(this.isLoginMode){
      authObs= this.authService.login(email,password);
    }else{
      authObs = this.authService.signup(email,password);
    }
    authObs.subscribe(
      resData => {
        console.log(resData);
        this.route.navigate(['/home']);
        $(document).ready(function(){
          $("#myModal").modal("hide");
        });
      },
      errorMessage =>{
        console.log(errorMessage);
        this.error = errorMessage;
      }
    );
    form.reset();
    setTimeout(()=>{
      this.error=null;
    },2000);
  }
 
  abrirpago():void{
    Culqi.publicKey = 'pk_test_1f34f9d5710278fe';
    Culqi.settings({
      title: 'Culqi Store',
      currency: 'PEN',
      description: 'Polo/remera Culqi lover',
      amount: 3500
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

    
}
