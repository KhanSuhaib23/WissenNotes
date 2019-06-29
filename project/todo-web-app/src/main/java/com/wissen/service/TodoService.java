package com.wissen.service;

import java.util.List;

import com.wissen.model.Todo;
import com.wissen.model.User;

public interface TodoService {
	
	// add
	// delete
	// edit
	// complete
	// clear complete
	// complete all toggle
	// get completed
	// get not complete
	// get all
	// sort by date
	
	public void addTodo(User user, Todo todo);
	public void deleteTodo(User user, int todoId);
	public void editTodo(User user, Todo todo);
	public void completeToggle(User user, int todoId);
	public void clearComplete(User user);
	public void completeAllToggle(User user);
	public List<Todo> getCompleted(User user);
	public List<Todo> getActive(User user);
	public List<Todo> getAll(User user);
	public List<Todo> sortByDate(User user);
	
	

}
