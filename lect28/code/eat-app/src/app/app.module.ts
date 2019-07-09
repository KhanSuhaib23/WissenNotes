import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms'
import { DragDropModule } from '@angular/cdk/drag-drop';

import { AppComponent } from './app.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReviewComponent } from './review/review.component';
import { CartComponent } from './cart/cart.component';
import { CounterComponent } from './counter/counter.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ReviewFormComponent } from './review-form/review-form.component';

var routes: Routes = [
	{ path: '', component: ItemListComponent },
	{ path: 'cart', component: CartComponent }
  ]

@NgModule({
  declarations: [
    AppComponent,
    FoodItemComponent,
    NavBarComponent,
    ReviewComponent,
    CartComponent,
    CounterComponent,
    ItemListComponent,
    ReviewFormComponent
  ],
  imports: [
	BrowserModule,
	HttpClientModule,
	ReactiveFormsModule,
	DragDropModule,
	RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
