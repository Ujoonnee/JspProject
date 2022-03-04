

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.bbs.web.Bulletin;
import co.micol.dbtest.bbs.web.BulletinDelete;
import co.micol.dbtest.bbs.web.BulletinForm;
import co.micol.dbtest.bbs.web.BulletinList;
import co.micol.dbtest.bbs.web.BulletinSelect;
import co.micol.dbtest.bbs.web.BulletinUpdate;
import co.micol.dbtest.bbs.web.BulletinInsert;
import co.micol.dbtest.member.web.MemberJoin;
import co.micol.dbtest.member.web.MemberJoinForm;
import co.micol.dbtest.member.web.MemberList;
import co.micol.dbtest.member.web.MemberLogin;
import co.micol.dbtest.member.web.MemberLoginForm;
import co.micol.dbtest.member.web.MemberLoginOut;
import co.micol.dbtest.notice.ajaxweb.AjaxNoticeInsert;
import co.micol.dbtest.notice.ajaxweb.AjaxNoticeList;
import co.micol.dbtest.notice.ajaxweb.NoticeClient;
import co.micol.dbtest.notice.web.Notice;
import co.micol.dbtest.notice.web.NoticeForm;
import co.micol.dbtest.notice.web.NoticeList;
import co.micol.dbtest.notice.web.NoticeListPaging;
import co.micol.dbtest.notice.web.NoticeWrite;

// merge test comment

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/home.do", new Home()); // 1 홈화면
	
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 2 로그인 폼 호출
		map.put("/memberSignUpForm.do", new MemberSignUpForm()); // 3 회원가입 폼 호출
		
		// admin pages
		map.put("/memberList.do", new MemberList()); //4 회원리스트(관리자)
		map.put("/memberInfo.do", new MemberInfo()); //5 회원 상세정보(관리자)
		map.put("/orderList.do", new OrderList()); //6 주문목록(관리자)
		
		// Mypage
		map.put("/myPageCheck.do", new MyPageCheck()); //7 마이페이지(회원정보 수정 - 비밀번호 확인)	
		map.put("/myPageUpdate.do", new MyPageUpdate()); 	//8 마이페이지(회원정보 수정)
		map.put("/purchaseHistory.do", new PurchaseHistory()); //9 마이페이지(구매내역)	
		map.put("/purchaseHistoryDetail.do", new PurchaseHistoryDetail()); //10 마이페이지(구매내역 상세)
		map.put("/cart.do", new Cart()); //11 마이페이지(장바구니)
		map.put("/qna.do", new Qna()); //12 마이페이지(1:1문의)
		map.put("/qnaDetail.do", new QnaDetail()); //13 마이페이지(1:1문의 단일 세부내용)
		map.put("/qnaForm.do", new QnaForm()); //14 1:1문의 작성

		// product pages
		map.put("/productList.do", new ProductList()); //15 상품 목록
		map.put("/productUpdate.do", new ProductUpdate()); //16 상품 등록(관리자)
		map.put("/productDetail.do", new ProductDetail()); //17 상품 세부 정보
		map.put("/orderPage.do", new OrderPage()); //18 주문 페이지
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
