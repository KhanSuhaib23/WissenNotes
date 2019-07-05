import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { mapToMapExpression } from '@angular/compiler/src/render3/util';

@Component({
	selector: 'app-cart',
	templateUrl: './cart.component.html',
	styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


	constructor() { }

	ngOnInit() {
	}

	
	@Input() cart: any;
	@Output() oncartchange = new EventEmitter();

	getCart() {
		//console.log(this.cart);

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

	increaseBuyHandler(event, foodItem) {

		let id = Number.parseInt(foodItem.id);


		let cartItem = this.cart.get(id);
		
		if (cartItem) {
			this.cart.set(id, {foodItem, quantity: cartItem.quantity + 1})
		} else {
			this.cart.set(id, {foodItem, quantity : 1})
		}

		this.oncartchange.emit({cart: this.cart})
	}

	decreaseBuyHandler(event, foodItem) {

		let id = Number.parseInt(foodItem.id);

		let cartItem = this.cart.get(id);

		if (cartItem.quantity === 1) {
			this.cart.delete(id);
		} else {
			this.cart.set(id, {foodItem, quantity: cartItem.quantity - 1})
		}

		this.oncartchange.emit({cart: this.cart})
	}


}
