package co.yedam.user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class UserLoginForm implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserServiceImpl dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		//vo= dao.idcheck();
		String viewPage;
		if(vo.getUserName() != null) {
			request.setAttribute("id", vo.getUserId());  //세션에 id란 변수로 멤버아이디를 저장
			//로그인 성공 경로 정해줘야함
			viewPage = ".do";
		} else {
			//로그인 실패 경로 정해줘야함 
			viewPage = ".do";
		}
		
		return viewPage;
	}
}
