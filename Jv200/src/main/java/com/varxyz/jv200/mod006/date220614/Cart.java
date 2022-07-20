package com.varxyz.jv200.mod006.date220614;

public class Cart {
	private Product[] products = new Product[4];
	
	public void addProduct(Product p) {
		for(int i = 0; i < products.length; i++) {
			if(products[i] == null) {
				products[i] = p;
				break;
			}
		}
	}
	
	public Product[] getProducts() {
		return products;
	}
	
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		for(Product p : products) {
			sb.append("Name: ");
			sb.append(p.getName());
			sb.append("\nPrice: ");
			sb.append(p.getPrice());
			if(p instanceof SmartPhone) {
				SmartPhone s = (SmartPhone) p;
				sb.append("\nPlatform: ");
				sb.append(s.getPlatform());
			} else if(p instanceof NoteBook) {
				NoteBook n = (NoteBook) p;
				sb.append("\nOs: ");
				sb.append(n.getOs());
			}
			sb.append("\n----------------------\n");
		}
		return sb.toString();
	}
}
