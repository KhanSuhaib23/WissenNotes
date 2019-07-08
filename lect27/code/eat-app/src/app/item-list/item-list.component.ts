import { Component, OnInit } from '@angular/core';
import { DataAccessService } from '../data-access.service';

@Component({
	selector: 'app-item-list',
	templateUrl: './item-list.component.html',
	styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
	
	items = []
	constructor(private dataAccessService: DataAccessService) { }

	ngOnInit() {
		this.dataAccessService.getItems().subscribe((response: any) => {
			this.items = response;
		})
	}

}
