package co.yedam.product;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductServiceImpl service = new ProductServiceImpl();
		List<ProductVO> productList = service.selectProductList();
		
		request.setAttribute("productList", productList);
		
		return "ProductList.jsp";
	}
}
