package com.wissen.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {
	
	private int id;
	private String content;
	private boolean complete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", content=" + content + ", complete=" + complete + "]";
	}
	
	

}
