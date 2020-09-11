import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { FilterContent} from '../Models/Filter'
import { Videojuego,VideojuegoLista} from '../Models/Videojuego';

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
    return this.http.post<VideojuegoLista>('http://localhost:8080/videojuegos', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  } 
  
 
}
