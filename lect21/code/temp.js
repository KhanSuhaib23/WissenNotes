(function sessionStart() {

    class Trainer {
        constructor(name) {
            this.name = name;
        }
    }

    class Employee {
        constructor(name) {
            this.name = name;
        }
    }

    function teach(sub) {
        console.log(`${this.name} started teaching ${sub}`);

        self = this;
        
        let learn = function() {
            console.log(`${this.name} learning from ${self.name}`);
        }

        console.log(`${this.name} ended teaching ${sub}`);

        return learn;
    }

    var trn = new Trainer('Trainer');

    var learn = teach.call(trn, 'JS');

    var emp1 = new Employee('E1');
    var emp2 = new Employee('E2');

    learn.call(emp1);
    learn.call(emp2);


})();