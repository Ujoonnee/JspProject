package co.yedam.shippingAddress;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class ShippingAddressServiceImpl extends DAO implements ShippingAddressService {
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public List<ShippingAddressVO> selectShippingAddressList() {
		String sql = "SELECT * FROM shipping_address";
		List<ShippingAddressVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShippingAddressVO address = new ShippingAddressVO();
				address.setUserId(rs.getString("user_id"));
				address.setShippingAddress(rs.getString("shipping_address"));
				address.setRecipientName(rs.getString("recipient_name"));
				address.setPhoneNumber(rs.getString("phone_number"));
				address.setShippingComment(rs.getString("shipping_comment"));
				
				list.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	@Override
	public List<ShippingAddressVO> selectShippingAddress(ShippingAddressVO vo) {
		String sql = "SELECT * FROM shipping_address WHERE user_id = ?";
		List<ShippingAddressVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShippingAddressVO address = new ShippingAddressVO();
				address.setUserId(rs.getString("user_id"));
				address.setShippingAddress(rs.getString("shipping_address"));
				address.setRecipientName(rs.getString("recipient_name"));
				address.setPhoneNumber(rs.getString("phone_number"));
				address.setShippingComment(rs.getString("shipping_comment"));
				
				list.add(address);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	@Override
	public int insertShippingAddress(ShippingAddressVO vo) {
		String sql = "INSERT INTO shipping_address VALUES(?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rs.getString("user_id"));
			psmt.setInt(2, rs.getInt("is_default"));
			psmt.setInt(3, rs.getInt("phone_number"));
			psmt.setString(4, rs.getString("shipping_address"));
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
	public int deleteShippingAddress(ShippingAddressVO vo) {
		String sql = "DELETE FROM shipping_address WHERE user_id= ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			System.out.println(r + "건이 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
	@Override
	public int updateShippingAddress(ShippingAddressVO vo) {
		String sql = "UPDATE shipping_address SET is_default = ?, phone_number = ?, shipping_address = ? WHERE user_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
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