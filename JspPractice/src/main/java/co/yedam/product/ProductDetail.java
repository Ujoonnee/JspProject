package co.yedam.product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductDetail implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int productSerial = Integer.parseInt(request.getParameter("productSerial"));
		ProductVO find = new ProductVO();
		find.setProductSerial(productSerial);
		ProductServiceImpl service = new ProductServiceImpl();
		ProductVO productList = service.selectProduct(find);
		request.setAttribute("detail", productList);
		return "product/productDetail.jsp";
	}
}
