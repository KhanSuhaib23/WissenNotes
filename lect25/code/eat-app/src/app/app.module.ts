import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReviewComponent } from './review/review.component';
import { CartComponent } from './cart/cart.component';
import { CounterComponent } from './counter/counter.component';

@NgModule({
  declarations: [
    AppComponent,
    FoodItemComponent,
    NavBarComponent,
    ReviewComponent,
    CartComponent,
    CounterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
