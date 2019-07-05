import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
	selector: 'app-counter',
	templateUrl: './counter.component.html',
	styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

	constructor() { }

	@Output() increase = new EventEmitter();
	@Output() decrease = new EventEmitter();

	ngOnInit() {
	}

	@Input() value = 0;

	onMinusClick() {
		this.decrease.emit({value: this.value})
		this.value--;
	}

	onPlusClick() {
		this.increase.emit({value: this.value})
		this.value++;
	}

}
