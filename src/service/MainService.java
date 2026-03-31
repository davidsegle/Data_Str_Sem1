package service;

import java.util.Arrays;

import datastr.MyArrayList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyArrayList<Character> = new MyArrayList(3);
		symbols.add('a');// a
		symbols.add('b');// a b
		symbols.add('c');// a b c
		symbols.add('a');// a b c a
		try
		{
			symbols.print();// a b c a
			symbols.add('Z', 1);// a Z b c a
			symbols.print();// a Z b c a
			symbols.remove(2);//a Z c a
			symbols.print();//a Z c a
			System.out.println(symbols.get(1));//Z
			System.out.println(symbols.search('a'));//0 3
			System.out.println(
					Arrays.toString(symbols.getNextElements('a')));//Z
			
			symbols.sort();
			symbols.print();
			symbols.makeEmpty();//padaram tuksu
			symbols.add('W');
			symbols.print();//W
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		MyArrayList<Student> allStudents = new MyArrayList<Student>();
		Student s1 = new Student("Janis", "Berzins", "121212-67890");
		Student s2 = new Student("Baiba", "Jauka", "122323-23456");
		Student s3 = new Student("Liga", "Nejauka", "345675-34567");
		
		try
		{
			allStudents.add(s1);
			allStudents.add(s2);
			allStudents.add(s3);
			allStudents.print();
			System.out.println(allStudents.get(0));	
			System.out.println(allStudents.search(s3));
			System.out.println(Arrays.toString(allStudents.getNextElements(s3)));
			allStudents.sort();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

}