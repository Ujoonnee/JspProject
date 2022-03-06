package co.yedam.user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class UserLogin implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		UserServiceImpl dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		vo= dao.pwCheck(vo);
		session.setAttribute("id", vo.getUserId());  
		if(vo.getUserId() != null) {
			//로그인 성공 경로 정해줘야함
			return "main/main.jsp";
		} else {
			//로그인 실패 경로 정해줘야함 
			return "user/userLoginFail.jsp";
		}
	}
}
