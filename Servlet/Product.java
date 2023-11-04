package Servlets;

public class Product {
	private String id;
	private String name;
	private String type;
	private int price;
	private String image;
	
	public Product() {
	}
	public Product(String id, String name, String type, int price, String image){
		 this.id=id;
		 this.name=name;
		 this.type=type;
		 this.price=price;
		 this.image=image;
	}
	public Product(String id, String name, String type){
		 this.id=id;
		 this.name=name;
		 this.type=type;
	}
	public Product(Product pd){
		 this.id=pd.id;
		 this.name=pd.name;
		 this.type=pd.type;
		 this.price=pd.price;
		 this.image=pd.image;
	}
	 public String getId() {
		 return id;
	 }
	 public String getName() {
		 return name;
	 }
	 public String getType() {
		 return type;
	 }
	 public int getPrice() {
		 return price;
	 }
	 public String getImage() {
		 return image;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public void setType(String type) {
		 this.type = type;
	 }
	 public void setPrice(int price) {
		 this.price = price;
	 }
	 public void setImage(String image) {
		 this.image=image;
	 }
}