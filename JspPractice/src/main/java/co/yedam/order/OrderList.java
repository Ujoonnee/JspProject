package co.yedam.order;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class OrderList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OrderService dao = new OrderServiceImpl();
		List<OrderVO> orderList = dao.selectOrderList();
		request.setAttribute("orderList",orderList);

		return "order/orderList.jsp";
	}
}
