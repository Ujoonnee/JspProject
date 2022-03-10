package co.yedam.user;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.product.ProductService;
import co.yedam.product.ProductServiceImpl;
import co.yedam.product.ProductVO;

public class UserLogin implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		UserServiceImpl dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		// 입력받은 id, pw 를 VO 에 저장
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		vo = dao.pwCheck(vo);
		
		// id, pw가 일치하면 VO 에 다른 정보들이 정상적으로 입력됨
		if(vo.getUserName() != null) {
			System.out.println(vo.getUserName() + " login successful");
			// 로그인 성공하면 세션에 로그인 한 아이디 정보 저장
			session.setAttribute("user", vo);  
			
			ProductService pdao = new ProductServiceImpl();

			List<ProductVO> list = pdao.selectProductList();
			request.setAttribute("list", list);
			
			return "main/main.jsp";
			
		} else {
			System.out.println("login failed due to incorrect password");
			return "user/userLoginFail.jsp";
		}
	}
}
