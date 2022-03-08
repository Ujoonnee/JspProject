package co.yedam.qna;

import java.util.List;

public interface QnaService {
	
	 public List<QnaVO> selectQnaList(String userId);
	 public List<QnaVO> selectAllList();
	 public int insertQna(QnaVO vo);
	 public QnaVO selectofOrderNum(QnaVO vo);
}
