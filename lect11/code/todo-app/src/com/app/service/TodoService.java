package com.app.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {
	
	private Map<Integer, Todo> todos;
	
	public TodoService() {
		todos = new HashMap<>();
	}
	
	public void addTodo(String content) {
		
		Todo todo = new Todo(content);
		
		todos.put(todo.getId(), todo);
	}
	
	public void editTodo(int id, String newContent) {
		
		todos.get(id).setContent(newContent);

	}
	
	public void deleteTodo(int id) {
		
		todos.remove(id);
		
	}
	
	public void toggleTodoComplete(int id) {
		
		todos.get(id).toggleActive();
		
	}
	
	public void toggleTodoCompleteAll() {

		boolean allSame = todos.values().stream().map(t -> t.isComplete()).allMatch(t -> t);
		
		for (Integer key: todos.keySet()) {
			todos.get(key).setComplete(!allSame);
		}
			
	}
	
	public void clearCompleted() {
		
		todos.values().removeIf(v -> v.isComplete());
	}
	
	public List<Todo> filter(Predicate<Todo> condition) {
		
		return todos.values().stream().filter(condition).collect(Collectors.toList());
		
	}
	
	public List<Todo> sort(Comparator<Todo> comparator) {
		
		return todos.values().stream().sorted(comparator).collect(Collectors.toList());
		
	}
	
	public void display(String message) throws InterruptedException {
		TodoService.display(message, this.todos);
		
	}
	
	public static void display(String message, Map<Integer, Todo> todos) throws InterruptedException {
		
		System.out.println("\n----------------" + message + "--------------------\n");
		
		todos.values().stream().forEach(System.out::println);
		
		TimeUnit.MILLISECONDS.sleep(500);
	}
	
	
	public static void display(String message, List<Todo> todos) throws InterruptedException {
		
		System.out.println("\n----------------" + message + "--------------------\n");
		
		todos.stream().forEach(System.out::println);
		
		TimeUnit.MILLISECONDS.sleep(500);
	}

}
