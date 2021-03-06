package co.yedam.qna;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.yedam.common.DAO;
import co.yedam.user.UserVO;

public class QnaServiceImpl extends DAO implements QnaService{
	 private PreparedStatement psmt;
	 private ResultSet rs;
	 
	 @Override
	 public List<QnaVO> selectQnaList(String userId){
		 String sql = "select * from qna where user_id = ? order by 4 desc";
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
		 String sql = "insert into qna(user_id,qna_type,order_num,qna_title,qna_content,qna_photo,qna_status) values(?,?,?,?,?,?,?)";
		 int r = 0;
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1,vo.getUserId());
			 psmt.setString(2,vo.getQnaType());
			 psmt.setString(3,vo.getOrderNum());
			 psmt.setString(4,vo.getQnaTitle());
			 psmt.setString(5,vo.getQnaContent());
			 psmt.setString(6,vo.getQnaPhoto());
			 psmt.setString(7,vo.getQnaStatus());
			 r=psmt.executeUpdate();
			 System.out.println(r+"건 입력");
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
				 
		return r;
		 
	 }
	 @Override
	 public List<QnaVO> selectAllList(){
		 String sql = "select * from qna order by 4 desc";
		 List<QnaVO> list = new ArrayList<>();
		 try {
			 psmt = conn.prepareStatement(sql);
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
	 public List<QnaVO> searchQna(String type, String text) {
		 String sql = "select * from qna where "+ type +" like ?";
		 List<QnaVO> list = new ArrayList<>();
		 
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, "%"+text+"%");
			 
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
	 public QnaVO selectofOrderNum(QnaVO vo){
		 String sql = "select * from qna where order_num = ?";
		 List<QnaVO> list = new ArrayList<>();
		 
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, vo.getOrderNum());
			 
			 rs = psmt.executeQuery();
			 
			 while(rs.next()) {
				 vo.setUserId(rs.getString("user_id"));
				 vo.setQnaType(rs.getString("qna_type"));
				 vo.setOrderNum(rs.getString("order_num"));
				 vo.setQnaDate(rs.getString("qna_date"));
				 vo.setQnaTitle(rs.getString("qna_title"));
				 vo.setQnaContent(rs.getString("qna_content"));
				 vo.setQnaPhoto(rs.getString("qna_photo"));
				 vo.setQnaStatus(rs.getString("qna_status"));
				 vo.setResponseDate(rs.getString("response_date"));
				 
				 list.add(vo);
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 return vo;
	 }
	 
	 @Override
	 public int responseUpdateQna(String content, String date){
		 String sql = "update qna set qna_content = ?, qna_status = '답변완료',  response_date = sysdate where qna_date = to_date(?,'YYYY-MM-DD HH24:MI:SS')";
		 int r = 0;
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, content);
			 psmt.setString(2, date);
			 
			 r = psmt.executeUpdate();
			 System.out.println(r + "건 수정");
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 return r;
	 }

	 @Override
	 public QnaVO selectofQnaData(QnaVO vo){
		 String sql = "select * from qna where qna_date = to_date(?,'YYYY-MM-DD HH24:MI:SS')";
		 
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, vo.getQnaDate());
			 
			 rs = psmt.executeQuery();
			 
			 if(rs.next()) {
				 vo.setUserId(rs.getString("user_id"));
				 vo.setQnaType(rs.getString("qna_type"));
				 vo.setOrderNum(rs.getString("order_num"));
				 vo.setQnaDate(rs.getString("qna_date"));
				 vo.setQnaTitle(rs.getString("qna_title"));
				 vo.setQnaContent(rs.getString("qna_content"));
				 vo.setQnaPhoto(rs.getString("qna_photo"));
				 vo.setQnaStatus(rs.getString("qna_status"));
				 vo.setResponseDate(rs.getString("response_date"));
				 
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 return vo;
	 }
	 @Override
	 public List<QnaVO> strSelectofDate (String qnaDate){
		 String sql = "select * from qna where qna_date = to_date(?,'YYYY-MM-DD HH24:MI:SS')";
		 List<QnaVO> list = new ArrayList<>();
		 try {
			 psmt = conn.prepareStatement(sql);
			 psmt.setString(1, qnaDate);
			 
			 rs = psmt.executeQuery();
			 
			 if(rs.next()) {
				 QnaVO vo = new QnaVO();
				 vo.setUserId(rs.getString("user_id"));
				 vo.setQnaType(rs.getString("qna_type"));
				 vo.setOrderNum(rs.getString("order_num"));
				 vo.setQnaDate(rs.getString("qna_date"));
				 vo.setQnaTitle(rs.getString("qna_title"));
				 vo.setQnaContent(rs.getString("qna_content"));
				 vo.setQnaPhoto(rs.getString("qna_photo"));
				 vo.setQnaStatus(rs.getString("qna_status"));
				 vo.setResponseDate(rs.getString("response_date"));
				 list.add(vo);
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close();
		 }
		 return list;
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
