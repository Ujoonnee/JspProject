package co.yedam.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class QnaDetail implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		QnaVO qna = (QnaVO)session.getAttribute("orderNum");
		QnaService service = new QnaServiceImpl();
//			List<QnaVO> list = service.selectAllList();
//			request.setAttribute("list", list);
			
			
			return "qna/qnaDetail.jsp";
	}
}
