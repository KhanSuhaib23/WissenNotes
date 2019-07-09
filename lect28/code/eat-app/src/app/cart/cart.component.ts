import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
	selector: 'app-cart',
	templateUrl: './cart.component.html',
	styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


	constructor(private cartService: CartService) { }

	ngOnInit() {
		this.cart = this.cartService.cart;

		this.cartService.cartStream.subscribe(e => {
			this.cart = e.cart
		})
	}


	cart: any;

	getCart() {
		return this.cart;
	}

	getTotal() {

		let total: number = 0;

		this.cart.forEach(element => {
			total += element.quantity * element.foodItem.price;
		})

		// this.cart.array.forEach(element: number => {
		// 	total += element;
		// });

		return total;
	}

	increaseItemQty(event, foodItem) {
		this.cartService.alterCartQty(foodItem, 1);
	}

	decreaseItemQty(event, foodItem) {
		this.cartService.alterCartQty(foodItem, -1);
	}


}
