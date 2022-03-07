package co.yedam.order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class OrderList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OrderService dao = new OrderServiceImpl();
		List<OrderVO> orderList = dao.selectOrderList();
		Map< String, Object > arrMap = new HashMap<>();

		for (OrderVO orderVO : orderList) {
			//System.out.println(orderVO.getProductName()); 
			arrMap.put("orderNum", orderVO.getOrderNum());
			arrMap.put("productName", orderVO.getProductName());
			arrMap.put("userId", orderVO.getUserId());
			arrMap.put("userName", orderVO.getUserName());
			arrMap.put("orderDate", orderVO.getOrderDate());	
		}
		for (Entry<String, Object> entrySet : arrMap.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
			}
		
			System.out.println(arrMap.keySet());
			System.out.println(arrMap.values());
			
		request.setAttribute("arrMap", arrMap);
		
		return "order/orderList.jsp";
	}
}
