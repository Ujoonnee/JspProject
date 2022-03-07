package co.yedam.qna;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.yedam.common.DAO;

public class QnaServiceImpl extends DAO implements QnaService{
	 private PreparedStatement psmt;
	 private ResultSet rs;
	 
	 @Override
	 public List<QnaVO> selectQnaList(String userId){
		 String sql = "select * from qna where user_id = ?";
		 List<QnaVO> list = new ArrayList<>();
		 
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, userId);
			 
			 rs = psmt.executeQuery();
			 
			 while(rs.next()) {
				 
				 QnaVO qna = new QnaVO();
				 
				 qna.setUserId(rs.getString("user_id"));
				 qna.setQnaType(rs.getString("qna_type"));
				 qna.setOrderNum(rs.getString("order_num"));
				 qna.setQnaDate(rs.getString("qna_date"));
				 qna.setQnaTitle(rs.getString("qna_title"));
				 qna.setQnaContent(rs.getString("qna_content"));
				 qna.setQnaPhoto(rs.getString("qna_photo"));
				 qna.setQnaStatus(rs.getString("qna_status"));
				 qna.setResponseDate(rs.getString("response_date"));
				 
				 list.add(qna);
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 return list;
	 }
	 @Override
	 public int insertQna(QnaVO vo) {
		 String sql = "insert into qna(qna_type,order_num,qna_title,qna_content,qna_photo) values(?,?,?,?,?)";
		 int r = 0;
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1,vo.getQnaType());
			 psmt.setString(2,vo.getOrderNum());
			 psmt.setString(3,vo.getQnaTitle());
			 psmt.setString(4,vo.getQnaContent());
			 psmt.setString(5,vo.getQnaPhoto());
			 r=psmt.executeUpdate();
			 System.out.println(r+"건 입력");
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
				 
		return r;
		 
	 }
//	 public List<QnaVO> selectAdminQnaList(){
//		 String sql = "select * from qna";
//		 List<QnaVO> list = new ArrayList<>();
//		 try {
//			 psmt = conn.prepareStatement(sql);
//			 rs = psmt.executeQuery();
//			 
//			 while(rs.next()) {
//				 QnaVO qna = new QnaVO();
//				 qna.setUserId(rs.getString("user_id"));
//				 qna.setQnaType(rs.getString("qna_type"));
//				 qna.setOrderNum(rs.getString("order_num"));
//				 qna.setQnaDate(rs.getString("qna_date"));
//				 qna.setQnaTitle(rs.getString("qna_title"));
//				 qna.setQnaContent(rs.getString("qna_content"));
//				 qna.setQnaPhoto(rs.getString("qna_photo"));
//				 qna.setQnaStatus(rs.getString("qna_status"));
//				 qna.setResponseDate(rs.getString("response_date"));
//				 
//				 list.add(qna);
//			 }
//		 }catch(SQLException e) {
//			 e.printStackTrace();
//		 }finally {
//			 close();
//		 }
//		 return list;
//	 }
	 
	 
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
