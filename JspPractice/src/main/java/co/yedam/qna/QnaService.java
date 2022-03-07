package co.yedam.qna;

import java.util.List;

public interface QnaService {
	
	 public List<QnaVO> selectQnaList(String userId);
	 public int insertQna(QnaVO vo);
}
