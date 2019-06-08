package com.wissen.ui;

import com.wissen.font.Font;

public class UI {

	private Font font;

	public UI(Font font) {
		this.font = font;
	}

	public void display(String text) {
		font.render(text);
	}

	public void setFont(Font font) {
		this.font = font;
	}

}
