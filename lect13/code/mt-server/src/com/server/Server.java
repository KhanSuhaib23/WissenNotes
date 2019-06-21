package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {
	
	public static int reqNum;
	public static Lock lock = new ReentrantLock();
	
	public static void handleReq(Socket clientSocket) {
		
		String tname = Thread.currentThread().getName();
		
		
		try {
			InputStream is = clientSocket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			String input = (String) ois.readObject();
			
			System.out.println(tname + " : got input [" + input + "]" );
			
			OutputStream os = clientSocket.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			TimeUnit.SECONDS.sleep(10);
			
			lock.lock();
			
			oos.writeObject("[" + reqNum + "] input [" + input + "] ackowledged");
			reqNum++;
			
			lock.unlock();
			
			ois.close();
			oos.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null; 
		
		ExecutorService serverThreadPool = Executors.newCachedThreadPool();
		
		
		try {
			serverSocket = new ServerSocket(8181);
			
			while (true) {
				Socket socket = serverSocket.accept();
				
				Runnable requestHandler = () -> {
					handleReq(socket);
				};
				
				serverThreadPool.submit(requestHandler);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
