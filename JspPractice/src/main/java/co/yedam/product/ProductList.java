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
		
		request.setAttribute("productList",productList);
		
		/*List<ProductVO> list = (List<ProductVO>) request.getAttribute("productList");
		for (ProductVO slist : list) {
			System.out.println(slist.getProductName());
			System.out.println(slist.getProductPrice());
		}*/
		return "product/productList.jsp";
	}
}
