package com.laptopzone.service;

import java.util.ArrayList;

import com.laptopzone.dao.CartDao;
import com.laptopzone.dao.OrderDao;
import com.laptopzone.dto.CartDto;
import com.laptopzone.dto.OrderDetailDto;
import com.laptopzone.dto.OrderDto;

public class OrderService {

	//주문정보입력
	public void getInsertOrder(String memberId, int totalPrice, String receiverName,
			String receiverPhone, String zipcode, String address, String addressDetail, String addressEtc) {
		
		OrderDto dto = new OrderDto();
		dto.setMemberId(memberId);
		dto.setTotalPrice(totalPrice);
		dto.setReceiverName(receiverName);
		dto.setReceiverPhone(receiverPhone);
		dto.setZipcode(zipcode);
		dto.setAddress(address);
		dto.setAddressDetail(addressDetail);
		dto.setAddressEtc(addressEtc);
		
		new OrderDao().insertOrder(dto);
	}
	
	//주문상세 정보입력
	public void getInsertOrderDetail(int productNum, int productPrice, int amount) {
		
		OrderDetailDto dto = new OrderDetailDto();
		dto.setProductNum(productNum);
		dto.setProduct_price(productPrice);
		dto.setAmount(amount);
		
		new OrderDao().insertOrderDetail(dto);
		
	}
	
	//장바구니 주문상세 정보입력
		public void getInsertCartOrderDetail(String memberId) {
			
			ArrayList<CartDto> cart = new CartDao().cartList(memberId);
			new OrderDao().insertCartOrderDetail(cart);
		}
	
	
	//주문정보
	public OrderDto getOrderInfo(String memberId) {
		OrderDto dto = new OrderDao().orderInfo(memberId);
		return dto;
	}
}
