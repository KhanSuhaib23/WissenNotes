
import 'bootstrap/dist/css/bootstrap.css'

let todoButton = document.querySelector('#todo-btn')
let todoLoad = document.querySelector('#todo-load-msg')
let todoList = document.querySelector('#todo-list')

todoLoad.style.display = 'none';

todoButton.addEventListener('click', e => {

    todoLoad.style.display = '';

    let url = 'https://jsonplaceholder.typicode.com/todos?_limit=10';
    let promise = fetch(url);

    promise
    .then(response => response.json())
    .then(todos => {
        let alltodos = todos.map(todo => {
            return `<tr>
                        <td>${todo.id}</td>
                        <td>${todo.title}</td>
                        <td class=${todo.completed ? 'text-success' : 'text-danger'}>${todo.completed ? 'Completed' : 'Not Completed'}</td>
                    </tr>`;
        })

        todoList.innerHTML = alltodos.join('');

        todoLoad.style.display = 'none';
    })
})

