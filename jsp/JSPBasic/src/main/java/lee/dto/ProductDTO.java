package lee.dto;

public class ProductDTO {
	private String prodName;
	private int proNum;
	private int price;
	private String color;
	
	public ProductDTO() {
		
	}

	public ProductDTO(String prodName, int proNum, int price, String color) {
		super();
		this.prodName = prodName;
		this.proNum = proNum;
		this.price = price;
		this.color = color;
	}
	

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	@Override
	public String toString() {
		return "productDTO [prodName=" + prodName + ", proNum=" + proNum + ", price=" + price + ", color=" + color
				+ "]";
	}
}
