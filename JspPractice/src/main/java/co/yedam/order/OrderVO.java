package co.yedam.order;

public class OrderVO {
	private String orderNum;
	private int userNum;
	private int productSerial;
	private int ProductQuantity;
	private String orderDate;
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getProductSerial() {
		return productSerial;
	}
	public void setProductSerial(int productSerial) {
		this.productSerial = productSerial;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	

	
	
}
