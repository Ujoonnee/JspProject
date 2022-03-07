package co.yedam.user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class UserLoginForm implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		if(user == null) {
		return "user/userLoginForm.jsp";
		}else
		return "main/main.jsp";
		
	}
}
