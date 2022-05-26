package com.laptopzone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptopzone.service.MemberService;

@WebServlet(urlPatterns = {"/memberLogin", "/memberJoin", "/memberIdCheck", "/memberLogout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		String com = uri.substring(conPath.length());
		
		//로그인
		if(com.equals("/memberLogin")) {
			String memberId = request.getParameter("memberId");
			String memberPwd = request.getParameter("memberPwd");
			
			int result = new MemberService().getMemberLogin(memberId, memberPwd);
			
			if(result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("memberId", memberId);
				view = "redirect:index.jsp";		
			}else {
				request.setAttribute("failed", result);
				view = "login.jsp";
			}
		}else if(com.equals("/memberLogout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("memberId");
			
			view = "logout.jsp";
		}
		
		if(view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		}else{
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
