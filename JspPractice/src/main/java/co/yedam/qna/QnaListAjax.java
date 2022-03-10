package co.yedam.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.yedam.common.Command;
import co.yedam.order.OrderVO;

public class QnaListAjax implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		String text = request.getParameter("text");

		QnaService dao = new QnaServiceImpl();

		List<QnaVO> list = dao.searchQna(type, text);
		Gson gson = new Gson();
		String str = gson.toJson(list);

		return "ajax:" + str;
	}

}
