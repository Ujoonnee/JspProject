package co.yedam.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class OrderServiceImpl extends DAO implements OrderService {
	PreparedStatement psmt;
	ResultSet rs;

	@Override
	public List<OrderVO> selectOrderList() {
		// String sql = "SELECT * FROM ORDERS ORDER BY 1";
		String sql = "SELECT o.order_num, p.product_name, o.user_id, u.user_name, o.order_date FROM products p,orders o, users u WHERE p.product_serial = o.product_serial AND o.user_id = u.user_id";
		List<OrderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setOrderNum(rs.getString("order_num"));
				vo.setProductName(rs.getString("product_name"));
				vo.setUserId(rs.getString("user_id"));
				vo.setUserName(rs.getString("user_name"));
				vo.setOrderDate(rs.getString("order_date"));

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
	public List<OrderVO> selectOrder(OrderVO vo){
		String sql = "SELECT * from orders where user_id = ?";
		List<OrderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getUserId());
			rs= psmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				order.setOrderNum(rs.getString("order_num"));
				order.setProductName(rs.getString("product_serial"));
				order.setUserId(rs.getString("product_quantity"));
				order.setOrderDate(rs.getString("order_date"));
				
				list.add(order);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list ;
	}
	@Override
	public List<OrderVO> selectOrder(String type, String text) {
		String sql = "SELECT o.order_num, p.product_name, o.user_id, u.user_name, o.order_date FROM products p,orders o, users u WHERE p.product_serial = o.product_serial AND o.user_id = u.user_id and ? = ?";
		List<OrderVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, type);
			psmt.setString(2, text);
			rs = psmt.executeQuery();
			while (rs.next()) {

				OrderVO order = new OrderVO();
				order.setOrderNum(rs.getString("order_num"));
				order.setProductName(rs.getString("product_name"));
				order.setUserId(rs.getString("user_id"));
				order.setUserName(rs.getString("user_name"));
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
			psmt.setString(2, vo.getUserId());
			psmt.setInt(3, vo.getProductSerial());
			psmt.setInt(4, vo.getProductQuantity());
			psmt.setString(5, vo.getOrderDate());
			r = psmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			psmt.setString(1, vo.getUserId());
			psmt.setInt(2, vo.getProductSerial());
			psmt.setInt(3, vo.getProductQuantity());
			psmt.setString(4, vo.getOrderDate());
			psmt.setString(5, vo.getOrderNum());
			r = psmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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