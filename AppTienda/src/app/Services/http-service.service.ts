import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import {RelacionTv}  from '../Models/RelacionTv';
import {Videojuego} from '../Models/Videojuego';
import { Observable } from 'rxjs';

import { map, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  
  
  constructor(private http:HttpClient) { } 
  Url:string;
 /*
  httpOptions = {
    headers = new HttpHeaders({
      'Content-type': 'application/json',
      
    })
  };
  */

  VideojuegogetAll(): Observable<Videojuego[]>{
    this.Url = 'http://localhost:8080/tienda/getAll';
    return this.http.get<Videojuego[]>(this.Url);
  }
  VideojuegogetById(id:string): Observable<Videojuego[]>{
    this.Url = 'http://localhost:8080/tienda/getById/'+id;
    return this.http.get<Videojuego[]>(this.Url);
  }
}
