package com;

class Nexwave {
	
	public void learningService()
	{
		System.out.println("Learning Service");
	}
	
	public void otherService()
	{
		System.out.println("Other Service");
	}
}


// this is a proxy design pattern 
// we didn't wan't to pollute the original implementation with other stuff
// like authentication and logging
// so we keep the original class sanitary with a single responsibility implementation
// we create a proxy class that does the other stuff and for the actual implementation calls 
// into the og class

class NexwaveProxy extends Nexwave {
	
	public void learningService()
	{
		System.out.println("Authentition...");
		System.out.println("Log In...");
		super.learningService();
		System.out.println("Log Out...");
	}
	
	public void otherService()
	{
		System.out.println("Authentition...");
		System.out.println("Log In...");
		super.otherService();
		System.out.println("Log Out...");
	}
	
}

public class Application {

	public static void main(String[] args) {

		NexwaveProxy nwp = new NexwaveProxy();
		
		nwp.learningService();
		
		System.out.println("-------------------------");
		
		nwp.otherService();
	}

}
