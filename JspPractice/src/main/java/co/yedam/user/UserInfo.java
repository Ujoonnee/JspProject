package co.yedam.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class UserInfo implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub dtd
		HttpSession session = request.getSession();
		UserVO admin = (UserVO) session.getAttribute("user");

		if (admin.getUserAuthority().equals("admin")) {
			UserServiceImpl dao = new UserServiceImpl();
			UserVO user = new UserVO();

			user.setUserId(request.getParameter("selectedUser"));
			user = dao.selectUser(user);

			// key 값 list
			request.setAttribute("user", user);
			System.out.println("userInfoPage");

			return "user/userInfo.jsp";
		} else {
			UserServiceImpl dao = new UserServiceImpl();
			UserVO user = new UserVO();

			request.setAttribute("user", user.getUserId());
			System.out.println("UseruserInfoPage");

			return "user/userInfo.jsp";
		}
	}
}
