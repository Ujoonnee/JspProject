package co.yedam.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class OrderServiceImpl extends DAO implements OrderService{
	PreparedStatement psmt;
	ResultSet rs;
	@Override
	public List<OrderVO> selectOrderList(){
		String sql = "SELECT * FROM ORDERS ORDER BY 1";
		List<OrderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
			OrderVO vo = new OrderVO();
			vo.setOrderNum(rs.getString("order_num"));
			vo.setUserid(rs.getString("user_id"));
			vo.setProductserial(rs.getInt("product_serial"));
			vo.setProductQuantity(rs.getInt("product_quantity"));
			vo.setOrderDate(rs.getString("order_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	@Override
	public List<OrderVO> selectOrder(OrderVO vo) {
		String sql = "SELECT * FROM ORDERS WHERE USER_NUM = ?";
		List<OrderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getOrderNum());
			rs = psmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				order.setOrderNum(rs.getString("order_num"));
				order.setUserid(rs.getString("User_id"));
				order.setProductserial(rs.getInt("product_serial"));
				order.setProductQuantity(rs.getInt("product_quantity"));
				order.setOrderDate(rs.getString("order_date"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	@Override
	public int insertOrder(OrderVO vo) {
		String sql = "INSERT INTO ORDERS VALUES(?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getOrderNum());
			psmt.setString(2, vo.getUserid());
			psmt.setInt(3, vo.getProductserial());
			psmt.setInt(4, vo.getProductQuantity());
			psmt.setString(5, vo.getOrderDate());
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
	public int deleteOrder(OrderVO vo) {
		String sql = "DELETE FROM ORDERS WHERE ORDER_NUM = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getOrderNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건이 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	@Override
	public int updateOrder(OrderVO vo) {
		String sql = "UPDATE ORDERS USER_ID=?,PRODUCT_SERIAL=?,PRODUCT_QUANTITY=?,ORDER_DATE=?  SET WHERE ORDER_NUM=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserid());
			psmt.setInt(2, vo.getProductserial());
			psmt.setInt(3, vo.getProductQuantity());
			psmt.setString(4, vo.getOrderDate());
			psmt.setString(5, vo.getOrderNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
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