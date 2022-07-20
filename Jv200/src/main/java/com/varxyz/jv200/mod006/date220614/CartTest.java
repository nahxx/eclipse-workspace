package com.varxyz.jv200.mod006.date220614;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("Apple IPad"));
		cart.addProduct(new NoteBook("Samsung GaluxyTad"));
		cart.addProduct(new SmartPhone("Samsung Galuxy"));
		cart.addProduct(new SmartPhone("Apple IPhone"));
		
		System.out.println(cart.getDetails());
	}

}
