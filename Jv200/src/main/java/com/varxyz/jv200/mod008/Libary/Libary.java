package com.varxyz.jv200.mod008.Libary;
/*
 * 문제
- 대학의 모든 도서정보는 하나의 도서관(저장소)에 보관 및 등록된다고 가정
- 각 학과(학부)에서 구매한 책들은 모두 이 도서관 도서정보에 등록되어야  한다고 가정
- 책을 대출할 때 책의 고유번호(serial)를 통해 검색되어 대출된다고 가정
- 도서관에서 책을 보관할 수 있는 정보의 최대치는 100권이며 초과시 자동으로 이전 저장소 크기의 2배로 증가된다고 가정

도서관 = Libary
책 = Book
책정보 등록 = addBook(Book book)
책 대출 = getBook(int serial)
*/

final class Libary {
	protected static Book[] books = new Book[100];
	private static Libary libary = new Libary(); // Libary 객체를 한번만 생성
	private int maxInfo = 100;
	protected int serial;

	/**
	 * 객체 가져오는 메서드
	 * @return 
	 */
	public static Libary getLibary() {
		return libary;
	}
	
	/**
	 * 책 정보등록하는 메서드
	 * @param book
	 */
	public void addBook(Book book) {
		// 배열(저장소)이 꽉 찼다면 배열 공간 두배로 만들기
		if(books[books.length - 1] != null) {
			maxInfo *= 2;
			Book[] books2 = new Book[maxInfo];
			for(int i = 0; i < books.length; i++) {
				books2[i] = books[i];
			}
			books = books2;
		}
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) { // 배열 i요소가 비어있다면
				book.setSerial(++serial);
				books[i] = book;
				System.out.println("책 등록 => 제목: " + book.getName() + ", 고유번호: " + book.getSerial());
				System.out.println("책 등록 완료!\n");
				break;
			}
		}
	}
	
	/**
	 * 책 대출 메서드
	 * @param serial
	 */
	public String getBook(int serial) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null) {
				if(books[i].getSerial() == serial) {
					return "대출 성공! => 제목: " + books[i].getName() + ", 고유번호: " + books[i].getSerial();
				}
			}
		}
		return "대출 불가!";
	}
	
}
