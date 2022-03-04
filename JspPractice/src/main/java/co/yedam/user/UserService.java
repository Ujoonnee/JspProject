package co.yedam.user;

import java.util.List;

public interface UserService {
	
	 public List<UserVO> selectUserList();
	 public UserVO selectUser(UserVO vo);
	 public int insertUser(UserVO vo);
	 public int updateUser(UserVO vo);
	 public int deleteUser(UserVO vo);
}
