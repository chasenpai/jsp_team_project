package com.laptopzone.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptopzone.service.ProductService;
import com.laptopzone.service.ReviewService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns = {"/categoryAll", "/category", "/orderBy", "/orderByAll", "/productDetail", "/writeProduct", "/insertProduct", "/deleteProduct"})
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
			String tmp = request.getParameter("page");

			int pageNum;
			
			if(tmp != null && tmp.length() > 0) {
				pageNum = Integer.parseInt(tmp);
			}else {
				pageNum = 1;
			}
			
			request.setAttribute("pagination", new ProductService().getPagination(pageNum));
			request.setAttribute("productList", new ProductService().getProductList(pageNum));
			
			view = "categoryAll.jsp";
		
		//특정 제품 목록
		}else if(com.equals("/category")) {
			String productCategory = request.getParameter("productCategory");
			
			String tmp = request.getParameter("page");

			int pageNum;
			
			if(tmp != null && tmp.length() > 0) {
				pageNum = Integer.parseInt(tmp);
			}else {
				pageNum = 1;
			}
			
			request.setAttribute("pagination", new ProductService().getPagination(pageNum ,productCategory));
			request.setAttribute("productList", new ProductService().getProductList(pageNum, productCategory));
			
			view = "category"+productCategory+".jsp";
			
		//제품 전체 가격, 인기순 정렬
		}else if(com.equals("/orderByAll")) {
			String where = request.getParameter("where");
			String order = request.getParameter("order");
			
			String tmp = request.getParameter("page");

			int pageNum;
			
			if(tmp != null && tmp.length() > 0) {
				pageNum = Integer.parseInt(tmp);
			}else {
				pageNum = 1;
			}
			
			request.setAttribute("pagination", new ProductService().getPagination(pageNum));
			request.setAttribute("productList", new ProductService().getSortList(pageNum, where, order));
			if(where.equals("product_views")) {
				request.setAttribute("views", 1);
			}else if(where.equals("product_price") && order.equals("asc")){
				request.setAttribute("lowest", 1);
			}else if(where.equals("product_price") && order.equals("desc") ) {
				request.setAttribute("highest", 1);
			}
			
			view = "categoryAll.jsp";
		
		//특정 제품 가격, 인기순 정렬
		}else if(com.equals("/orderBy")) {
			String where = request.getParameter("where");
			String productCategory = request.getParameter("productCategory");
			String order = request.getParameter("order");
			
			String tmp = request.getParameter("page");

			int pageNum;
			
			if(tmp != null && tmp.length() > 0) {
				pageNum = Integer.parseInt(tmp);
			}else {
				pageNum = 1;
			}
			
			request.setAttribute("pagination", new ProductService().getPagination(pageNum, productCategory));
			request.setAttribute("productList", new ProductService().getSortList(pageNum, where, productCategory, order));
			
			if(where.equals("product_views")) {
				request.setAttribute("views", 1);
			}else if(where.equals("product_price") && order.equals("asc")){
				request.setAttribute("lowest", 1);
			}else if(where.equals("product_price") && order.equals("desc") ) {
				request.setAttribute("highest", 1);
			}
			
			view = "category"+productCategory+".jsp";
			
		//제품 상세
		}else if(com.equals("/productDetail")) {
			int productNum = Integer.parseInt(request.getParameter("productNum"));
			request.setAttribute("productDetail", new ProductService().getProductDetail(productNum));
			request.setAttribute("reviewList", new ReviewService().getReviewList(productNum));
			
			view = "product.jsp";
			
		//제품 등록 페이지	
		}else if(com.equals("/writeProduct")) {
			String action = "insertProduct";
			
			int productNum = 0;
			String tmp = request.getParameter("productNum");
			
			if(tmp != null && tmp.length() > 0) {
				productNum = Integer.parseInt(tmp);
			}
			
			if(productNum > 0) {
				action = "updateProduct?productNum="+productNum;
				request.setAttribute("productDetail", new ProductService().getWriteProduct(productNum));
				request.setAttribute("action", action);
			}
			request.setAttribute("action", action);
			
			view = "writeProduct.jsp";
		
		//제품 등록
		}else if(com.equals("/insertProduct")) {
			ServletContext context = request.getSession().getServletContext();
			String directory = context.getRealPath("/productImage");
			System.out.println(directory);
			MultipartRequest multi = new MultipartRequest(
					request,
					directory,
					100 * 1024 * 1024,
					"utf-8",
					new DefaultFileRenamePolicy());
			
			String productCatogory = multi.getParameter("productCategory");
			String productName = multi.getParameter("productName");
			String productCompany = multi.getParameter("productCompany");
			int productPrice = Integer.parseInt(multi.getParameter("productPrice"));
			int productStock = Integer.parseInt(multi.getParameter("productStock"));
			String productDetial = multi.getParameter("productDetail");
			File file = multi.getFile("productImage");
			String productImage = file.getName();
			
			new ProductService().getInsertProduct(productCatogory, productName, productCompany, productPrice, productStock, productDetial, productImage);
			System.out.println(directory);
			
			view = "redirect:categoryAll";
			
		}else if(com.equals("/updateProduct")) {
			
			
		}else if(com.equals("/deleteProduct")) {
			int productNum = Integer.parseInt(request.getParameter("productNum"));
			String productImage = request.getParameter("productImage");
			
			ServletContext context = request.getSession().getServletContext();
			String directory = context.getRealPath("/productImage/");
			File file = new File(directory+productImage);
			
			if(file.exists()) {
				file.delete();
			}
			
			new ProductService().getDeleteProduct(productNum);
			
			view = "redirect:categoryAll";
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
