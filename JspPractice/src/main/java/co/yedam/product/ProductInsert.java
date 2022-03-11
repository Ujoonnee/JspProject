package co.yedam.product;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Command;
import co.yedam.common.DAO;

public class ProductInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		System.out.println("doPost call()");
		String path = "";

		ServletContext sc = request.getServletContext();
		
		path = sc.getRealPath("images/product/"); // 서버상경로.

		ProductVO product = new ProductVO();
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, // 요청정보
					path, // 저장위치
					8 * 1024 * 1024, // 용량
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy());

			Enumeration en = multi.getFileNames();
			String fileN = null;
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				String fileName = multi.getFilesystemName(name);
				fileN = fileName;
				product.setProductThumbnail(fileName);

			}

			String productName = multi.getParameter("productName");
			String productCategory1 = multi.getParameter("productCategory1");
			String productCategory2 = multi.getParameter("productCategory2");
			String productInfo = multi.getParameter("productInfo");
			int productStock =  Integer.parseInt(multi.getParameter("productStock"));
			int productPrice = Integer.parseInt(multi.getParameter("productPrice"));


			product.setProductName(productName);
			product.setProductCategory1(productCategory1);
			product.setProductCategory2(productCategory2);
			product.setProductInfo(productInfo);
			product.setProductStock(productStock);
			product.setProductPrice(productPrice);
			
			
			ProductService dao = new ProductServiceImpl();
			ProductVO searchProduct = dao.searchImage(fileN);
			if(searchProduct.getProductThumbnail() == null) {
				System.out.println(searchProduct.getProductThumbnail());
				dao = new ProductServiceImpl();
				dao.insertProduct(product);
			} else {
				System.out.println("이미있는사진입니다.");
				return "product/productInsertForm.jsp";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "product/productInsert.jsp";

	}
}
