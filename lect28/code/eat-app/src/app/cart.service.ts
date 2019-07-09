import { Injectable } from '@angular/core';
import { FoodItemComponent } from './food-item/food-item.component';
import { Subject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class CartService {

	constructor() { }

	cart = new Map();

	cartStream: Subject<any> = new Subject();

	alterCartQty(foodItem: FoodItemComponent, change: number) {

		let id = foodItem.id;


		let cartItem = this.cart.get(id);

		if (cartItem) {
			this.cart.set(id, { foodItem, quantity: cartItem.quantity + change })
		} else {
			this.cart.set(id, { foodItem, quantity: 1 })
		}

		if (this.cart.get(id).quantity == 0) {
			this.cart.delete(id);
		}

		this.cartStream.next({cart: this.cart})
	}
}
