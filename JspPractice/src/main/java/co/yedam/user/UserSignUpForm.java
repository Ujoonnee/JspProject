package co.yedam.user;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class UserSignUpForm implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserServiceImpl dao = new UserServiceImpl();
		List<UserVO> list = dao.selectUserList();
		
		// id 중복 체크를 위한 id 목록 string
		String idList = "";
		
		for (UserVO userVO : list) {
			idList = idList + userVO.getUserId() + ",";
		}
		
		request.setAttribute("list", idList);
		
		return "user/userSignUpForm.jsp";
	}
}
