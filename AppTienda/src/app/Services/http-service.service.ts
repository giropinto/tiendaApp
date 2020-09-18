import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Arraylistid, FilterContent} from '../Models/Filter'
import {LGDto, Videojuego, VideojuegoLista} from '../Models/Videojuego';

import { catchError, map, retry, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {


  constructor(private http:HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json;charset=utf-8'
    })
  };
  errorHandl(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
  VideojuegogetFilter(data: FilterContent): Observable<VideojuegoLista>{
    return this.http.post<VideojuegoLista>('http://localhost:8080/Allgames', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegogetByName(data: Videojuego): Observable<Videojuego>{
    return this.http.post<Videojuego>('http://localhost:8080/GamesByName', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegoData(data: Videojuego): Observable<LGDto>{
    return this.http.post<LGDto>('http://localhost:8080/GetLG', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegoTop(): Observable<VideojuegoLista>{
    return this.http.post<VideojuegoLista>('http://localhost:8080/GetTop', this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegosbyId(data: Arraylistid): Observable<VideojuegoLista>{
    return this.http.post<VideojuegoLista>('http://localhost:8080/GetbyIds',data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
}
