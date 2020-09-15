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
  
  myControl = new FormControl();
  videoLista:VideojuegoLista;
  videojuegos:Videojuego[] ;
  filteredOptions: Observable<Videojuego[]> = null;
  filterContent: FilterContent;
 

  constructor(private httpService:HttpServiceService) {
    this.filterContent= {
      genre: null,
      language: null,
    }
   this.httpService.VideojuegogetFilter(this.filterContent)
    .subscribe(data=>{
      {this.videojuegos=data.listaVideojuego;
       
      }
    });
   }
  ngOnInit(): void {
    this.filteredOptions = this.myControl.valueChanges.pipe(
        startWith(''),
        debounceTime(100),
        map(value => this._filter(value))) ;
    }
    private _filter(value: string): Videojuego[] {
      const filterValue = value.toLowerCase();

      return this.videojuegos.filter((videojuego) => videojuego.titulo.toLowerCase().includes(filterValue));
    }
  FilterGenre(genre){
    genre= "201";
    this.filterContent.genre=genre;
    this.httpService.VideojuegogetFilter(this.filterContent)
    .subscribe(data=>{
      {this.videojuegos=data.listaVideojuego;
       
      }
    });
  }
  FilterLanguage(Language){
    this.filterContent.language=Language;
    this.httpService.VideojuegogetFilter(this.filterContent)
    .subscribe(data=>{
      {this.videojuegos=data.listaVideojuego;
       
      }
    });
  }
}
