package testg;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Emp {
	int id;
	String name;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 10202;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

}

public class PerfTest {

	public static void main(String[] args) {

		Map<String, Integer> al = new TreeMap<>();

		
		al.put("ABC", 1);
		al.put("PBC", 2);
		al.put("DBC", 3);
		al.put("DDC", 4);
		
		
		Set<Entry<String, Integer>> iter = al.entrySet();
		
		for (Entry<String, Integer> it : iter) {
			it.getValue();
			it.getKey();
		}
//		
//		for (Entry<String, Integer> iter : al.entrySet()) {
//			
//		}

		
		System.out.println(al);
	}

}
