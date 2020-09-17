import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../Services/http-service.service';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import { map, startWith, debounceTime} from 'rxjs/operators';
import { Videojuego, VideojuegoLista } from '../Models/Videojuego';
import { FilterContent } from '../Models/Filter';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  videojuegos: Videojuego[] = [];
  gamescarrusel: Videojuego[] = [];
  gamescard: Videojuego[] = [];
  waiting: boolean = true;
  constructor(private httpService: HttpServiceService) {
    this.httpService.VideojuegoTop().pipe(
    )
      .subscribe(data=>{
        {
          setTimeout(()=>{
            this.waiting=false;
          },500);
          this.videojuegos = data.listaVideojuego;
          console.log(this.videojuegos);
          for (let i = 0; i < 3 ; i++) {
            this.gamescarrusel[i] = this.videojuegos[i];
          }
          console.log(this.gamescarrusel);
          for(let i = 0; i < 7; i++){
            this.gamescard[i] = this.videojuegos[i + 3];
          }
          console.log(this.gamescard);
        }
      });
   }
  ngOnInit(): void {

  }

}
