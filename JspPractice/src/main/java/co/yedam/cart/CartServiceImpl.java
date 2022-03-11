package co.yedam.cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class CartServiceImpl extends DAO implements CartService {
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public List<CartVO> selectCartList() {
		String sql = "SELECT * FROM cart";
		List<CartVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CartVO vo = new CartVO();
				vo.setUserId(rs.getString("user_id"));
				vo.setProductSerial(rs.getInt("product_serial"));
				vo.setProductQuantity(rs.getInt("product_quantity"));
				vo.setProductPrice(rs.getInt("product_price"));
				vo.setCartDate(rs.getString("cart_date"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	@Override
	public List<CartListVO> selectCart(CartVO vo) {
		String sql = "select p.product_name, c.product_Serial, p.product_thumbnail, p.product_price, c.product_quantity from products p, cart c where p.product_serial = c.product_serial and c.user_id = ?";
		List<CartListVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				CartListVO cart = new CartListVO();
				cart.setProductName(rs.getString("product_name"));
				cart.setProductThumbnail(rs.getString("product_thumbnail"));
				cart.setProductSerial(rs.getInt("product_serial"));
				cart.setProductPrice(rs.getInt("product_price"));
				cart.setProductQuantity(rs.getInt("product_quantity"));
				
				list.add(cart);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	@Override
	public int insertCart(CartVO vo) {
		String sql = "INSERT INTO cart VALUES(?,?,?,?,sysdate)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setInt(2, vo.getProductSerial());
			psmt.setInt(3, vo.getProductQuantity());
			psmt.setInt(4, vo.getProductPrice());
			
			r = psmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
	@Override
	public int updateCart(CartVO vo) {
		String sql = "UPDATE cart SET product_serial = ?, product_quantity, product_price = ?, cart_date = sysdate WHERE user_id = ?";
		
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getProductSerial());
			psmt.setInt(2, vo.getProductQuantity());
			psmt.setInt(3, vo.getProductPrice());
			psmt.setString(4, vo.getCartDate());
			psmt.setString(5, vo.getUserId());
			
			r = psmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
	@Override
	public int deleteCart(CartVO vo) {
		String sql = "DELETE FROM cart WHERE user_id= ? AND product_serial = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setInt(2, vo.getProductSerial());
			
			System.out.println(r + "건이 삭제되었습니다.");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
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