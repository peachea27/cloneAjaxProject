package lee.inheritance.ex1;

public class Product {

	public String name;
	public int price;
	int priceArr[]= new int[3];
	static int i = 0;
	int sum=0;
	
	public void Product(String name, int price) {
		
		this.name=name;
		this.price=price;
		priceArr[i]=price;
		i++;
	
		
	}
	
	public void total() {
		for ( int i = 0; i < priceArr.length-1 ; i ++) {
			sum += priceArr[i];
		}
		System.out.println("총가격 : " +sum);
	}
	
}
