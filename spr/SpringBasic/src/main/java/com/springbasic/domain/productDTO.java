package com.springbasic.domain;

public class productDTO {
	private String prodNo;
	private String prodName;
	private int price;
	
	//기본생성자
	public productDTO() {}
	
	public productDTO(String prodNo, String prodName, int price) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.price = price;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "productDTO [prodNo=" + prodNo + ", prodName=" + prodName + ", price=" + price + "]";
	}
	
}
