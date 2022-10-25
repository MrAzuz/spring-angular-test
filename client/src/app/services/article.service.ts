import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Article } from '../models/Article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArticleService {
  constructor(private httpClient: HttpClient) {}

  getArticles() {
    return this.httpClient.get(environment.host + '/articles');
  }

  addArticle(article: Article): Observable<Article> {
    return this.httpClient.post<Article>(
      environment.host + '/articles/add',
      article
    );
  }
}
