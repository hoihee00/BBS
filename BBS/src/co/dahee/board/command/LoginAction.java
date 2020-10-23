package co.dahee.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dahee.board.common.Action;
import co.dahee.board.dao.MemberDAO;
import co.dahee.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 인증 과정을 처리한다
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
//		String msg;
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.select(vo); // MemberDAO를 실행시킴
		
//		if(vo.getName() == null) { // 존재하지 않을 때 메세지를 실어 보냄
//			msg = "존재하지 않는 ID 입니다.";
//			request.setAttribute("msg", msg);
//		} 
		request.setAttribute("vo", vo); // 멤버를 실어 보냄
		return "jsp/main/loginResult.jsp";
	}

}
