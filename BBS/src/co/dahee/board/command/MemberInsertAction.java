package co.dahee.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dahee.board.common.Action;
import co.dahee.board.dao.MemberDAO;
import co.dahee.board.vo.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보를 DB에 입력
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("id")); // form 객체의 name 를 쓰는 것
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEnterdate(Date.valueOf(request.getParameter("enterdate")));

		int n = dao.insert(vo);
		String page;
		if (n != 0) { // 입력이 정상적으로 된 경우
			page = "jsp/member/insertSuccess.jsp";
		} else { // 입력이 실패한 경우
			page = "jsp/member/insertFail.jsp";
		}

		return page;
	}

}
