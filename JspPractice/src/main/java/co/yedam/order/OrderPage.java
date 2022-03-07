package co.yedam.order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class OrderPage implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int productSerial = Integer.parseInt(request.getParameter("productSerial"));
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		String productThumbnail = request.getParameter("productThumbnail");
		String productName = request.getParameter("productName");
		
		
		request.setAttribute("productPrice", productPrice);
		request.setAttribute("productSerial", productSerial);
		request.setAttribute("productQuantity", productQuantity);
		request.setAttribute("productThumbnail", productThumbnail);
		request.setAttribute("productName", productName);
		
		return "order/orderPage.jsp";

	}
}
