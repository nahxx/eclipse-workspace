package com.varxyz.jv200.mod009;

import java.util.*;

public class ListExample2 {

	public static void main(String[] args) {
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		System.out.println(listInt); // [1, 2, 3, 4]
		
		ArrayList<String> listStr = new ArrayList<String>();
		listStr.add("abc");
		listStr.add("def");
		listStr.add("ghi");
		System.out.println(listStr); // [abc, def, ghi]
		
		ArrayList<Object> listObj = new ArrayList<Object>();
		listObj.add(listInt);
		listObj.add(listStr);
		listObj.add(listObj);
		System.out.println(listObj); // [[1, 2, 3, 4], [abc, def, ghi], (this Collection)]
		
		// 하나씩 출력하기(요즘 방식)
		for(int n : listInt) {
			System.out.print(n + " "); // 1 2 3 4 
		}
		System.out.println();
		
		for(String s : listStr) {
			System.out.print(s + " "); // abc def ghi 
		}
		System.out.println();
		
		for(Object o : listObj) {
			System.out.print(o + " "); // [1, 2, 3, 4] [abc, def, ghi] [[1, 2, 3, 4], [abc, def, ghi], (this Collection)]
		}
		System.out.println();
		
		// 하나씩 출력하기(예전 방식)
		for(int i = 0; i < listStr.size(); i++) {
			System.out.print(listStr.get(i) + " "); // abc def ghi 
		}
	}

}
