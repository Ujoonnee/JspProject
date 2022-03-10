package co.yedam.qna;

import java.util.List;

public interface QnaService {
	
	 public List<QnaVO> selectQnaList(String userId);
	 public List<QnaVO> selectAllList();
	 public int insertQna(QnaVO vo);
	 public QnaVO selectofOrderNum(QnaVO vo);
	 public QnaVO selectofQnaData(QnaVO vo);
	 public List<QnaVO> strSelectofDate (String qnaDate);
	 public int responseUpdateQna(String date, String content);
	 public List<QnaVO> searchQna(String type, String text);
}
