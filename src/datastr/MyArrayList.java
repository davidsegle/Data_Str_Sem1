package datastr;

import java.util.ArrayList;

public class MyArrayList<Ttype> {
	
	private Ttype[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	public MyArrayList() {
		list = (Ttype[]) new Object[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 100000) {
			size = inputSize;
		}
		
		list =(Ttype[]) new Object[size];
	}
	
	private boolean isEmpty() {
		
		return (howManyElements == 0) ? true : false;
	}
	
	private boolean isFull() {
		return(size == howManyElements) ? true : false;
	}
	
	private void resize() {
		int newSize = (howManyElements < 200) ? (size*2) : (int)(size*1.5);
		Ttype[] newList =(Ttype[]) new Object [newSize];
		for(int i = 0; i < howManyElements; i++) {
			newList[i] = list[i];
			
		}
		list = newList;
		size = newSize;
		System.gc();
	}
	
	public void add(Ttype element) {
		if(isFull()) {
			resize();
		}
		
		list[howManyElements] = element;
		howManyElements++;
	}
	
	public void add(Ttype element, int index) throws IllegalArgumentException {
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
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public void remove(int index) throws Exception {
		if(isEmpty()) {
			 throw new Exception("Sarkasts ir tukss");
		}
		if(index < 0) {
			 throw new Exception("Indekss nevar but negativs");
		}
		if(index >= howManyElements) {
			 throw new Exception("Indekss nevar but lielaks vai vienads ar elementu skaitu");
		}
		for(int i = index; i < howManyElements-1; i++) {
			list[i] = list[i+1];
		}
		list[howManyElements-1] = null;
		howManyElements--;
		
	}
	
	public Ttype get(int index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss");
		}
		if(index < 0) {
			throw new IllegalArgumentException("Indekss nevar but negativs");
			
		}
		if(index >=howManyElements) {
			throw new IllegalArgumentException("Nav iespejams iegut elementu, jo indekss ir lielaks vai vienads ar elementu skaitu");
		}
		
		return list[index];
	}
	
	public ArrayList<Integer> search(Ttype element) throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss");
		}
		ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
		for(int i=0;i < howManyElements;i++) {
			if(list[i] .equals(element)) {
				indexArrayList.add(i);
			}
		}
		if(indexArrayList.isEmpty()) {
			throw new Exception("Mekletais elements " + element + "neatrodas saraksta");
		}
		
		return indexArrayList;
	}
	
	public Ttype[] getNextElements(Ttype element) throws Exception{
		ArrayList<Integer> arrayListForIndexes = search(element);
		
		int howManyNextElements = arrayListForIndexes.size();
		if(arrayListForIndexes.get(arrayListForIndexes.size()-1) == howManyElements-1 ) {
			howManyNextElements--;
		}
		Ttype [] nextElements =(Ttype[]) new Object [howManyNextElements];
		int indexForNextElementArray = 0;
		
		for(int i=0; i < howManyNextElements;i++) {
			int nextElementIndex = arrayListForIndexes.get(i)+1;
			nextElements[indexForNextElementArray] = list[nextElementIndex];
			indexForNextElementArray++;
		}
		
		return nextElements;
		
	}
	
	public void sort() throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss");
		}
		
		for(int i=0; i<howManyElements;i++) {
			for(int j=0; j < howManyElements;j++) {
				if( ((Comparable)list[i]).compareTo(list[j]) > 0) {
					Ttype temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukss");
		}
		
		for(int i=0;i < howManyElements; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		list = null;
		System.gc();
		howManyElements = 0;
		size = DEFAULT_SIZE;
		list = (Ttype[])new Object[size];
	}
	
	
}
