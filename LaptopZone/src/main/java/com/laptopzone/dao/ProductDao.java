package com.laptopzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.laptopzone.dto.ProductDto;

public class ProductDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 제품 전체 목록
	public ArrayList<ProductDto> productList() {

		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		String query = "select * from product order by product_num desc";

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setProductNum(rs.getInt("product_num"));
				dto.setProductCategory(rs.getString("product_category"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductCompany(rs.getString("product_company"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductDetail(rs.getString("product_detail"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductRegdate(rs.getString("product_regdate"));
				dto.setProductViews(rs.getInt("product_views"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

	// 특정 카테고리 제품 목록
	public ArrayList<ProductDto> productList2(String productCategory) {

		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		String query = "select * from product where product_category = ? order by product_num desc";

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCategory);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setProductNum(rs.getInt("product_num"));
				dto.setProductCategory(rs.getString("product_category"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductCompany(rs.getString("product_company"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductDetail(rs.getString("product_detail"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductRegdate(rs.getString("product_regdate"));
				dto.setProductViews(rs.getInt("product_views"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

	// 제품 전체 가격순, 인기순 정렬
	public ArrayList<ProductDto> sortList(String where, String order) {

		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		String query = "select * from product order by " + where + " " + order;
		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setProductNum(rs.getInt("product_num"));
				dto.setProductCategory(rs.getString("product_category"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductCompany(rs.getString("product_company"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductDetail(rs.getString("product_detail"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductRegdate(rs.getString("product_regdate"));
				dto.setProductViews(rs.getInt("product_views"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

	// 특정 카테고리 가격순, 인기순 정렬
	public ArrayList<ProductDto> sortList(String where, String productCategory, String order) {

		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		String query = "select * from product where product_category = ? order by " + where + " " + order;

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCategory);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setProductNum(rs.getInt("product_num"));
				dto.setProductCategory(rs.getString("product_category"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductCompany(rs.getString("product_company"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductDetail(rs.getString("product_detail"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductRegdate(rs.getString("product_regdate"));
				dto.setProductViews(rs.getInt("product_views"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	
	//제품 상세 
	public ProductDto productDetail(int productNum) {
		ProductDto dto = new ProductDto();
		String query = "select * from product where product_num = ?";
		
		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setProductNum(rs.getInt("product_num"));
				dto.setProductCategory(rs.getString("product_category"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductCompany(rs.getString("product_company"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductDetail(rs.getString("product_detail"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductRegdate(rs.getString("product_regdate"));
				dto.setProductViews(rs.getInt("product_views"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}
	
	//메인 페이지 제품 이미지
	public ArrayList<ProductDto> imageList(){
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		
		String query = "SELECT product_image, product_num FROM product ORDER BY product_views desc LIMIT 12";
		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setProductImage(rs.getString("product_image"));
				dto.setProductNum(rs.getInt("product_num"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	

}
