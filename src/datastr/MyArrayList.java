package datastr;

public class MyArrayList {
	
	private char[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	public MyArrayList() {
		list = new char[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 100000) {
			size = inputSize;
		}
		
		list = new char[size];
	}
	
	private boolean isEmpty() {
		
		return (howManyElements == 0) ? true : false;
	}
	
	private boolean isFull() {
		return(size == howManyElements) ? true : false;
	}
	
	private void resize() {
		int newSize = (howManyElements < 200) ? (size*2) : (int)(size*1.5);
		char[] newList = new char[newSize];
		for(int i = 0; i < howManyElements; i++) {
			newList[i] = list[i];
			
		}
		list = newList;
		size = newSize;
		System.gc();
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		
		list[howManyElements] = element;
		howManyElements++;
	}
	
	public void add(char element, int index) throws IllegalArgumentException {
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams pievienot elementu, jo index ir negativs");
		}
		if(howManyElements < index) {
			throw new IllegalArgumentException("Nav iespejams pievienot elementu, jo indekss ir parak liels");
		}
		if(index == howManyElements) {
			add(element);
			return;
		}
		if(isFull()) {
			resize();
		}
		for(int i = howManyElements;i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = element;
		howManyElements++;
		
	}
}
