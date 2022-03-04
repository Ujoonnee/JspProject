package co.yedam.mypage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceImpl;
import co.yedam.user.UserVO;

public class MyPageCheck implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserService service = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		vo.setUserPw(request.getParameter("userPw"));
		
		
		String viewPage;
		
		if(vo.getUserName() != null) {
			request.setAttribute("", vo.getUserId());  //세션에 id란 변수로 멤버아이디를 저장
			//비밀번호 확인시 마이페이지 경로 뜨도록
			viewPage = ".do";
		} else {
			//비밀번호 실패시 홈으로 경로 정해줘야함 
			viewPage = "home.do";
		}
		
		return viewPage;

	}
}
