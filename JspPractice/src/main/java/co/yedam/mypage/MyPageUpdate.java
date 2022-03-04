package co.yedam.mypage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceImpl;
import co.yedam.user.UserVO;

public class MyPageUpdate implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		UserService service = new UserServiceImpl();
		UserVO user = new UserVO();
		
		user.setUserPw(request.getParameter("userPw"));
		user.setUserTel(request.getParameter("userTel"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserAddress(request.getParameter("userAddress"));
		
		service.updateUser(user);
		
		request.setAttribute("user", user);
		
		
		return ".jsp";
	}
}
