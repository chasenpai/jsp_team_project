package com.laptopzone.service;

import java.util.ArrayList;

import com.laptopzone.dao.ProductDao;
import com.laptopzone.dto.ProductDto;

public class ProductService {

	//제품 목록
	public ArrayList<ProductDto> getProductList(){
		return new ProductDao().productList();
	}
	
	//특정 카테고리 제품 목록
	public ArrayList<ProductDto> getProductList(String productCategory){
		return new ProductDao().productList2(productCategory);
	}
	
	//제품 전체 가격순, 인기순 정렬
	public ArrayList<ProductDto> getSortList(String where, String order){
		return new ProductDao().sortList(where, order);
	}
	
	//특정 카테고리 가격순, 인기순 정렬
	public ArrayList<ProductDto> getSortList(String where ,String productCategory, String order){
		return new ProductDao().sortList(where, productCategory, order);
	}
	
	//제품상세
	public ProductDto getProductDetail(int productNum) {
		ProductDto dto = new ProductDao().productDetail(productNum);
		return dto;
	}
	
	//메인 페이지 제품 이미지
	public ArrayList<ProductDto> getImage(){
		return new ProductDao().imageList();
	}
}
