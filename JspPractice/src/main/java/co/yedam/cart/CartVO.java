package co.yedam.cart;

public class CartVO {
	private String userId;
	private int productSerial;
	private int productQuantity;
	private int productPrice;
	private String cartDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductSerial() {
		return productSerial;
	}
	public void setProductSerial(int productSerial) {
		this.productSerial = productSerial;
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
