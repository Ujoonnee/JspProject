package co.micol.dbtest.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.member.serviceImpl.MemberServiceImpl;
import co.micol.dbtest.member.vo.MemberVO;

public class MemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberServiceImpl service = new MemberServiceImpl();
		List<MemberVO> list = service.selectMemberList();
		
		request.setAttribute("list",list);
		
		return "member/memberList.tiles";
	}

}
