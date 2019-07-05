import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() id: number = 0;
  @Input() name: string = 'Default';
  @Input() price: number = 0;
  @Input() description: string = 'None';
  @Input() imgPath: string = '.';
  @Input() itemBought: number = 0;
  @Output() buyEvent = new EventEmitter();
  @Output() unbuyEvent = new EventEmitter();

  currTab: number = 1;



  isCurrTab(tabIdx: number) : boolean {
    return this.currTab == tabIdx;
  }

  changeTab(event: any, tabIndex: number) {
    event.preventDefault();
    this.currTab = tabIndex;
  }

  handleBuyEvent(event: any) {
    this.buyEvent.emit({item: this});
  }

  increaseBuyHandler(event: any) {
	this.buyEvent.emit({item: this});
  }

  decreaseBuyHandler(event: any) {
	this.unbuyEvent.emit({item: this});
  }
}
