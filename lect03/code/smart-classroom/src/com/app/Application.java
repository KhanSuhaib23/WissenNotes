package com.app;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

// this is event-driven pattern
// here based on what happens to a particular object
// multiple object must carry out a function

// the object in question is the target
// the object that are affected by it are said to be listeners
// the something that happens is a state change called an event


interface Event {

}

interface Listener {
	public void notify(Event event);
}

abstract class ListenerTarget {

	ArrayList<Listener> listeners;

	public ListenerTarget() {
		listeners = new ArrayList<Listener>();
	}

	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	public void notify(Event event) {
		for (Listener listener : listeners) {
			listener.notify(event);
		}
	}
}

class DoorEvent implements Event {
	public int floor;
	public int door;
	public boolean open;

	public DoorEvent(int floor, int door, boolean open) {
		this.floor = floor;
		this.door = door;
		this.open = open;
	}

}

abstract class DoorListener implements Listener {
	public DoorEvent doorEvent;

	public void notify(Event event) {
		this.doorEvent = (DoorEvent) event;
	}
}

class Door extends ListenerTarget {

	public Door() {
		super();
	}

	public void open() {
		System.out.println("Door Open");

		notify(new DoorEvent(3, 4, true));

	}

	public void close() {
		System.out.println("Door Close");

		notify(new DoorEvent(3, 4, false));

	}

}

class Light extends DoorListener {
	public void notify(Event event) {
		super.notify(event);

		System.out.println("LIGHT >> " + (doorEvent.open ? "ON" : "OFF"));
		System.out.println("\tFloor: " + doorEvent.floor + ", Door: " + doorEvent.door);

	}
}

class AC extends DoorListener {
	public void notify(Event event) {
		super.notify(event);

		System.out.println("AC >> " + (doorEvent.open ? "ON" : "OFF"));
		System.out.println("\tFloor: " + doorEvent.floor + ", Door: " + doorEvent.door);

	}
}

public class Application {

	public static void main(String[] args) throws Exception {

		Door door = new Door();
		
		Light light = new Light();
		AC ac = new AC();
		
		door.addListener(light);
		door.addListener(ac);

		door.open();

		TimeUnit.SECONDS.sleep(2);

		door.close();
		
		System.out.println("-----------------------------------");
		
		TimeUnit.SECONDS.sleep(1);
		
		door.removeListener(light);
		
		door.open();

		TimeUnit.SECONDS.sleep(2);

		door.close();
		
		System.out.println("-----------------------------------");
		
		TimeUnit.SECONDS.sleep(1);
		
		door.removeListener(ac);
		
		door.open();

		TimeUnit.SECONDS.sleep(2);

		door.close();

	}

}
