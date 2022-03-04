package co.yedam.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class UserInfo implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub dtd

		UserServiceImpl dao = new UserServiceImpl();
		UserVO user = new UserVO();
		
		user.setUserNum(Integer.parseInt(request.getParameter("user_num")));
		user = dao.selectUser(user);
		
		//key 값 list
		request.setAttribute("user", user);
		
		
		return "UserInfo.jsp";
	}
}
	