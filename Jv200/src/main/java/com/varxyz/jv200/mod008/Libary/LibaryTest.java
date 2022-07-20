package com.varxyz.jv200.mod008.Libary;

public class LibaryTest {

	public static void main(String[] args) {
		Libary lib = Libary.getLibary(); // 메소드 사용하여 libary 객체 생성
		
		for(int i = 1; i < 50; i++) {
			Book b = new Book("책" + i);
			lib.addBook(b);
		}
		System.out.println(lib.getBook(25)); // 대출 성공
		System.out.println(lib.getBook(99)); // 대출 불가
		System.out.println(lib.getBook(150)); // 대출 불가
		
		
		System.out.println("\n제2도서관");
		Libary lib2 = Libary.getLibary();
		System.out.println(lib2.getBook(49)); // 대출 성공
		System.out.println(lib2.getBook(50)); // 대출 불가
		
		Book b2 = new Book("2도서관의 책");
		lib2.addBook(b2);
		System.out.println(lib2.getBook(50)); // 대출 성공
	}

}
