import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';

import {UsuarioResponse, UsuarioRequest} from '../Models/Inteface';
import {Router} from '@angular/router';
import {FormControl, NgForm} from '@angular/forms';
import { AuthResponseData, AuthServiceService} from "../Services/auth-service.service"
import { Observable, Subscription } from 'rxjs';
import { ProductsellService } from '../Services/productsell.service';
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';
declare var $: any;

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
    });
   
  }
  forgotpass:boolean = false;
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
  Onforgot(){
    this.forgotpass = !this.forgotpass;
  }
  ForgotPassword(form:NgForm){
    if(!form.valid){
      return;
    }
    const email = form.value.email;
    this.authService.forgetpassword(email).subscribe(
      resData => {
        console.log(resData);
        $(document).ready(function(){
          $("#myModal").modal("hide");
        });
      },
      errorMessage =>{
        this.error = errorMessage;
        if(this.error=="An unknown error occurred!"){
          this.error ="Sending Email.";
        }
      }
    );
    form.reset();
    setTimeout(()=>{
      this.error=null;
      $("#myModal").modal("hide");
    },5000);
  }
  onLogout(){
    this.isLoginMode = true;
    this.sellservice.DropCart();
    this.authService.logout(); 
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

   
}
