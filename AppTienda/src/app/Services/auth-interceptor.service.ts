import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpParams
} from '@angular/common/http';
import { take, exhaustMap } from 'rxjs/operators';

import { AuthServiceService } from '../Services/auth-service.service';


@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService {

  constructor(private authService: AuthServiceService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    return this.authService.user.pipe(
      take(1),
      exhaustMap(user => {
        if (!user) {
          return next.handle(req);
        }
        const modifiedReq = req.clone({
          params: new HttpParams().set('auth', user.token)
        });
        return next.handle(modifiedReq);
      })
    );
  }
}
