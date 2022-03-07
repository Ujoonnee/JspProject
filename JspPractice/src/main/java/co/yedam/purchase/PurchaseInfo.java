package co.yedam.purchase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class PurchaseInfo implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "PurchaseHistory.tiles";
	}
}
