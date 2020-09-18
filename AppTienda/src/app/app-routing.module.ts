import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductoComponent } from './producto/producto.component';



import { NavbarComponent } from './navbar/navbar.component';
import {AboutComponent} from './about/about.component';
import { AuthGuardService } from './Services/auth-guard.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CarritoComponent } from './carrito/carrito.component';


const routes: Routes = [
  {path: '', redirectTo: '/about', pathMatch: 'full'},
  {path:'about',component:AboutComponent},
  {path:'home', component:HomeComponent, canActivate:[AuthGuardService]},
  {path:'carrito', component:CarritoComponent, canActivate:[AuthGuardService]},
  {path:'producto', component:ProductoComponent,canActivate:[AuthGuardService] },
  {path: 'games/:id',component:ProductDetailsComponent,canActivate:[AuthGuardService]},
  {path: '**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
