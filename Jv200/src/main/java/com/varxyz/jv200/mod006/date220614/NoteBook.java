package com.varxyz.jv200.mod006.date220614;

public class NoteBook extends Product{
	private boolean apple = false;
	
	public NoteBook(String name) {
		super(name);
		if(getName().startsWith("Apple")) {
			apple = true;
		}
	}
	
	public double getPrice() {
		return 25000.0;
	}
	
	public String getOs() {
		if(apple) {
			return "Mac OS";
		} else {
			return "Windows";
		}
	}
}
