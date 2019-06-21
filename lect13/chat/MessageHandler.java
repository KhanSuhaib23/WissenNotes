import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageHandler {

	public static Map<String, Socket> connectedClient = new HashMap<>();
	public static Lock lock = new ReentrantLock();

	public static void sender(String name) {

		try {
			Socket socket = connectedClient.get(name);
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			while (true) {

				String message = (String) ois.readObject();

				lock.lock();
				for (Socket otherSocket : connectedClient.values()) {

					if (otherSocket != socket) {
						OutputStream sos = otherSocket.getOutputStream();
						ObjectOutputStream soos = new ObjectOutputStream(sos);

						soos.writeObject("[" + name + "] : " + message);

						// soos.close();
					}

				}
				lock.unlock();

				ois.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

				String name = (String) ois.readObject();

				lock.lock();
				connectedClient.put(name, socket);
				lock.unlock();

				serverThreadPool.submit(() -> {
					while (true)
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
