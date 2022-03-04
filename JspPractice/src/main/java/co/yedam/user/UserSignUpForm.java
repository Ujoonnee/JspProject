package co.yedam.user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class UserSignUpForm implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String dob = request.getParameter("userDob");
		String signupdate = request.getParameter("userSignupDate");
		String tel = request.getParameter("userTel");
		String email = request.getParameter("userEmail");
		String address = request.getParameter("userAddress");
		
		UserVO user = new UserVO();
		user.setUserId(id);
		user.setUserPw(pw);
		user.setUserName(name);
		user.setUserDob(dob);
		user.setUserSignupDate(signupdate);
		user.setUserTel(tel);
		user.setUserEmail(email);
		user.setUserAddress(address);
		
		//인터페이스 생성해야함
		UserServiceImpl service = new UserServiceImpl();
		service.insertUser(user);
		

		return "UserSignUpForm.do";
	}
}
