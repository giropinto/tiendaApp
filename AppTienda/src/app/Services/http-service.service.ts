import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Arraylistid, FilterContent} from '../Models/Filter'
import {LGDto, Videojuego, VideojuegoLista} from '../Models/Videojuego';

import { catchError, map, retry, tap } from 'rxjs/operators';
import {CulqiPagoRequest } from '../Models/Inteface';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  
  baseUrl = environment.baseUrl;

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
    return this.http.post<VideojuegoLista>(this.baseUrl+'/Allgames', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegogetByName(data: Videojuego): Observable<Videojuego>{
    return this.http.post<Videojuego>(this.baseUrl+'/GamesByName', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegoData(data: Videojuego): Observable<LGDto>{
    return this.http.post<LGDto>(this.baseUrl+'/GetLG', data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegoTop(): Observable<VideojuegoLista>{
    return this.http.post<VideojuegoLista>(this.baseUrl+'/GetTop', this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  VideojuegosbyId(data: Arraylistid): Observable<VideojuegoLista>{
    return this.http.post<VideojuegoLista>(this.baseUrl+'/GetbyIds',data, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  CompraCulqi(data: CulqiPagoRequest): Observable<any>{
    return this.http.post<any>(this.baseUrl+'/charges', data, this.httpOptions)
      .pipe(
        catchError(this.errorHandl)
      );
  }
}
