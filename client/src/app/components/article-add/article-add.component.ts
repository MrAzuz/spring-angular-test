import { Component, Input, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { Article } from 'src/app/models/Article';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html',
  styleUrls: ['./article-add.component.css'],
})
export class ArticleAddComponent implements OnInit {
  article!: Article;

  articleFormGroup!: FormGroup;
  submitted: boolean = false;

  constructor(
    private articleService: ArticleService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.articleFormGroup = this.fb.group({
      name: ['', Validators.required],
      price: [0, Validators.required],
      picture: ['', Validators.required],
    });
  }

  onSaveArticle() {
    this.submitted = true;
    if (this.articleFormGroup?.invalid) return;
    this.articleService
      .addArticle(this.articleFormGroup?.value)
      .subscribe((data) => {
        alert('Success Saving article !');
      });
  }
}
