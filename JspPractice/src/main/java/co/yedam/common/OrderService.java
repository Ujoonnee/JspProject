
public interface OrderService {
//FrontControl admin pages부분
	
	MemverVO searchAllMember(MemverVO vo);
	MemverVO searchOneMember(MemverVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
}
