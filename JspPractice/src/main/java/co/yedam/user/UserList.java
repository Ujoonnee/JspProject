package co.yedam.user;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class UserList implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//관리자 
      HttpSession session = request.getSession();
      UserVO admin = (UserVO) session.getAttribute("user");
		UserServiceImpl service = new UserServiceImpl();
		
        if(admin.getUserAuthority().equals("admin")) {
        	List<UserVO> list = service.selectUserList();
        	System.out.println("userListpage");
        	request.setAttribute("list", list);
        	
        	return "user/userList.jsp";
     }else {
    	
        return"userInfo.do";
     }
	}
}
