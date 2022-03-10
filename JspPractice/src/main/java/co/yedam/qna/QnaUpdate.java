package co.yedam.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class QnaUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		QnaService dao = new QnaServiceImpl();
		
		String date = request.getParameter("qnaDate");
		System.out.println("QnaUpdate쪽 request date값 : "+date);
		String content = request.getParameter("responseContent");
		System.out.println("QnaUpdate쪽 request 내용값 : "+content);
		
		System.out.println("-----내용끝-----");
		
		dao.responseUpdateQna(content,date);
		
		System.out.println("update done");
		
		dao = new QnaServiceImpl();
		QnaVO qna = new QnaVO();
		qna.setQnaDate(date);
		qna = dao.selectofQnaData(qna);
		
		//key값 list
		request.setAttribute("qna", qna);
		
		return "qna/qnaDetail.jsp";
	}

}
