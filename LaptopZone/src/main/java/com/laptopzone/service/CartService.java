package com.laptopzone.service;

import java.util.ArrayList;

import com.laptopzone.dao.CartDao;
import com.laptopzone.dto.CartDto;

public class CartService {

	//장바구니 담기
	public CartDto getAddCart(String memberId, int productNum, int amount) {
		CartDto dto = new CartDto();
		dto.setMemberId(memberId);
		dto.setProductNum(productNum);
		dto.setAmount(amount);
		
		ArrayList<CartDto> cart = new ArrayList<CartDto>();
		
		cart.add(dto);
		
		new CartDao().addCart(dto);
		
		return dto;
	}
	
	//장바구니 목록
	public ArrayList<CartDto> getCartList(String memberId){
		return new CartDao().cartList(memberId);
	}
	
	//장바구니 가격 합계
	public int getSumPrice(String memberId) {
		return new CartDao().sumPrice(memberId);
	}
	
	//장바구니 삭제
	public void getDeleteCart(int cartNum) {
		new CartDao().deleteCart(cartNum);
	}
	
	//장바구니 삭제
	public void getDeleteCartAll(String memberId) {
		new CartDao().deleteCartAll(memberId);
	}
}
