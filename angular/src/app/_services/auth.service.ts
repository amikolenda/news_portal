import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(user_name: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      user_name,
      password
    }, httpOptions);
  }

  register(user_name: string, email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      user_name,
      email,
      password
    }, httpOptions);
  }
}
