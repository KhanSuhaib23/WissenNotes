package com.app;

import java.util.concurrent.TimeUnit;

import com.app.service.TodoService;

public class Application {

	public static void use() throws InterruptedException {
		TodoService todoService = new TodoService();

		int delay = 10;

		todoService.addTodo("go home");
		//TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("relax");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("eat");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("revise");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("practice");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("program");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.addTodo("sleep");
//		TimeUnit.MILLISECONDS.sleep(delay);

		todoService.display("Adding");

		todoService.editTodo(104, "revise lecture notes");
		todoService.editTodo(105, "practice java");

		todoService.display("Editing");

		todoService.deleteTodo(102);

		todoService.display("Deleting");

		todoService.toggleTodoComplete(101);
		todoService.toggleTodoComplete(103);
		todoService.toggleTodoComplete(104);

		todoService.display("Toggle On");

		todoService.toggleTodoComplete(104);

		todoService.display("Toggle Off");

		todoService.toggleTodoCompleteAll();

		todoService.display("Complete All On");

		todoService.toggleTodoCompleteAll();

		todoService.display("Complete All Off");


		todoService.toggleTodoComplete(101);
		todoService.toggleTodoComplete(103);
		todoService.toggleTodoComplete(104);

		todoService.display("Toggle Again");

		todoService.clearCompleted();

		todoService.display("Clear Completed");

		TodoService.display("Filter by name", todoService.filter(p -> p.getContent().startsWith("p")));

		TodoService.display("Sort by time", todoService.sort((p1, p2) -> -p1.getCreated().compareTo(p2.getCreated())));

	}

	public static void main(String[] args) {

		try {
			
			long start = System.nanoTime();
			
			use();
			
			long end = System.nanoTime();
			
			System.out.println(end - start);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
