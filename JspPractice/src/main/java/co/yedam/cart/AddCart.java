package co.yedam.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class AddCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		CartService dao = new CartServiceImpl();
		
		CartVO vo = new CartVO();
		
		vo.setUserId(request.getParameter("userId"));
		vo.setProductSerial(Integer.parseInt(request.getParameter("productSerial")));
		vo.setProductQuantity(Integer.parseInt(request.getParameter("productQuantity")));
		
		dao.insertCart(vo);
		
		
		return "cart/cart.do";
	}

}
