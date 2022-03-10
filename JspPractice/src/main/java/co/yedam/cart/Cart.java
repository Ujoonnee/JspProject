package co.yedam.cart;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.user.UserVO;

public class Cart implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		CartService dao = new CartServiceImpl();
		CartVO cart = new CartVO();
		cart.setUserId(user.getUserId());
		
		List<CartListVO> list = dao.selectCart(cart);
		
		request.setAttribute("list", list);
		
		return "cart/cart.jsp";
	}
}
