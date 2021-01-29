import { News } from './../models/news.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { stringify } from '@angular/compiler/src/util';

const baseUrl = 'http://localhost:8080/api/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  getAll(user_name: any): Observable<News[]> {
    return this.http.get<News[]>(`${baseUrl}/${user_name}`);
  }


  create(data: any): Observable<any> {
    return this.http.post(baseUrl + 'create', data);
  }

  update(id: number, data: News): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
}
