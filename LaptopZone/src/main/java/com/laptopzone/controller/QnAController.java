package com.laptopzone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptopzone.service.QnAService;

@WebServlet(urlPatterns = {"/qnaList", "/writeQnA", "/insertQnA", "/updateQnA", "/selectQnA", "/deleteQnA"})
public class QnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QnAController() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		String com = uri.substring(conPath.length());
		
		//QnA 목록
		if(com.equals("/qnaList")) {
			request.setAttribute("qnaList", new QnAService().getQnaList());
			
			view = "qna.jsp";
		
		
		}else if(com.equals("/selectQnA")) {
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			request.setAttribute("selectQnA", new QnAService().getSelectQnA(qnaNum));
			
			view = "selectQnA.jsp";
		
		//QnA 작성 페이지	
		}else if(com.equals("/writeQnA")) {
			String action = "insertQnA?";
			int qnaNum = 0;
			String tmp = request.getParameter("qnaNum");
			System.out.println(tmp);
			if(tmp != null && tmp.length() > 0) {
				qnaNum = Integer.parseInt(tmp);
			}
			
			if(qnaNum > 0) {
				action = "updateQnA?qnaNum="+qnaNum+"&";
				request.setAttribute("selectQnA", new QnAService().getSelectQnaUpate(qnaNum));
			}
			request.setAttribute("action", action);
			
			view = "writeQnA.jsp";
		
		//QnA 등록
		}else if(com.equals("/insertQnA")) {
			String qnaTitle = request.getParameter("qnaTitle");
			String qnaWriter = request.getParameter("qnaWriter");
			String qnaContent = request.getParameter("qnaContent");
			
			new QnAService().getInsertQnA(qnaTitle, qnaWriter, qnaContent);
			
			view = "redirect:qnaList";
			
		//QnA 수정	
		}else if(com.equals("/updateQnA")) {
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			String qnaTitle = request.getParameter("qnaTitle");
			String qnaContent = request.getParameter("qnaContent");
			
			new QnAService().getUpdateQnA(qnaNum, qnaTitle, qnaContent);
			
			view = "redirect:selectQnA?qnaNum="+qnaNum;
		
		//QnA 삭제	
		}else if(com.equals("/deleteQnA")) {
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			new QnAService().getDeleteQnA(qnaNum);
			
			view = "redirect:qnaList";
		}
		
			
			
		
		if(view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		}else{
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
