package co.yedam.mypage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceImpl;
import co.yedam.user.UserVO;

public class MyPageUpdate implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		
		String id = vo.getUserId();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("userTel");
		String email = request.getParameter("userEmail");
		String address = request.getParameter("userAddress");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(address);
		
		UserVO user = new UserVO();
		
		user.setUserId(id);
		user.setUserPw(pw);
		user.setUserTel(tel);
		user.setUserEmail(email);
		user.setUserAddress(address);
	
		UserService service = new UserServiceImpl();
		System.out.println("중간");
		service.updateUser(user);
		System.out.println("userUpdate Success");
		
		return "main/main.jsp";
	}
}
