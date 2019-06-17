package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
	public int id;
	public String name;
	public double price;
	
	
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}

class Utils {
	public static List<Product> filter(List<Product> ip, Predicate<Product> cond) {
		
		List<Product> op = new ArrayList<Product>();
		
		for (Product pro : ip) {
			if (cond.test(pro)) {
				op.add(pro);
			}
		}
		
		return op;
		
	}
}

public class Ex1 {
	
	public static List<Product> matchProductName(List<Product> ip, String name) {
		return Utils.filter(ip, (p) -> p.name == name);
	}
	
	public static List<Product> rangePrice(List<Product> ip, double min, double max) {
		return Utils.filter(ip, (p) -> (p.price >= min && p.price <= max));
	}
	
	public static void display(List<Product> ip) {
		for (Product i : ip) {
			System.out.println(i);
		}
	}
	
	public static void display(Product[] ip) {
		for (Product i : ip) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(101, "item-1", 1000));
		products.add(new Product(102, "item-2", 5000));
		products.add(new Product(103, "item-3", 3000));
		products.add(new Product(104, "item-4", 7000));
		products.add(new Product(105, "item-5", 500));
		products.add(new Product(106, "item-6", 9000));
		products.add(new Product(107, "item-7", 10000));
		
		
		display(rangePrice(products, 3000, 9000));
		System.out.println("-----------------------------");
		display(matchProductName(products, "item-1"));
		System.out.println("-----------------------------");
		
		display(products.stream().filter(p -> p.id == 101).collect(Collectors.toList())); 
	}

}
