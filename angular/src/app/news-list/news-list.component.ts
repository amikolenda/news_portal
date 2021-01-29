import { Author } from './../models/author.model';
import { AdminService } from './../_services/admin.service';
import { NewsService } from './../_services/news.service';
import { News } from './../models/news.model';
import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {
  news?: News[];
  adminNews?: News[];
  currentNews?: News;
  currentIndex = -1;
  title = '';
  isLoggedIn = false;
  adminVisability = false;
  admin?: Author;
  adminUserName?: string ="admin";

  constructor(private newsService: NewsService,private adminService:AdminService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.retrieveNews();
    this.showAdminNews();
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.admin=user;
      this.adminUserName=this.admin?.user_name;

    }

  }

  retrieveNews(): void {
    this.newsService.getAll()
      .subscribe(
        data => {
          this.news = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  changeVisability(){
    this.adminVisability = !this.adminVisability;
  }

  refreshList(): void {
    this.retrieveNews();
    this.currentNews = undefined;
    this.currentIndex = -1;
  }

  setActiveNews(news: News, index: number): void {
    this.currentNews = news;
    this.currentIndex = index;
  }
  searchTitle(): void {
    this.currentNews = undefined;
    this.currentIndex = -1;

    this.newsService.findByTitle(this.title)
      .subscribe(
        data => {
          this.news = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  showAdminNews():void {
    this.adminService.getAll(this.adminUserName)
    .subscribe(
      data => {
        this.adminNews = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

}
