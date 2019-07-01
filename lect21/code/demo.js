'use strict'
// 1 - Hello World

// console.log('Hello World!!!!');

// 2 - Data Types

// var v;

// console.log(typeof(v));

// var str = "Suhaib";


// console.log(typeof(str));

// var dynamicStr1 = "Name : " + str + " uses dynamic string"; // bad way
// var dynamicStr2 = `Name : ${str} uses dynamic string`; // good way

// console.log(dynamicStr1);
// console.log(dynamicStr2);

// var num = 100;

// console.log(typeof(num));

// 3 - class and constructor


function Person(name, age) {
	// state

	this.name = name;
	this.age = age;

}

Person.prototype.printName = function () {
	console.log(`Your name is ${this.name}`);
}

Person.prototype.printAge = function() {
    console.log(`Your age is ${this.age}`);
}

var p1 = new Person("Suhaib", 22);

p1.printName();
p1.printAge();

var arr = [1, 2, 3];

var regEx = /\d{2}-\d{4}-\d{3}-\d{4}/; // 12-3456-789-1234

var e1 = {
    name: 'Suhaib',
    'home-address': 'KM',
    1: 23,
    2: 443
};

