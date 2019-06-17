package com.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestMethod {

	public String testName();

	public String[] inputs();

	public String[] outputs();

}

class Tester {

	public static void runTesters(String classPath) throws ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> cls = Class.forName(classPath);

		Object instance = cls.newInstance();

		Method[] methods = cls.getMethods();

		for (Method method : methods) {

			TestMethod tm = method.getAnnotation(TestMethod.class);

			if (tm != null) {

				System.out.println("######### " + tm.testName() + " #########");
				
				String[] inputs = tm.inputs();
				String[] outputs = tm.outputs();
				
				int ind = 0;
				
				for (String input : inputs) {
					String str = (String) method.invoke(instance, (Object) input);
					
					System.out.println("Actual Output: " + str + ", Expected Output : " + outputs[ind]);
					System.out.println((outputs[ind].equals(str) ? "Pass" : "Fail"));
					System.out.println("----------------------------------");
					ind++;
				}
				
			}

		}

	}

}

class UnderTest {
	@TestMethod(testName = "T01", inputs = {"ip1", "ip2", "ip3"}, outputs = {"op1", "op2", "op3"})
	public String myMethod(String input) {
		String output = "op" + input.charAt(2);
		return output;
	}

	@TestMethod(testName = "T02", inputs = {"input1", "input2", "input3"}, outputs = {"output1", "output2", "output3"})
	public String myMethod2(String input) {
		
		return "output2";
	}
}

public class AnnotationEx {

	public static void main(String[] args) {

		try {
			Tester.runTesters("com.app.UnderTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

	}
}
