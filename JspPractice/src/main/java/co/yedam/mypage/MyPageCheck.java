package co.yedam.mypage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceImpl;
import co.yedam.user.UserVO;

public class MyPageCheck implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		
		UserService dao = new UserServiceImpl();
		UserVO vo = (UserVO) session.getAttribute("user");
		
		if(vo.getUserPw().equals(request.getParameter("userPw"))) {
			vo = dao.selectUser(vo);
			request.setAttribute("user", vo);
			System.out.println("userInfoPage");
			
			return "user/userInfo.jsp";
			
//			request.setAttribute("id", vo.getUserId());  
//			//비밀번호 확인시 마이페이지 경로 뜨도록
//			return "mypage/myPageUpdate.jsp";
		} else {
			//비밀번호 실패시 홈으로 확인실패 후 다시 현재 페이지로 돌아옴. 
			return "mypage/myPageCheckFail.jsp";
		}
		

	}
}
