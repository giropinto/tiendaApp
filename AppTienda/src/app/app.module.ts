import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProductoComponent } from './producto/producto.component';
import { AtencionComponent } from './atencion/atencion.component';
import { HttpServiceService } from './Services/http-service.service';
import { HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module'
import  {ReactiveFormsModule} from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutComponent } from './about/about.component';
import { SoftwareComponent } from './software/software.component';
import { LoginComponent } from './login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductoComponent,
    AtencionComponent,
    NavbarComponent,
    AboutComponent,
    SoftwareComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    CommonModule

  ],
  providers: [HttpServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
