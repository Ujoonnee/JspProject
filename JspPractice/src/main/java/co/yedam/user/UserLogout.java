package co.yedam.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.product.ProductService;
import co.yedam.product.ProductServiceImpl;
import co.yedam.product.ProductVO;

public class UserLogout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ProductService dao = new ProductServiceImpl();
		
		List<ProductVO> list = dao.selectProductList();
		request.setAttribute("list", list);

		return "main/main.jsp";
	}

}	
