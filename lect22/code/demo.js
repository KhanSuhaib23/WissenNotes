"use strict";

let button = document.getElementById('teach-btn');

class Trainer {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}

let obj = {
    name: 'Hello',

    get_func: function()  {
        return () => {
            console.log(this);
        }
    }
} 

function some_func() {
    return () => {
        console.log(this)
    }
}

let another = {
    name: 'Another',

    get_func: some_func()
}

button.addEventListener('click', another.get_func)