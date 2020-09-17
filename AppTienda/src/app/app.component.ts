import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from './Services/auth-service.service';
import { ProductsellService } from './Services/productsell.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private authService: AuthServiceService,private sellservice:ProductsellService){}
  ngOnInit(): void {
    this.authService.autoLogin();
    this.sellservice.loadCart();
  }
  title = 'A2B';
}
