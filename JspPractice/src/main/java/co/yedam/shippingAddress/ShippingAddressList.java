package co.yedam.shippingAddress;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import co.yedam.common.Command;
import co.yedam.user.UserVO;

public class ShippingAddressList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(); 
		ShippingAddressServiceImpl dao = new ShippingAddressServiceImpl();

		UserVO user = (UserVO) session.getAttribute("user");
		
		ShippingAddressVO address = new ShippingAddressVO();
		address.setUserId(user.getUserId());
		
		List<ShippingAddressVO> list = dao.selectShippingAddress(address);
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return "ajax:"+str;
	}

}
