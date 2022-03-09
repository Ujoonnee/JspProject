package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class QnaResponse implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		QnaService dao = new QnaServiceImpl();
		String qna = request.getParameter("qnaDate");
		System.out.println(qna + "qna작성시간");
		List<QnaVO> list = dao.strSelectofDate(qna);
		
		request.setAttribute("list",list);
		return "qna/qnaResponse.jsp";
	}
}
