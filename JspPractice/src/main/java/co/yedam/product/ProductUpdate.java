package co.yedam.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductUpdate implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String productThumbnail = request.getParameter("productThumbnail");
		String productName = request.getParameter("productName");
		String productCategory1 = request.getParameter("productCategory1");
		String productCategory2 = request.getParameter("productCategory2");
		String productInfo = request.getParameter("productInfo");
		String productOption1 = request.getParameter("productOption1");
		String option1Detail = request.getParameter("option1Detail");
		String productOption2 = request.getParameter("productOption2");
		String option2Detail = request.getParameter("option2Detail");
		int productStock = Integer.parseInt(request.getParameter("productStock"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		ProductVO product = new ProductVO();
		product.setProductThumbnail(productThumbnail);
		product.setProductName(productName);
		product.setProductCategory1(productCategory1);
		product.setProductCategory2(productCategory2);
		product.setProductInfo(productInfo);
		product.setProductOption1(productOption1);
		product.setOption1Detail(option1Detail);
		product.setProductOption2(productOption2);
		product.setOption2Detail(option2Detail);
		product.setProductStock(productStock);
		product.setProductPrice(productPrice);
		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(product);
		
		return "product/productUpdate.jsp";
	}
}
