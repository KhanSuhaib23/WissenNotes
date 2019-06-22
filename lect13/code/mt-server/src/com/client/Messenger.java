package com.client;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Messenger {

	private static String name;
	
	private volatile static boolean active = true;
	
	public static void userInput(Socket socket) {

		try {
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			while (active) {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.print("> ");
				
				String message = br.readLine();

				oos.writeObject(message);

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		

	}

	public static void displayMessage(Socket socket) {


		try {
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			while (active) {

				String message = (String) ois.readObject();
				System.out.println("\b\b" + message + "\n> ");

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			active = false;
		}

	}

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 8181);

			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			Random random = new Random();

			name = String.valueOf((10000 + random.nextInt(10000)));
			oos.writeObject(name);

			ExecutorService threadPool = Executors.newFixedThreadPool(2);

			threadPool.submit(() -> {
				userInput(socket);
			});
			 threadPool.submit(() -> {
			 displayMessage(socket);
			 });

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
