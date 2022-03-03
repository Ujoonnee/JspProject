
public interface MemberService {
//FrontControl MyPage부분
	
	MemverVO searchAllMember(MemverVO vo);
	MemverVO searchOneMember(MemverVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
}
