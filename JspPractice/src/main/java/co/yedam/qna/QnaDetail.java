package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.ProductService;
import co.yedam.product.ProductServiceImpl;
import co.yedam.product.ProductVO;

public class QnaDetail implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		UserVO admin = (UserVO) session.getAttribute("user");
			QnaService service = new QnaServiceImpl();
			List<QnaVO> list = service.selectAllList();
			request.setAttribute("list", list);
			
			return "qna/qnaAdmin.jsp";
			
//			if(admin.getUserAuthority() == "admin") {
//		}else {
//			return"qna/qnaAdminFail.jsp";
//		}
	}
}