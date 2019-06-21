package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 8181);
			
			OutputStream os = socket.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("hello server");
			
			InputStream is = socket.getInputStream();
			
			ObjectInputStream ois = new ObjectInputStream(is);
			
			String recieved = (String) ois.readObject();
			
			System.out.println("server > " + recieved);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
