package co.yedam.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class QnaDetail implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		List<QnaVO> list = dao.selectAllList();
//		QnaVO qna2 = new QnaVO();
//		QnaService dao = new QnaServiceImpl();
//		QnaVO qna = (QnaVO)session.getAttribute("selectedQna");
//		System.out.println(qna.getQnaDate());
//		
//		String qna3 =dao.selectofQnaData(qna);
//		
//		
//		request.setAttribute("list", qna3);
//			
		QnaServiceImpl dao = new QnaServiceImpl();
		QnaVO qna = new QnaVO();
		
		qna.setQnaDate(request.getParameter("selectedQna"));
		System.out.println(qna.getQnaDate());
		qna = dao.selectofQnaData(qna);
		//key값 list
		request.setAttribute("qna", qna);
		System.out.println("qnaDetailPage");
			
		return "qna/qnaDetail.jsp";
	}
}
