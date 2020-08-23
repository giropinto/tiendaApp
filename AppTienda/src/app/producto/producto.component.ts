import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../Services/http-service.service';
import { RelacionTv } from '../Models/RelacionTv';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import { map, startWith, debounceTime} from 'rxjs/operators';
import { Videojuego } from '../Models/Videojuego';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  myControl = new FormControl();
  videojuegos:Videojuego[];
  filteredOptions: Observable<Videojuego[]> = null;


  constructor(private httpService:HttpServiceService) {
    this.httpService.VideojuegogetAll()
      .subscribe(data=>{
        {this.videojuegos=data; console.log(this.videojuegos)
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
