import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {Videojuego} from '../Models/Videojuego';
import {Observable} from 'rxjs';
import {HttpServiceService} from '../Services/http-service.service';
import {debounceTime, map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-software',
  templateUrl: './software.component.html',
  styleUrls: ['./software.component.css']
})
export class SoftwareComponent implements OnInit {
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
