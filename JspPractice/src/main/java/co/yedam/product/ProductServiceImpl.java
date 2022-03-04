package co.yedam.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class ProductServiceImpl extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;

	public List<ProductVO> selectProductList() {
		String sql = "select * from products";
		List<ProductVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProductNum(rs.getInt("product_num"));
				product.setProductCategory1(rs.getString("product_category1"));
				product.setProductCategory2(rs.getString("product_category2"));
				product.setProductThumbnail(rs.getString("product_thumbnail"));
				product.setProductInfo(rs.getString("product_info"));
				product.setProductOption1(rs.getString("product_option1"));
				product.setProductOption2(rs.getString("product_option2"));
				product.setProductStock(rs.getInt("product_stock"));
				product.setProductPrice(rs.getInt("product_price"));
				
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	public ProductVO selectProduct(ProductVO vo) {
		String sql = "select * from products where product_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProductNum());
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo.setProductCategory1(rs.getString("product_category1"));
				vo.setProductCategory2(rs.getString("product_category2"));
				vo.setProductThumbnail(rs.getString("product_thumbnail"));
				vo.setProductInfo(rs.getString("product_info"));
				vo.setProductOption1(rs.getString("product_option1"));
				vo.setProductOption2(rs.getString("product_option2"));
				vo.setProductStock(rs.getInt("product_stock"));
				vo.setProductPrice(rs.getInt("product_price"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

	public int insertProduct(ProductVO vo) {
		String sql = "insert into products values(product_num_seq.nextval,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductCategory1());
			psmt.setString(2, vo.getProductCategory2());
			psmt.setString(3, vo.getProductThumbnail());
			psmt.setString(4, vo.getProductInfo());
			psmt.setString(5, vo.getProductOption1());
			psmt.setString(6, vo.getProductOption2());
			psmt.setInt(7, vo.getProductStock());
			psmt.setInt(8, vo.getProductPrice());
			r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	public int updateProduct(ProductVO vo) {
		String sql = "update products set product_category1 = ?, product_category2 = ?, product_thumbnail = ?, product_info = ?, product_option1 = ?, product_option2 = ?, product_stock = ?, product_price = ? where product_num = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductCategory1());
			psmt.setString(2, vo.getProductCategory2());
			psmt.setString(3, vo.getProductThumbnail());
			psmt.setString(4, vo.getProductInfo());
			psmt.setString(5, vo.getProductOption1());
			psmt.setString(6, vo.getProductOption2());
			psmt.setInt(7, vo.getProductStock());
			psmt.setInt(8, vo.getProductPrice());
			psmt.setInt(9, vo.getProductNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	public int deleteProduct(ProductVO vo) {
		String sql = "delete from users where user_num = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProductNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}



	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}