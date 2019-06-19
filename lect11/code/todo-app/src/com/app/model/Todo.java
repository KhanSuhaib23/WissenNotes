package com.app.model;

import java.time.LocalDateTime;

public class Todo {

	private int id;
	private String content;
	private LocalDateTime created;
	private boolean active;
	
	private static int currentId;
	
	static {
		currentId = 101;
	}

	
	public Todo(int id, String content, LocalDateTime created, boolean active) {
		this.id = id;
		this.content = content;
		this.created = created;
		this.active = active;
	}
	
	public Todo(String content) {
		this(currentId++, content, LocalDateTime.now(), true);
	}
	
	public void toggleActive() {
		active = !active;
	}

	public int getId() {
		return id;
	}


	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", content=" + content + ", created=" + created + ", active=" + active + "]";
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setComplete(boolean complete) {
		this.active = !complete;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public boolean isActive() {
		return active;
	}
	
	public boolean isComplete() {
		return !active;
	}
	
	

}
