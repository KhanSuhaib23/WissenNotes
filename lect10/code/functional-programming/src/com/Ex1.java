package com;

import java.util.function.Function;

public class Ex1 {
	
	
	
	public static void main(String[] args) {
		
		Function<String, Integer> function1 = s -> {
			return Integer.parseInt(s);
		};
		
		Function<Integer, String> function2 = i -> {
			return i.toString();
		};
		
		
		Function<Function<String, Integer>, Function<String, Integer>> logWrapper = ipFunc -> {
			return s -> {
				System.out.println("before:: LOG");
				int r = ipFunc.apply(s);
				System.out.println("after:: LOG");
				return r;
				
			};
			
		};
		
		Function<String, Integer> f1WithLog = logWrapper.apply(function1);
		
		int r = f1WithLog.apply("1243");
		
		System.out.println(r);
		
		
		
		
	}

}
