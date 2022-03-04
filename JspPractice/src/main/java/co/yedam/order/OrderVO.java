package co.yedam.order;

public class OrderVO {
	private String orderNum;
	private String userId;
	private int productSerial;
	private int ProductQuantity;
	private String orderDate;
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

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
