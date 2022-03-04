package co.yedam.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class ProductList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "ProductList.tiles";
	}
}
