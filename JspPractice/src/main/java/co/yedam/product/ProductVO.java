package co.yedam.product;

public class ProductVO {
	private int productSerial;
	private String productName;
	private String productCategory1;
	private String productCategory2;
	private String productThumbnail;
	private String productInfo;
	private int productStock;
	private int productPrice;




	public int getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(int productSerial) {
		this.productSerial = productSerial;
	}

	public String getProductCategory1() {
		return productCategory1;
	}

	public void setProductCategory1(String productCategory1) {
		this.productCategory1 = productCategory1;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory2() {
		return productCategory2;
	}

	public void setProductCategory2(String productCategory2) {
		this.productCategory2 = productCategory2;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}