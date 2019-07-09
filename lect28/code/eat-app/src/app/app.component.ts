import { Component, ViewChild, ElementRef } from '@angular/core';
import { CdkDragPlaceholder } from '@angular/cdk/drag-drop';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	dragElem;

	ngOnInit() {
		this.dragElem = document.getElementById("drag")

		let transform = localStorage.getItem('mytransform');
		if (transform) {
			this.dragElem.style.transform = transform;
		}
		
		
	}
	
	dragStart(event) {
		
		localStorage.setItem('mytransform', this.dragElem.style.transform);
	}


}
