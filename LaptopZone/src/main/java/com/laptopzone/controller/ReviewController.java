package com.laptopzone.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptopzone.service.ReviewService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = {"/selectReview", "/writeReview", "/insertReview", "/updateReview", "/deleteReview"})
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		String com = uri.substring(conPath.length());
		
		//리뷰 조회
		if(com.equals("/selectReview")) {
			int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
			request.setAttribute("selectReview", new ReviewService().getSelectReview(reviewNum));
			
			view = "selectReview.jsp";
		
		//리뷰 작성 페이지
		}else if(com.equals("/writeReview")) {
			String action = null;
			
			int productNum = 0;
			String tmp1 = request.getParameter("productNum");
		
			if(tmp1 != null && tmp1.length() > 0) {
				productNum = Integer.parseInt(tmp1);
			}
			
			if(productNum > 0) {
				action = "insertReview?productNum="+productNum;
				request.setAttribute("productNum", productNum);
				request.setAttribute("action", action);
			}
			
			//글 수정 모드
			int reviewNum = 0;
			String tmp2 = request.getParameter("reviewNum");
			
			if(tmp2 != null && tmp2.length() > 0) {
				reviewNum = Integer.parseInt(tmp2);
			}
			
			if(reviewNum > 0) {
				action = "updateReview?reviewNum="+reviewNum;
				request.setAttribute("selectReview", new ReviewService().getSelectReviewUpdate(reviewNum));
				request.setAttribute("action", action);
			}
			
			view = "writeReview.jsp";
			
		}else if(com.equals("/insertReview")) {
			
			ServletContext context = this.getServletContext();
			String directory = context.getRealPath("/reviewImage");
			MultipartRequest multi = new MultipartRequest(
					request,
					directory,
					100 * 1024 * 1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			
			int productNum = Integer.parseInt(multi.getParameter("productNum"));
			String reviewTitle = multi.getParameter("reviewTitle");
			String reviewWriter = multi.getParameter("reviewWriter");
			String content = multi.getParameter("reviewContent");
			File file = multi.getFile("reviewImage");
			String reviewImage = file.getName();
			
			new ReviewService().getInsertReview(productNum, reviewTitle, reviewWriter, content, reviewImage);
			
			view = "redirect:productDetail?productNum="+productNum;
		
		//리뷰 수정	
		}else if(com.equals("/updateReview")) {
			ServletContext context = this.getServletContext();
			String directory = context.getRealPath("/reviewImage");
			MultipartRequest multi = new MultipartRequest(
					request,
					directory,
					100 * 1024 * 1024,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			
			int reviewNum = Integer.parseInt(multi.getParameter("reviewNum"));
			String reviewTitle = multi.getParameter("reviewTitle");
			String content = multi.getParameter("reviewContent");
			File file = multi.getFile("reviewImage");
			String reviewImage = null;
			
			new ReviewService().getUpdateReview(reviewNum, reviewTitle, content, reviewImage);
			
			view = "redirect:selectReview?reviewNum="+reviewNum;
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
