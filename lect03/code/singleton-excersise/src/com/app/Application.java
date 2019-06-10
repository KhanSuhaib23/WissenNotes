package com.app;

// singleton design principle
// we want there to be a single instance of the class at a time
// therefore we first make the constructor private
// next we give a single point through which the user can get their instance
// this function creates a new instance is there was none
// else just returns the static singleton object

class Single
{
	public int id;
	public String name;
	
	private static Single singleton;
	
	private Single(int id, String name)
	{
		this.id = id;
		this.name = name;
		singleton = this;
	}
	
	public static synchronized Single getInstance()
	{
		if (singleton == null) 
		{
			singleton = new Single(0, null);
		}
		
		return singleton;
	}
	
}

public class Application {
	
	public static void main(String[] args) {
		
		Single s1 = Single.getInstance();
		
		s1.id = 101;
		s1.name = "Suhaib";
		
		Single s2 = Single.getInstance();
		
		s2.name = "Karan";
		
		System.out.println(s1.id + " -> " + s1.name);
		
		
		
	}

}
