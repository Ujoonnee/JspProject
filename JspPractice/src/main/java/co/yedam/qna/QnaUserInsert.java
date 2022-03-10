package co.yedam.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.user.UserVO;

public class QnaUserInsert implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String qnaUserId = request.getParameter("userId");
		String qnaType = request.getParameter("qnaType");
		String orderNum = request.getParameter("orderNum");
		String qnaTitle = request.getParameter("title");
		String qnaContent = request.getParameter("content");
		String qnaPhoto = request.getParameter("qna_photo");
		String qnaStatus = request.getParameter("qnaStatus");

		QnaVO qna = new QnaVO();
		qna.setUserId(qnaUserId);
		qna.setQnaType(qnaType);
		qna.setOrderNum(orderNum);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		qna.setQnaPhoto(qnaPhoto);
		qna.setQnaStatus(qnaStatus);

		QnaService dao = new QnaServiceImpl();
		dao.insertQna(qna);
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		System.out.println(user.getUserId());
		dao = new QnaServiceImpl();
		List<QnaVO> list = dao.selectQnaList(user.getUserId());
		request.setAttribute("list", list);

		System.out.println("qnaInsert Successful");
		return "mypage/myPage.jsp";

	}
}
