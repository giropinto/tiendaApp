import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from './Services/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private authService: AuthServiceService){}
  ngOnInit(): void {
    this.authService.autoLogin();
  }
  title = 'A2B';
}
