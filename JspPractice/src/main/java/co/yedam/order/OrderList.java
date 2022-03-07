package co.yedam.order;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.ProductServiceImpl;

public class OrderList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OrderServiceImpl service = new OrderServiceImpl();
		List<OrderVO> orderList = service.selectOrderList();
		request.setAttribute("orderList", orderList);
		
		return "OrderList.jsp";
	}
}
