package co.dahee.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dahee.board.common.Action;
import co.dahee.board.dao.MemberDAO;
import co.dahee.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 인증 과정을 처리한다
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(false);
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.select(vo); // MemberDAO를 실행시킴
		
		session.setAttribute("id", vo.getId()); // session에 id 담음
		session.setAttribute("author", vo.getAuthor()); // session에 author(권한) 담음
		session.setAttribute("name", vo.getName());
		
		request.setAttribute("vo", vo); // 멤버를 실어 보냄
		return "jsp/main/loginResult.jsp";
	}

}
