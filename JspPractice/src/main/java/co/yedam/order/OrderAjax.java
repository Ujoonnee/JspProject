package co.yedam.order;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.yedam.common.Command;

public class OrderAjax implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		String text = request.getParameter("text");
		
		System.out.println(type + " " + text);
		
		OrderService dao = new OrderServiceImpl();
		
		List<OrderVO> list = dao.selectOrder(type,text);

		//System.out.println(list.get(0).getOrderNum());
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		System.out.println(str);
		return "ajax:" + str;
		
	}

}
