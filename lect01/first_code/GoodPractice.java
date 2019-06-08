package com.wissen.trial;

// have atleast a three level package
// compile using javac -d ./bin GoodPratice.javac
// then go into the bin folder
// run using java com.wissen.trial.GoodPractice

public class GoodPractice
{
	public static boolean ValidSSN(String input)
	{
		int len = input.length();
		if (len != 11) return false;
		
		for (int i = 0; i < len; i++)
		{
			char ch = input.charAt(i);
			if (i == 3 || i == 6)
			{
				if (ch != '-') return false;
			}
			else 
			{
				if (ch < '0' || ch > '9') return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args)
	{
		String str = null;
		
		
		str = "123-45-6789";
		System.out.println(str + " : " + ValidSSN(str));
		
		
		str = "123-45-67899";
		System.out.println(str + " : " + ValidSSN(str));
		
		str = "123545-6789";
		System.out.println(str + " : " + ValidSSN(str));
		
		str = "123-45_6789";
		System.out.println(str + " : " + ValidSSN(str));
		
		str = "123-45-6a89";
		System.out.println(str + " : " + ValidSSN(str));
	}
}