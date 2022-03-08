package co.yedam.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.ProductService;
import co.yedam.product.ProductServiceImpl;
import co.yedam.product.ProductVO;

public class Main implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		ProductService dao = new ProductServiceImpl();

		List<ProductVO> list = dao.selectProductList();
		request.setAttribute("list", list);

		return "main/main.jsp";
	}
}
