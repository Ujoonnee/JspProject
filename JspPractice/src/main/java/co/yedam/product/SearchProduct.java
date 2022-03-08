package co.yedam.product;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class SearchProduct implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductServiceImpl service = new ProductServiceImpl();
		
			List<ProductVO> searchList = service.searchProductList(request.getParameter("keyword"));
			request.setAttribute("searchList",searchList);
		
		request.setAttribute("keyword", request.getParameter("keyword"));
		
		return "product/productList.jsp";
	}
}
