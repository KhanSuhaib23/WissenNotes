import { Component } from '@angular/core';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {

	items = [
		{
			id: 1,
			name: 'Veg',
			price: 200,
			description: 'Veg Dish',
			imgPath: './assets/veg.png',

		},
		{
			id: 2,
			name: 'Non Veg',
			price: 150,
			description: 'Non Veg Dish',
			imgPath: './assets/nonveg.png',

		}
	]

	cart = new Map();

	cartChangeHandler(event) {
		this.cart = event.cart;
	}

	buyEventHandler(event) {

		let foodItem = event.item;
		let id = Number.parseInt(foodItem.id);


		let cartItem = this.cart.get(id);
		
		if (cartItem) {
			this.cart.set(id, {foodItem, quantity: cartItem.quantity + 1})
		} else {
			this.cart.set(id, {foodItem, quantity : 1})
		}

	}

	unbuyEventHandler(event) {

		let foodItem = event.item;
		let id = Number.parseInt(foodItem.id);

		let cartItem = this.cart.get(id);

		if (cartItem.quantity === 1) {
			this.cart.delete(id);
		} else {
			this.cart.set(id, {foodItem, quantity: cartItem.quantity - 1})
		}

	}

	getQuantity(id: number) {
		let cartItem = this.cart.get(id);

		let res = -1;

		if (cartItem) {
			res = cartItem.quantity;
		} else {
			res = 0;
		}

		return res;
	}

}
