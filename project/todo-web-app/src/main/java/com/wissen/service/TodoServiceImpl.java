package com.wissen.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.model.Todo;
import com.wissen.model.User;
import com.wissen.repo.TodoRepository;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepo;

	@Override
	public void addTodo(User user, Todo todo) {

		todo.setUser(user);

		todoRepo.save(todo);

	}

	@Override
	public void deleteTodo(User user, int todoId) {

		todoRepo.deleteById(todoId);

	}

	@Override
	public void editTodo(User user, Todo todo) {

		todo.setUser(user);

		todoRepo.save(todo);
	}

	@Override
	public void completeToggle(User user, int todoId) {

		Todo todo = todoRepo.findById(todoId).get();

		todo.setCompleted(!todo.isCompleted());

		todoRepo.save(todo);

	}

	@Override
	public void clearComplete(User user) {

		todoRepo.deleteCompleted(user.getId());

	}

	@Override
	public void completeAllToggle(User user) {

		List<Todo> todos = todoRepo.getAllTodoByUser(user.getId());

		boolean all_complete = todos.stream().allMatch(t -> t.isCompleted());
		
		todoRepo.setNewCompleteByUser(!all_complete, user.getId());
		
	}

	@Override
	public List<Todo> getCompleted(User user) {
		return todoRepo.getAllTodoByUser(user.getId());
	}

	@Override
	public List<Todo> getActive(User user) {

		return todoRepo.getAllTodoByUser(user.getId()).stream().filter(t -> !t.isCompleted()).collect(Collectors.toList());
	}

	@Override
	public List<Todo> getAll(User user) {
		return todoRepo.getAllTodoByUser(user.getId()).stream().filter(t -> t.isCompleted()).collect(Collectors.toList());
	}

	@Override
	public List<Todo> sortByDate(User user) {
		
		List<Todo> list = todoRepo.getAllTodoByUser(user.getId());
		Comparator<Todo> comparator = (t1, t2) -> t1.getCreationDate().compareTo(t2.getCreationDate());
		
		Collections.sort(list, comparator);
		
		return list;
	}

}
