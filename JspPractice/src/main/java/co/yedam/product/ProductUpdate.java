package co.yedam.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductUpdate implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductService service = new ProductServiceImpl();
		ProductVO product = new ProductVO();
		ProductVO productSelect = service.selectProduct(product);
		request.setAttribute("productSelect", productSelect);
		
		String productThumbnail = request.getParameter("productThumbnail");
		String productName = request.getParameter("productName");
		String productCategory1 = request.getParameter("productCategory1");
		String productCategory2 = request.getParameter("productCategory2");
		String productInfo = request.getParameter("productInfo");
		int productStock = Integer.parseInt(request.getParameter("productStock"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		product = new ProductVO();
		product.setProductThumbnail(productThumbnail);
		product.setProductName(productName);
		product.setProductCategory1(productCategory1);
		product.setProductCategory2(productCategory2);
		product.setProductInfo(productInfo);
		product.setProductStock(productStock);
		product.setProductPrice(productPrice);
		
		
		service.updateProduct(product);
		
		return "product/productUpdate.jsp";
	}
}
