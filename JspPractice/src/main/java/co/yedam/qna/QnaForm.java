package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.order.OrderService;
import co.yedam.order.OrderServiceImpl;
import co.yedam.order.OrderVO;
import co.yedam.user.UserVO;

public class QnaForm implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("qnqFormdo");
		UserVO user = (UserVO) session.getAttribute("user");
		request.setAttribute("user", user);
		
		OrderService dao = new OrderServiceImpl();
		OrderVO order = new OrderVO();
		order.setUserId(user.getUserId());
		List<OrderVO> list = dao.selectOrder(order);
		
		request.setAttribute("orderList", list);
		
		
		return "qna/qnaForm.jsp";
	}
}
