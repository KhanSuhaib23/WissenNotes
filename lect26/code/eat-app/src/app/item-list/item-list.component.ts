import { Component, OnInit } from '@angular/core';
import { DataAccessService } from '../data-access.service';

@Component({
	selector: 'app-item-list',
	templateUrl: './item-list.component.html',
	styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

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
	 
	constructor(private datAccessService: DataAccessService) { }

	ngOnInit() {
		this.datAccessService.getItems().subscribe((response: any) => {
			this.items = response;
		})
	}

}
