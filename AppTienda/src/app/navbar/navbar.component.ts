import { Component, OnInit } from '@angular/core';
import {ApiService} from '../Models/ApiService';
import {UsuarioResponse, UsuarioRequest} from '../Models/Inteface';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import { AuthResponseData, AuthServiceService} from "../Services/auth-service.service"
import { Observable } from 'rxjs';
declare var $: any;
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  $: any;
  isLoginMode = true;
  error: string = null;
  SwitchMode(){
    this.isLoginMode = false;
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
        this.isLoginMode = false;
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

  }
 
 
  constructor(private authService: AuthServiceService, private route: Router) { }

  ngOnInit(): void {
  }

}
