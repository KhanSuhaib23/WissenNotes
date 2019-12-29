import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CartService } from '../cart.service';
import { DataAccessService } from '../data-access.service';

@Component({
	selector: 'app-food-item',
	templateUrl: './food-item.component.html',
	styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

	constructor(private cartService: CartService, private dataAccessService: DataAccessService) { }



	ngOnInit() {

		this.alterQuantity(this.cartService.cart);

		this.cartService.cartStream.subscribe(e => {
			let cart = e.cart

			this.alterQuantity(cart);
		})
	}

	alterQuantity(cart: any) {
		let cartLine = cart.get(this.id);

		if (cartLine) {
			this.quantity = cartLine.quantity;
		} else {
			this.quantity = 0;
		}
	}

	@Input() id: number = 0;
	@Input() name: string = 'Default';
	@Input() price: number = 0;
	@Input() description: string = 'None';
	@Input() imgPath: string = '.';
	@Input() quantity: number = 0;
	@Output() buyEvent = new EventEmitter();
	@Output() unbuyEvent = new EventEmitter();

	reviews = [];

	currTab: number = 1;



	isCurrTab(tabIdx: number): boolean {

		

		return this.currTab == tabIdx;
	}

	changeTab(event: any, tabIndex: number) {
		event.preventDefault();

		if (tabIndex === 3) {
			this.dataAccessService.getReviews(this.id).subscribe((e: any) => {
				console.log(e);
				this.reviews = e;
			})
		}

		this.currTab = tabIndex;
	}

	buyItem(event: any) {
		this.cartService.alterCartQty(this, 1);
	}

	increaseItemQty(event: any) {
		this.cartService.alterCartQty(this, 1);
	}

	decreaseItemQty(event: any) {
		this.cartService.alterCartQty(this, -1);
	}
}