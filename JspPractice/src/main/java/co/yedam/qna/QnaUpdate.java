package co.yedam.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class QnaUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		QnaService dao = new QnaServiceImpl();
		
		String date = request.getParameter("qnaDate");
		System.out.println(date);
		String content = request.getParameter("responseContent");
		System.out.println(content);
		
		
		dao.ResponseUpdateQna(content,date);
		
		return "qnaList.do";
	}

}
