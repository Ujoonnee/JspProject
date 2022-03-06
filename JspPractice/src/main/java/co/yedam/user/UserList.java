package co.yedam.user;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class UserList implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//관리자 
		UserServiceImpl service = new UserServiceImpl();
		List<UserVO> list = service.selectUserList();
		
		request.setAttribute("list", list);
		
		return "userList.jsp";
	}
}
