package co.yedam.qna;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.qna.QnaService;
import co.yedam.qna.QnaServiceImpl;
import co.yedam.qna.QnaVO;

public class QnaUserInsert implements Command{
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      QnaServiceImpl dao = new QnaServiceImpl();
      HttpSession session = request.getSession();
      UserVO user = (UserVO) session.getAttribute("user");
      List<QnaVO> list = dao.selectQnaList(user.getUserId());
      request.setAttribute("list",list);
      
      
      String qnaType=request.getParameter("qna_type");
      String orderNum =request.getParameter("order_num");
      String qnaTitle =request.getParameter("title");
      String qnaContent =request.getParameter("content");
      String qnaPhoto =request.getParameter("qna_photo");
      
      
      QnaVO qna = new QnaVO();
      qna.setQnaType(qnaType);
      qna.setOrderNum(orderNum);
      qna.setQnaTitle(qnaTitle);
      qna.setQnaContent(qnaContent);
      qna.setQnaPhoto(qnaPhoto);
      
      
      QnaService service= new QnaServiceImpl();
      service.insertQna(qna);
      
      System.out.println("qnaInsert Successful");
      return "qna/qnaList.jsp";
   }
}