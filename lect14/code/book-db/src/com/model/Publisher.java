package com.model;

public class Publisher {
	
	private int id;
	private String name;

	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}
	
}
