package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.cart.AddCart;
import co.yedam.cart.Cart;
import co.yedam.main.Main;
import co.yedam.mypage.MyPageCheck;
import co.yedam.mypage.MyPageUpdate;
import co.yedam.order.OrderList;
import co.yedam.order.OrderPage;
import co.yedam.product.ProductDetail;
import co.yedam.product.ProductInsert;
import co.yedam.product.ProductInsertForm;
import co.yedam.product.ProductList;
import co.yedam.product.ProductUpdate;
import co.yedam.purchase.PurchaseHistory;
import co.yedam.purchase.PurchaseHistoryDetail;
import co.yedam.purchase.PurchaseInfo;
import co.yedam.qna.QnaDetail;
import co.yedam.qna.QnaForm;
import co.yedam.qna.QnaList;
import co.yedam.user.QnaUserInsert;
import co.yedam.user.UserInfo;
import co.yedam.user.UserList;
import co.yedam.user.UserLogin;
import co.yedam.user.UserLoginForm;
import co.yedam.user.UserSignUp;
import co.yedam.user.UserSignUpForm;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new Main()); // 1 홈화면
		
		map.put("/userLoginForm.do", new UserLoginForm()); // 2 로그인 폼 호출
		map.put("/userLogin.do", new UserLogin()); // 2 로그인 처리
		map.put("/userSignUpForm.do", new UserSignUpForm()); // 3 회원가입 폼 호출
		map.put("/userSignUp.do", new UserSignUp()); // 3 회원가입 폼 호출
		
		// admin pages
		map.put("/userList.do", new UserList()); //4 회원리스트(관리자)
		map.put("/userInfo.do", new UserInfo()); //5 회원 상세정보(관리자)
		map.put("/orderList.do", new OrderList()); //6 주문목록(관리자)
		
		// Mypage
		map.put("/myPageCheck.do", new MyPageCheck()); //7 마이페이지(회원정보 수정 - 비밀번호 확인)	
		map.put("/myPageUpdate.do", new MyPageUpdate()); 	//8 마이페이지(회원정보 수정)

		map.put("/purchaseInfo.do", new PurchaseInfo()); //9 결제정보	
		map.put("/purchaseHistory.do", new PurchaseHistory()); //9 마이페이지(구매내역)	
		map.put("/purchaseHistoryDetail.do", new PurchaseHistoryDetail()); //10 마이페이지(구매내역 상세)
		
		map.put("/cart.do", new Cart()); //11 마이페이지(장바구니)
		map.put("/addCart.do", new AddCart()); //11 마이페이지(장바구니)
		
		map.put("/qnaList.do", new QnaList()); //12 마이페이지(1:1문의)
	    map.put("/qnaUserInsert.do", new QnaUserInsert()); //12 마이페이지(1:1문의)
	    map.put("/qnaDetail.do", new QnaDetail()); //13 마이페이지(1:1문의 단일 세부내용)
	    map.put("/qnaForm.do", new QnaForm()); //14 1:1문의 작성

		// product pages
        map.put("/productList.do", new ProductList()); //15 상품 목록
        map.put("/productInsertForm.do", new ProductInsertForm());    // 상품 등록 페이지(관리자)
        map.put("/productInsert.do", new ProductInsert());    // 상품 등록(관리자)
        map.put("/productUpdate.do", new ProductUpdate()); //16 상품 수정(관리자)
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
		System.out.println(path);

		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		
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

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}