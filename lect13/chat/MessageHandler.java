import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageHandler {

	public static Map<String, Socket> connectedClient = new HashMap<>();
	public static Map<String, ObjectOutputStream> outputStreams = new HashMap<>();
	public static Lock lock = new ReentrantLock();

	public static void sender(String name) {
		
		
		try {
			
			Socket socket = connectedClient.get(name);
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			System.out.println("Waiting for message from " + name);
			
			while (!socket.isClosed()) {


					String message = null;
				
					try {
						message = (String) ois.readObject();						
					} catch (SocketException e) {
						break;
					}

					System.out.println("Recieved message " + message + " from " + name);

					lock.lock();
					for (String recieverName : connectedClient.keySet()) {
						
						ObjectOutputStream clientOos = outputStreams.get(recieverName);
						
						if (!recieverName.equals(name)) {
							
							clientOos.writeObject("[" + name + "] : " + message);

						}

					}
					lock.unlock();


			}
			
			lock.lock();
			System.out.println(name + " disconnected");
			connectedClient.remove(name);
			outputStreams.get(name).close();
			outputStreams.remove(name);
			lock.unlock();
			
		} catch (Exception e) {
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

				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);

				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);

				String name = (String) ois.readObject();

				lock.lock();
				connectedClient.put(name, socket);
				outputStreams.put(name, oos);
				lock.unlock();

				serverThreadPool.submit(() -> {
					sender(name);
				});

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
