package com.wissen.font;

public class RomanFont implements Font {

	private int size;
	private boolean bold;

	public RomanFont(int size, boolean bold) {
		this.size = size;
		this.bold = bold;
	}

	@Override
	public void render(String text) {

		System.out.println("Rendered Roman Font Text of size " + size + " and " + (bold ? "bold" : "not bold"));
		System.out.println("[" + text + "]");

	}

}
