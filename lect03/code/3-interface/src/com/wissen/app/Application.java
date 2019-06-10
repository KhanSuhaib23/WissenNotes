package com.wissen.app;

interface FileHandler {

	public void load();

	public void encode();

	public void decode();

	public void write();

}

interface ImageHandler extends FileHandler {

	public void display();

}

interface TableHandler extends FileHandler {
	public void tabularize();
}

abstract class AbstractFileHandler {
	private String filePath;
	private byte[] dataStream;

	public AbstractFileHandler(String filePath) {
		this.filePath = filePath;
	}

	public void load() {

		System.out.println("Loading a file from filepath: " + filePath);
	}

	public void write() {
		System.out.println("Writing the file to filepath: " + filePath);
	}
}

abstract class AbstractImageHandler extends AbstractFileHandler {

	private byte[] bitmap;

	public AbstractImageHandler(String filePath) {
		super(filePath);
	}

	public void display() {
		System.out.println("Displaying the bitmap");
	}

}

class PNGHandler extends AbstractImageHandler implements ImageHandler {

	public PNGHandler(String filePath) {
		super(filePath);
	}

	@Override
	public void encode() {
		System.out.println("Encode to png...");

	}

	@Override
	public void decode() {
		System.out.println("Decode from png...");

	}

}

class CSVHandler extends AbstractFileHandler implements TableHandler {

	public CSVHandler(String filePath) {
		super(filePath);
	}

	@Override
	public void encode() {
		System.out.println("Encode to csv...");

	}

	@Override
	public void decode() {
		System.out.println("Decode from csv...");

	}

	@Override
	public void tabularize() {
		System.out.println("Making a table from csv...");

	}

}

public class Application {
	
	public static void main(String[] args) {
			
		ImageHandler imageHandler = new PNGHandler("hello.png");
		
		imageHandler.load();
		imageHandler.decode();
		
		imageHandler.display();
	}
}
