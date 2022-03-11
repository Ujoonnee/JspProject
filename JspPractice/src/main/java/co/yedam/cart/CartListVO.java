package co.yedam.cart;

public class CartListVO {
	private String productName;
	private String productThumbnail;
	private int productSerial;
	private int productPrice;
	private int productQuantity;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductThumbnail() {
		return productThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}
	
	public int getProductSerial() {
		return productSerial;
	}
	public void setProductSerial(int productSerial) {
		this.productSerial = productSerial;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	
	
}
