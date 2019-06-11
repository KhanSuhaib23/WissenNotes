package com.app;

import java.util.Iterator;

class LinkedList<T> implements Iterable<T> {
	
	class Element {
		public T value;
		public Element next;
	}

	class LinkedListIterator implements Iterator<T> {

		Element curr;
		int remain;

		public LinkedListIterator(LinkedList<T> ll) {
			curr = ll.start();
			remain = ll.length();
		}

		@Override
		public boolean hasNext() {
			return remain != 0;
		}

		@Override
		public T next() {
			T data = curr.value;
			curr = curr.next;
			remain--;

			return data;
		}

	}

	private int length;
	private Element start;
	private Element end;

	public LinkedList() {
		length = 0;
		start = null;
		end = null;
	}

	public int length() {
		return length;
	}

	public Element start() {
		return start;
	}

	public void add(T data) {
		Element lle = new Element();

		lle.value = data;
		lle.next = null;

		if (start == null) {
			start = lle;
			end = lle;
		} else {

			end.next = lle;
			end = lle;
		}

		length++;
	}

	public void add(int index, T data) {
		if (index > length)
			throw new ArrayIndexOutOfBoundsException(
					"Trying to add to index [" + index + "] on list of length [" + length + "]");

		Element lle = new Element();
		lle.value = data;
		lle.next = null;

		Element prev = null;
		Element curr = start;

		for (int i = 0; i < index; i++) {
			prev = curr;
			curr = curr.next;
		}

		if (prev == null) {
			lle.next = start;
			start = lle;
		} else if (curr == null) {
			prev.next = lle;
			end = lle;
		} else {
			lle.next = curr;
			prev.next = lle;
		}

		length++;
	}

	public void set(int index, T data) {
		if (index >= length)
			throw new ArrayIndexOutOfBoundsException(
					"Trying to set index [" + index + "] on list of length [" + length + "]");

		Element curr = start;

		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		curr.value = data;
	}

	public T get(int index) {
		if (index >= length)
			throw new ArrayIndexOutOfBoundsException(
					"Trying to get index [" + index + "] on list of length [" + length + "]");

		Element curr = start;

		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		return curr.value;
	}

	public T remove(int index) {
		if (index >= length)
			throw new ArrayIndexOutOfBoundsException(
					"Trying to remove index [" + index + "] on list of length [" + length + "]");

		Element prev = null;
		Element curr = start;

		for (int i = 0; i < index; i++) {
			prev = curr;
			curr = curr.next;
		}

		if (prev == null) {
			start = start.next;
		} else {
			prev.next = curr.next;
			if (prev.next == null) {
				end = prev;
			}
		}

		length--;

		if (length == 0) {
			start = null;
			end = null;
		}

		return curr.value;

	}

	public T remove(T value) {

		Element prev = null;
		Element curr = start;

		while (curr != null) {
			if (curr.value.equals(value)) {
				if (prev == null) {
					start = curr.next;
				}
				else if (curr.next == null) {
					end = prev;
				} else
				{
					prev.next = curr.next;
				}

				length--;

				if (length == 0) {
					start = null;
					end = null;
				}

				return curr.value;
			}

			prev = curr;
			curr = curr.next;
		}

		return null;
	}

	public void reverse() {

		Element prev = null;
		Element curr = start;

		for (int i = 0; i < length; i++) {
			Element next = curr.next;

			curr.next = prev;

			prev = curr;
			curr = next;
		}

		end = start;
		start = prev;

	}

	public void clear() {
		start = null;
		end = null;
		length = 0;
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator(this);
	}

	public String toString() {

		String temp = "List(" + length + ") : [";

		Element curr = start;

		for (int i = 0; i < length; i++) {
			temp += curr.value.toString() + " ";
			curr = curr.next;
		}

		temp += "]";

		return temp;
	}
}

public class Application {
	
	public static void stringTest() {
		LinkedList<String> list = new LinkedList<String>();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("5");

		System.out.println(list);

		list.add(3, "4");
		list.add(0, "0");
		list.add(6, "6");

		list.add("7");
		list.add("8");

		System.out.println(list);

		list.remove(6);
		list.remove(2);
		list.remove(0);

		System.out.println(list);

		list.remove("1");
		list.remove("4");
		list.remove("5");
		list.remove("3");

		System.out.println(list);

		list.clear();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");

		System.out.println(list);

		list.reverse();

		System.out.println(list);

		Iterator<String> iter = list.iterator();

		System.out.println("-------------------------------------");

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("-------------------------------------");
	}
	
	public static void integerTest() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);

		System.out.println(list);

		list.add(3, 4);
		list.add(0, 0);
		list.add(6, 6);

		list.add(7);
		list.add(8);

		System.out.println(list);

		list.remove(6);
		list.remove(2);
		list.remove(0);

		System.out.println(list);

		list.remove(new Integer(1));
		list.remove(new Integer(4));
		list.remove(new Integer(5));
		list.remove(new Integer(3));

		System.out.println(list);

		list.clear();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(list);

		list.reverse();

		System.out.println(list);

		Iterator<Integer> iter = list.iterator();

		System.out.println("-------------------------------------");

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("-------------------------------------");
	}

	public static void main(String[] args) {

		integerTest();
	}

}
