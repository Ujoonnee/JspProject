package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class QnaList implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		QnaServiceImpl dao = new QnaServiceImpl();
		List<QnaVO> list = dao.selectQnaList();
		
		request.setAttribute("list",list);
		
		
		return "qna/qnaList.jsp";
	}
}
