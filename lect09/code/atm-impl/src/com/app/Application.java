package com.app;

abstract class Dispensor {
	public int value;
	public int quantity;
	public Dispensor next;
	
	public Dispensor(int quantity) {
		this.quantity = quantity;
	}
	
	public int withdraw(int amount) {
		
		int needed = amount / value;
		
		int used = Math.min(needed, quantity);
		
		
		amount -= used * value;
		
		
		int ret = next.withdraw(amount);
		
		if (ret == -1) {
			return -1;
		} else if (ret == -2) {
			if (quantity != 0) {
				System.out.println("Enter the value in denomination of [ " + value + " ]");
				return -1;
			} else {
				System.out.println("Out of currency of denomination [ " + value + " ]");
				return -2;
			}
			
		}
		
		quantity -= used;
		
		System.out.println("Rs. " + value + " : " + used);
		
		return 0;
		
	}
	
	
} 

class DispensorHigh extends Dispensor {
	
	public DispensorHigh(int quantity) {
		super(quantity);
		
		this.value = 0;
	}
	
	public int withdraw(int amount) {
		
		int ret = next.withdraw(amount);
		
		if (ret == -1) {
			System.out.println("Transaction Unsucessfull...");
			return -1;
		} else if (ret == -2) {
			System.out.println("Not enough money in the ATM");
			System.out.println("Transaction Unsucessfull...");
			return -1;
		} else {
			System.out.println("Transaction Sucessfull...");
			return 0;
		}
		
	}
	
}


class DispensorLow extends Dispensor {
	
	public DispensorLow(int quantity) {
		super(quantity);
		
		this.value = 0;
	}
	
	public int withdraw(int amount) {
		if (amount != 0) {
			return -2;
		} else
		{
			return 0;
		}
	}
	
}

class Dispensor100 extends Dispensor{
	
	public Dispensor100(int quantity) {
		super(quantity);
		
		this.value = 100;
	}

}

class Dispensor500 extends Dispensor{
	
	public Dispensor500(int quantity) {
		super(quantity);
		
		this.value = 500;
	}

}

class Dispensor1000 extends Dispensor{
	
	public Dispensor1000(int quantity) {
		super(quantity);
		
		this.value = 1000;
	}

}

class ATM {
	
	public int amount;
	
	DispensorLow dlow;// = new DispensorLow(0);
	Dispensor100 d100;// = new Dispensor100(3);
	Dispensor500 d500;// = new Dispensor500(2);
	Dispensor1000 d1000;// = new Dispensor1000(1);
	DispensorHigh dhigh;// = new DispensorHigh(0);
	
	public ATM(int amount) {
		
		this.amount = amount;
		
		dlow = new DispensorLow(0);
		d100 = new Dispensor100(10);
		d500 = new Dispensor500(6);
		d1000 = new Dispensor1000(3);
		dhigh = new DispensorHigh(0);
		
		dhigh.next = d1000;
		d1000.next = d500;
		d500.next = d100;
		d100.next = dlow;
		
		
		
	}
	
	public void withdraw(int toWithdraw) {
		
		if (toWithdraw < amount) {
			if (dhigh.withdraw(toWithdraw) == 0) {
				System.out.println("Amount Left: " + (amount - toWithdraw) );
				amount -= toWithdraw;
			}
		} else {
			System.out.println("Not enough amount");
		}
		
	}
	
}


public class Application {
	
	public static void main(String[] args) {
		
		ATM atm = new ATM(5000000);
		
		atm.withdraw(4800);
		
	}

}
