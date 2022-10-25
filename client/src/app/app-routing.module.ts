import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleAddComponent } from './components/article-add/article-add.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { OrdersComponent } from './components/orders/orders.component';

const routes: Routes = [
  { path: 'articles', component: ArticlesComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'articles/add', component: ArticleAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
