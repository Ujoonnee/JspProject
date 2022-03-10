package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.user.UserVO;

public class QnaList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		QnaService dao = new QnaServiceImpl();
		HttpSession session = request.getSession();
		
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user.getUserAuthority().equals("admin")) {
			List<QnaVO> list = dao.selectAllList();
			request.setAttribute("list",list);
			return "qna/qnaList.jsp";
		}else {
			List<QnaVO> list = dao.selectQnaList(user.getUserId());
			request.setAttribute("list",list);
			return"qna/qnaList.jsp";
		}
		
	}
}