package Baseclass;

public class Practice2 {
	String Suji = "1";
	int number = 123;
	char m = 1;

	public void secondclass() {
		System.out.println("secondclass");

	}

	public static void thirdclass() {

		System.out.println("thirdclass");

	}

	public void fourclass() {
		System.out.println("bottle");

	}

	public void add() {
		int a = 1;
		int b = 2;
		int c = (a + b);
		System.out.println(c);

	}

	public void sub() {
		int a = 4;
		int b = 2;
		int c = (a - b);
		System.out.println(c);
	}

	public void add(int no) {
		int a = no;
		int b = 2;
		int c = (a + b);
		System.out.println(c);
	}

	public void add1(String name) {
		System.out.println(name);
	}

	public static void main(String[] args) {

		// Practice2 w = new Practice2();
		// w.secondclass();
		// Practice2.thirdclass();
		// w.fourclass();
		// w.add();
		// w.sub();
		// w.add(5);
		// w.add(123);
		// w.add1("abcd");
		
		//If else
		
		String searchresult = "Sujithra";
		String searchresult1 = "Sujithra";
		if (searchresult.equals(searchresult1)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		int num = 89;
		int ans = 12;
		if (num == ans) {
			System.out.println("Number Pass");

		} else {
			System.out.println("Number Fail");
		}
		
		// Nested if

		int a = 4;
		int b= 2;
		int c = 3;
		
		if(a>b) {
			if(a>c) {
				System.out.println("A is greater::"+a);
			} else {
				System.out.println("C is greater::"+c);
			}
		}
		else {
			if(b>c) {
				System.out.println("B is greater::"+b);
			} else {
				System.out.println("C is greater::"+c);
			}
		}

		//ELSE IF
		
		
	int x = 1;
		int y = 3;
		int z = 4;

		if (x > y) {
			System.out.println("x is greater");
		} else if (y > z) {
			System.out.println("y ia greater");
		} else {
			System.out.println("z ia greater");
		}

	}

	// String concept
	
//	String str = "A is greater::"+a;
//	
//	String s1 , s2, s3;
//	s1 = "1";
//	//s2 = "2";
//	s3 = s1+b;
//	
//	System.out.println(c);
//	System.out.println(s3);
	
	
	
	
}
