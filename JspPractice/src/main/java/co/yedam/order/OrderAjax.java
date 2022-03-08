package co.yedam.order;

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
		
		OrderService dao = new OrderServiceImpl();
		List<OrderVO> list = dao.selectOrder(type,text);
		

		Gson gson = new Gson();
		String str = gson.toJson(list);
		System.out.println(str);
		return "ajax:" + str;
	}

}
