import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms'

@Component({
	selector: 'app-review-form',
	templateUrl: './review-form.component.html',
	styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit {

	isOpen: boolean = false;

	fb = new FormBuilder();

	userForm: FormGroup;

	constructor() { }

	
	ngOnInit() {

		this.userForm = this.fb.group({
			author: '',
			stars: 0,
			body: ''
		})
	}

	toggleForm(): void {
		this.isOpen = !this.isOpen;
	}

	

}
