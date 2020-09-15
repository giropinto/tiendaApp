import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {Videojuego, VideojuegoLista} from '../Models/Videojuego';
import {Observable} from 'rxjs';
import {HttpServiceService} from '../Services/http-service.service';
import {debounceTime, map, startWith} from 'rxjs/operators';
import { FilterContent } from '../Models/Filter';

@Component({
  selector: 'app-software',
  templateUrl: './software.component.html',
  styleUrls: ['./software.component.css']
})
export class SoftwareComponent implements OnInit {
  myControl = new FormControl();
  videoLista: VideojuegoLista;
  videojuegos:Videojuego[];
  filteredOptions: Observable<Videojuego[]> = null;
  filterContent: FilterContent;

  constructor(private httpService:HttpServiceService) {
    this.filterContent= {
      genre: null,
      language: null,
    }
    this.httpService.VideojuegogetFilter(this.filterContent)
      .subscribe(data=>{
        {this.videojuegos=data.listaVideojuego
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

}
