package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class InvalidIDException extends Exception {

	public InvalidIDException(String message) {
		super(message);
	}

}

class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {
		super(message);
	}
}

class NotEnoughAmountException extends Exception {
	public NotEnoughAmountException(String message) {
		super(message);
	}
}

class InventoryManager {

	Map<String, Integer> items;
	String[] ids = { "a01", "a02", "b01" };

	public InventoryManager() {
		items = new HashMap<String, Integer>();

		for (String id : ids) {
			items.put(id, 0);
		}
	}

	
	public void addItem(String itemID, int amount) throws InvalidIDException, InvalidAmountException {

		if (!items.containsKey(itemID)) {
			throw new InvalidIDException("Invalid Item ID: [" + itemID + "]");
		}

		if (amount <= 0) {
			throw new InvalidAmountException("Amount must be greater than 0");
		}

		items.put(itemID, items.get(itemID) + amount);

		System.out.println("Added " + amount + " to [" + itemID + "]");
	}

	public void removeItem(String itemID, int amount)
			throws InvalidIDException, InvalidAmountException, NotEnoughAmountException {

		if (!items.containsKey(itemID)) {
			throw new InvalidIDException("Invalid Item ID: [" + itemID + "]");
		}

		if (amount <= 0) {
			throw new InvalidAmountException("Amount must be greater than 0");
		}

		int currentAmount = items.get(itemID);

		if (currentAmount < amount) {
			throw new NotEnoughAmountException("The amount to withdraw exceeds the current amount");
		}

		items.put(itemID, currentAmount - amount);

		System.out.println("Removed " + amount + " from [" + itemID + "]");
	}

}

public class Application {

	public static void main(String[] args) {

		InventoryManager iman = new InventoryManager();

		try {
			try {
				iman.addItem("a01", 10);
				TimeUnit.MILLISECONDS.sleep(300);
				iman.addItem("a02", 20);
				TimeUnit.MILLISECONDS.sleep(300);
				iman.addItem("b02", 15);
				TimeUnit.MILLISECONDS.sleep(300);

			} catch (InvalidIDException e) {
				System.err.println(e.getMessage());
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
			}

			TimeUnit.SECONDS.sleep(1);

			try {
				iman.removeItem("a01", 5);
				TimeUnit.MILLISECONDS.sleep(300);
				iman.removeItem("a02", 15);
				TimeUnit.MILLISECONDS.sleep(300);
				iman.removeItem("b01", 6);
				TimeUnit.MILLISECONDS.sleep(300);

			} catch (InvalidIDException e) {
				System.err.println(e.getMessage());
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
			} catch (NotEnoughAmountException e) {
				System.err.println(e.getMessage());
			}
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

	}
	
	

}
