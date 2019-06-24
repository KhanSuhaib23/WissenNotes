import java.util.function.Predicate;

@interface Test {
	String input() default "";
}

enum Direction {
	
	UP(0) {
		String getMessage() {
			return "Going Up";
		}
	},
	DOWN(1) {
		String getMessage() {
			return "Going Down";
		}
	},
	LEFT(2) {
		String getMessage() {
			return "Going Left";
		}
	},
	RIGHT(2) {
		String getMessage() {
			return "Going Right";
		}
	};
	
	int val;
	
	Direction(int value) {
		this.val = value;
	}
	
	int getValue() {
		return val;
	}
	
	String getMessage() {
		return null;
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(Direction.UP.getMessage());
		
		for (Direction dir : Direction.values()) {
			System.out.println(dir.name());
		}
		
		
	}

}
