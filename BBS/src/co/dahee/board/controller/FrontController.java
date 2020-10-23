package co.dahee.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dahee.board.command.LoginAction;
import co.dahee.board.command.LoginForm;
import co.dahee.board.command.LogoutAction;
import co.dahee.board.command.MainAction;
import co.dahee.board.command.MemberForm;
import co.dahee.board.command.MemberInsertAction;
import co.dahee.board.command.MemberListAction;
import co.dahee.board.common.Action;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> map = new HashMap<String, Action>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 요청들을 정의O
		map.put("/main.do", new MainAction()); // 처음 들어오는 페이지 처리 (index.jsp)
		map.put("/login.do", new LoginAction()); // 로그인 메뉴 처리 (url에서 context path가 '/login.do'로 들어오면 LoginAction()을 수행하라는 의미)
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		map.put("/memberList.do", new MemberListAction()); // 회원 전체 리스트 보기
		map.put("/memberForm.do", new MemberForm()); // 회원 가입 화면 호출
		map.put("/memberInsert.do", new MemberInsertAction()); // 회원 입력
		map.put("/logout.do", new LogoutAction()); // 로그아웃
//		map.put("/main.do", new MainAction());
//		map.put("/main.do", new MainAction());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수행할 명령을 정리
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지용
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length()); // 실제 들어오는 요청 페이지를 찾음
		
		Action command = map.get(path);
		String viewPage = command.exec(request, response); // 명령이 수행되고 나서 보여줄 페이지 선택
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 선택한 페이지로 이동
		dispatcher.forward(request, response);
	}

}
