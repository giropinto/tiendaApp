import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductoComponent } from './producto/producto.component';
import { AtencionComponent } from './atencion/atencion.component';


import { NavbarComponent } from './navbar/navbar.component';
import {AboutComponent} from './about/about.component';
import {SoftwareComponent} from './software/software.component';
import { AuthGuardService } from './Services/auth-guard.service';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path:'about',component:AboutComponent},  
  {path:'home', component:HomeComponent, canActivate:[AuthGuardService]},
  {path:'navbar', component:NavbarComponent},
  {path: 'software', component: SoftwareComponent,canActivate:[AuthGuardService]},
  {path:'producto', component:ProductoComponent },
  {path:'atencion', component:AtencionComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
