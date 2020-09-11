import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../Services/http-service.service';
import { Observable  } from 'rxjs';
import { FormControl } from '@angular/forms';
import { map, startWith, debounceTime} from 'rxjs/operators';
import { Videojuego, VideojuegoLista } from '../Models/Videojuego';
import { ActivatedRoute } from '@angular/router';
import { FilterContent } from '../Models/Filter';


@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  myControl = new FormControl();
  videojuegos: Videojuego[] = [];
  filteredOptions: Observable<Videojuego[]> = null;
  LoadedOption:boolean =true;
  routeParams:{
    genero:string;
    idioma:string;
  }
  filtercontent: FilterContent;


  constructor(private httpService:HttpServiceService,private route:ActivatedRoute) {
    this.filtercontent= {
      genre: null,
      language: null,
      page: null,
      searchAs: null
    }
    this.httpService.VideojuegogetFilter(this.filtercontent).pipe(
    )
      .subscribe(data=>{
        {
          this.videojuegos=data.listaVideojuego;
        }
      });
  }


  ngOnInit(): void {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      debounceTime(1000),
      map(value => this._filter(value))) ;
     
  }
  private _filter(value: string): Videojuego[] {
    const filterValue = value.toLowerCase();

    return this.videojuegos.filter((videojuego) => videojuego.titulo.toLowerCase().includes(filterValue));
  }
 
}
