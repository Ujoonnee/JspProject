package co.yedam.shippingAddress;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class ShippingAddressServiceImpl extends DAO implements ShippingAddress{
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public List<ShippingAddressVO> selectShippingAddressList() {
		String sql = "SELECT * FROM SHIPPING_ADDRESS";
		List<ShippingAddressVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShippingAddressVO vo = new ShippingAddressVO();
				vo.setUserNum(rs.getString("user_num"));
				vo.setIsDefault(rs.getInt("is_defalut"));
				vo.setPhoneNumber(rs.getInt("phone_number"));
				vo.setShippingAddress(rs.getString("shipping_address"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	public List<ShippingAddressVO> selectShippingAddress(ShippingAddressVO vo) {
		String sql = "SELECT * FROM SHIPPING_ADDRESS WHERE USER_NUM = ?";
		List<ShippingAddressVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserNum());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShippingAddressVO address = new ShippingAddressVO();
				address.setUserNum(rs.getString("user_num"));
				address.setIsDefault(rs.getInt("is_defalut"));
				address.setPhoneNumber(rs.getInt("phone_number"));
				address.setShippingAddress(rs.getString("shipping_address"));
				
				list.add(address);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	public int insertShippingAddress(ShippingAddressVO vo) {
		String sql = "insert into SHIPPING_ADDRESS values(?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rs.getString("user_num"));
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
	public int deleteShippingAddress(ShippingAddressVO vo) {
		String sql = "DELETE FROM SHIPPING_ADDRESS WHERE USER_NUM = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserNum());
			System.out.println(r + "건이 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	public int updateShippingAddress(ShippingAddressVO vo) {
		String sql = "UPDATE SHIPPING_ADDRESS IS_DEFAULT=?, PHONE_NUMBER=?,SHIPPING_ADDRESS=? WHERE USER_NUM  = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getIsDefault());
			psmt.setInt(2, vo.getPhoneNumber());
			psmt.setString(3, vo.getShippingAddress());
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