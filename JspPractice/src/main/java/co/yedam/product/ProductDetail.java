package co.yedam.product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductDetail implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductServiceImpl service = new ProductServiceImpl();
		int productSerial = Integer.parseInt(request.getParameter("productSerial"));
		
		ProductVO find = new ProductVO();
		find.setProductSerial(productSerial);
		
		find = service.selectProduct(find);
		request.setAttribute("detail", find);
		
		return "product/productDetail.jsp";
	}
}
