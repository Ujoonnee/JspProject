package co.yedam.user;

import java.util.List;

public interface UserService {
	 List<UserVO> selectUserList();
	 UserVO selectUser(UserVO vo);
	 public UserVO pwCheck(UserVO vo);
	 public int insertUser(UserVO vo);
	 public int updateUser(UserVO vo);
	 public int deleteUser(UserVO vo);
}
