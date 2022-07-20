package com.varxyz.jv200.mod003;

public class PassTest {
	public static void changeInt(int value) {
		value = 55;
	}
	
	public static void changeObjectRef(MyDate ref) {
		ref = new MyDate(1, 1, 2000);
	}
	
	/**
	 * 냅의 ref 객체 값을 밖으로 불러오는 메서드
	 * return type에 MyDate를 넣어줘도 되고 Object를 넣어줘도 된다.
	 * return값에는 return할 객체의 클래스이름인 MyDate를 넣어준다.
	 * @param ref
	 * @return ref 값
	 */
	public static MyDate changeObjectRef2(MyDate ref) {
		ref = new MyDate(1, 1, 2000);
		return ref;
	}
	
	public static void changeObjectAttr(MyDate ref) {
		ref.setDay(4);
	}

	public static void main(String[] args) {
		MyDate date;
		int val;
		val = 11;
		changeInt(val);
		System.out.println("int value is " + val); // int value is 11
		
		date = new MyDate(22, 7, 1964);
		System.out.println(changeObjectRef2(date)); // day=1, month=1, year=2000
		
		changeObjectAttr(date);
		System.out.println("MyDate is " + date); // MyDate is day=4, month=7, year=1964
	}

}
