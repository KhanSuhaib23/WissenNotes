import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  starList: string[];
  author: string = 'who@gmai.com';
  @Input() stars: number = 3.5;
  body: string = 'Blah blah blah';

  getStarsList() {
    this.starList = [];

    for (let i = 0; i < Math.floor(this.stars); i++) {
      this.starList.push("fa fa-star");
    }
    if (Math.floor(this.stars) - this.stars < 0) {
      this.starList.push("fa fa-star-half-o");
    }
    for (let i = 0; i < 5 - Math.ceil(this.stars); i++) {
      this.starList.push("fa fa-star-o");
    }

    return this.starList;
  }

}
