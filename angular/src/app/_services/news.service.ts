import { News } from './../models/news.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/news';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<News[]> {
    return this.http.get<News[]>(baseUrl);
  }

  get(id: number): Observable<News> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  findByTitle(title: any): Observable<News[]> {
    return this.http.get<News[]>(`${baseUrl}?title=${title}`);
  }
}
