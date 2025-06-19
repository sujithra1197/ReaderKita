package Baseclass;

import org.checkerframework.checker.units.qual.s;

public class Practice{

	int a = 1;
	String b = "String";
	char c = 'A';

	public void suji() {
		System.out.println("output");

	}

	public void sujitwo() {

		System.out.println("output2");

	}


	public void sujithree() {
		int a = 1;
		int b = 2;
		int c = (a+b);
		System.out.println(c);
	}

	public void sujifour(int no) {
		
		int a = no;
		int b = 2;
		int c = (a+b);
		
	}
	
	public void sujifive(String name) {
		
		String a = "name";
		System.out.println(name);
	}
		
	
	
	
	
	
	public static void main(String[]args) {

		Practice a = new Practice();
		a.suji();
		a.sujitwo();
		Practice b = new Practice();
		b.sujithree();
		a.sujifour(1);
		b.sujifive("Arun");
		
		String obj1 ="abc";
		String obj2 = "abc";
		
		System.out.println("compare rsult:"+ obj1.compareToIgnoreCase(obj2));
		if (obj1.compareToIgnoreCase(obj2) == 0) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		

	}














}
