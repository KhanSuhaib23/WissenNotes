


class Todo {
    constructor(title) {
        this.id = Todo.currId++;
        this.title = title;
        this.complete = false;
    }

    toggleComplete() {
        this.complete = !this.complete;
    }
}

Todo.currId = 1;

class TodoService {

    constructor() {
        this.todos = [];
    }

    add(title) {
        this.todos = this.todos.concat(new Todo(title))
    }

    delete(todoId) {

        this.todos = this.todos.filter(t => t.id !== todoId);
    }

    clearCompleted() {
        this.todos = this.todos.filter(todo => !todo.complete);
    }

    toggle(todoId) {
        this.todos.forEach(todo => {
            if (todo.id === todoId) {
                todo.toggleComplete();
            }
        });
    }

    allToggle() {
        let allComplete = this.todos.every (todo => todo.complete);
        
        this.todos.forEach (todo => todo.complete = !allComplete);
    }

    sortById() {
        this.todos.sort((t1, t2) => t1.id - t2.id);
    }

    getAll() {
        return this.todos;
    }

    getComplete() {
        return this.todos.filter(todo => todo.complete)
    }

    getActive() {
        return this.todos.filter(todo => !todo.complete)
    }

    display() {
        return this.todos.forEach(todo => console.log(todo));
    }

}

var todoService = new TodoService();
