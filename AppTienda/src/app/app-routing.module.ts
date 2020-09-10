import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductoComponent } from './producto/producto.component';
import { AtencionComponent } from './atencion/atencion.component';

import { PorGeneroComponent } from './producto/por-genero/por-genero.component';
import { PorConsolaComponent } from './producto/por-consola/por-consola.component';
import { NavbarComponent } from './navbar/navbar.component';
import {AboutComponent} from './about/about.component';
import {SoftwareComponent} from './software/software.component';
import {ProductodetailsComponent} from './productodetails/productodetails.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'navbar', component: NavbarComponent},
  {path: 'about', component: AboutComponent},
  {path: 'software', component: SoftwareComponent},
  {path: 'producto', component: ProductoComponent},
  {path: 'details', component: ProductodetailsComponent},
  {path: 'atencion', component: AtencionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
