package co.yedam.cart;

public class CartVO {
	private int userNum;
	private String productThumbnail;
	private String productOption1;
	private String productOption2;
	private int productQuantity;
	private int productPrice;
	private String cartDate;
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getProductThumbnail() {
		return productThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}
	public String getProductOption1() {
		return productOption1;
	}
	public void setProductOption1(String productOption1) {
		this.productOption1 = productOption1;
	}
	public String getProductOption2() {
		return productOption2;
	}
	public void setProductOption2(String productOption2) {
		this.productOption2 = productOption2;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getCartDate() {
		return cartDate;
	}
	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}
	
	
}
