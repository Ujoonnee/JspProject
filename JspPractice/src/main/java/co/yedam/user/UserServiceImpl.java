package co.yedam.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class UserServiceImpl extends DAO implements UserService {
   private PreparedStatement psmt;
   private ResultSet rs;
   
   @Override
   public List<UserVO> selectUserList() {
      // TODO Auto-generated method stub
      String sql = "select * from users";
      List<UserVO> list = new ArrayList<>();
      try {
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         
         while(rs.next()) {
            UserVO user = new UserVO();
            user.setUserNum(rs.getInt("user_num"));
            user.setUserId(rs.getString("user_id"));
            user.setUserPw(rs.getString("user_pw"));
            user.setUserName(rs.getString("user_name"));
            user.setUserDob(rs.getString("user_dob"));
            user.setUserSignupDate(rs.getString("user_signup_date"));
            user.setUserTel(rs.getString("user_tel"));
            user.setUserEmail(rs.getString("user_email"));
            user.setUserAddress(rs.getString("user_address"));
            user.setUserAuthority(rs.getString("user_authority"));
            
            list.add(user);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      
      return list;
   }

   @Override
   public UserVO selectUser(UserVO vo) {
      String sql = "select * from users where user_id = ?";
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getUserId());
         
         rs = psmt.executeQuery();
         
         if (rs.next()) {
        	vo.setUserNum(rs.getInt("user_num"));
            vo.setUserId(rs.getString("user_id"));
            vo.setUserPw(rs.getString("user_pw"));
            vo.setUserName(rs.getString("user_name"));
            vo.setUserDob(rs.getString("user_dob"));
            vo.setUserSignupDate(rs.getString("user_signup_date"));
            vo.setUserTel(rs.getString("user_tel"));
            vo.setUserEmail(rs.getString("user_email"));
            vo.setUserAddress(rs.getString("user_address"));
            vo.setUserAuthority(rs.getString("user_authority"));
         }
         
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      
      return vo;
   }
   
   @Override
   public UserVO pwCheck(UserVO vo) {
	   String sql = "select * from users where user_id = ? AND user_pw = ?";
	   try{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getUserPw());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setUserNum(rs.getInt("user_num"));
	            vo.setUserId(rs.getString("user_id"));
	            vo.setUserPw(rs.getString("user_pw"));
	            vo.setUserName(rs.getString("user_name"));
	            vo.setUserDob(rs.getString("user_dob"));
	            vo.setUserSignupDate(rs.getString("user_signup_date"));
	            vo.setUserTel(rs.getString("user_tel"));
	            vo.setUserEmail(rs.getString("user_email"));
	            vo.setUserAddress(rs.getString("user_address"));
	            vo.setUserAuthority(rs.getString("user_authority"));
			}
	   } catch(SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	return vo;
   }
   
   @Override
   public int insertUser(UserVO vo) {
      // TODO Auto-generated method stub
      String sql = "insert into users values(user_num_seq.nextval,?,?,?,?,sysdate,?,?,?,'user')";
      int r = 0;
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getUserId());
         psmt.setString(2, vo.getUserPw());
         psmt.setString(3, vo.getUserName());
         psmt.setString(4, vo.getUserDob());
         psmt.setString(5, vo.getUserTel());
         psmt.setString(6, vo.getUserEmail());
         psmt.setString(7, vo.getUserAddress());
         r = psmt.executeUpdate();
         System.out.println(r + "??? ??????");

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return r;
   }
   
   @Override
   public int updateUser(UserVO vo) {
      String sql = "update users set user_pw = ?, user_tel = ?, user_email = ?, user_address = ? where user_id = ?";
      int r = 0;
      try {
    	 psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo.getUserPw());
         psmt.setString(2, vo.getUserTel());
         psmt.setString(3, vo.getUserEmail());
         psmt.setString(4, vo.getUserAddress());
         psmt.setString(5, vo.getUserId());
         
         r = psmt.executeUpdate();
         System.out.println(r + "??? ??????");
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return r;
   }
   
   @Override
   public int deleteUser(UserVO vo) {
      String sql = "delete from users where user_id = ?";
      int r = 0;
      try {
         psmt.setString(1, vo.getUserId());
         r = psmt.executeUpdate();
         System.out.println(r + "??? ??????");
         
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