import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css'],
})
export class ArticlesComponent implements OnInit {
  articlesData: any;

  constructor(
    private articleService: ArticleService,
    private modalService: NgbModal
  ) {}

  public open(modal: any): void {
    this.modalService.open(modal);
  }

  ngOnInit() {
    this.articleService.getArticles().subscribe((data) => {
      this.articlesData = data;
    });
  }
}
