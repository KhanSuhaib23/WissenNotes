import { Component, ViewChild, ElementRef } from '@angular/core';
import { CdkDragPlaceholder } from '@angular/cdk/drag-drop';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {


	get() {
		let dragElem = document.getElementById("drag")
		let rect = dragElem.getBoundingClientRect();
		console.log(rect.left + ', ' + rect.top)
	}

	dragStart(event) {
		console.log('Drag');
	}


}
