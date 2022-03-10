package co.yedam.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;


public class ProductUpdateForm implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int productSerial = Integer.parseInt(request.getParameter("productSerial"));
		ProductService service = new ProductServiceImpl();
		ProductVO product = new ProductVO();
		product.setProductSerial(productSerial);
		ProductVO productSelect = service.selectProduct(product);
		request.setAttribute("productSelect", productSelect);
		return "product/productUpdateForm.jsp";
	}
<<<<<<< HEAD
=======

>>>>>>> refs/heads/PJY
}
