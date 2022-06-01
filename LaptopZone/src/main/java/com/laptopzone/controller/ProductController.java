package com.laptopzone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptopzone.service.ProductService;

@WebServlet(urlPatterns = {"/categoryAll", "/category", "/orderBy", "/orderByAll", "/productDetail"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); 
		String com = uri.substring(conPath.length());
		
		//제품 전체 목록
		if(com.equals("/categoryAll")) {
			request.setAttribute("productList", new ProductService().getProductList());
			
			view = "categoryAll.jsp";
		
		//특정 제품 목록
		}else if(com.equals("/category")) {
			String productCategory = request.getParameter("productCategory");
			request.setAttribute("productList", new ProductService().getProductList(productCategory));
			
			view = "category"+productCategory+".jsp";
			
		//제품 전체 가격, 인기순 정렬
		}else if(com.equals("/orderByAll")) {
			String where = request.getParameter("where");
			String order = request.getParameter("order");
			request.setAttribute("productList", new ProductService().getSortList(where, order));
			
			view = "categoryAll.jsp";
		
		//특정 제품 가격, 인기순 정렬
		}else if(com.equals("/orderBy")) {
			String where = request.getParameter("where");
			String productCategory = request.getParameter("productCategory");
			String order = request.getParameter("order");
			request.setAttribute("productList", new ProductService().getSortList(where, productCategory, order));
			
			view = "category"+productCategory+".jsp";
			
		//제품 상세
		}else if(com.equals("/productDetail")) {
			int productNum = Integer.parseInt(request.getParameter("productNum"));
			request.setAttribute("productDetail", new ProductService().getProductDetail(productNum));
			
			view = "product.jsp";
			
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
