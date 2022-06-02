package com.laptopzone.service;

import java.util.ArrayList;

import com.laptopzone.dao.CartDao;
import com.laptopzone.dao.OrderDao;
import com.laptopzone.dto.CartDto;
import com.laptopzone.dto.OrderDto;

public class OrderService {

	// 주문정보입력
	public void getInsertOrder(String memberId, int totalPrice, String receiverName, String receiverPhone,
			String zipcode, String address, String addressDetail, String addressEtc, int productNum, String productName,
			int productPrice, int amount) {

		OrderDto dto = new OrderDto();
		dto.setMemberId(memberId);
		dto.setTotalPrice(totalPrice);
		dto.setReceiverName(receiverName);
		dto.setReceiverPhone(receiverPhone);
		dto.setZipcode(zipcode);
		dto.setAddress(address);
		dto.setAddressDetail(addressDetail);
		dto.setAddressEtc(addressEtc);
		dto.setProductNum(productNum);
		dto.setProductName(productName);
		dto.setProductPrice(productPrice);
		dto.setAmount(amount);

		new OrderDao().insertOrder(dto);
	}

	// 장바구니 주문상세 정보입력
	public void getInsertCartOrder(String memberId, int totalPrice, String receiverName, String receiverPhone,
			String zipcode, String address, String addressDetail, String addressEtc) {

		OrderDto dto = new OrderDto();
		dto.setMemberId(memberId);
		dto.setTotalPrice(totalPrice);
		dto.setReceiverName(receiverName);
		dto.setReceiverPhone(receiverPhone);
		dto.setZipcode(zipcode);
		dto.setAddress(address);
		dto.setAddressDetail(addressDetail);
		dto.setAddressEtc(addressEtc);

		ArrayList<CartDto> cart = new CartDao().cartList(memberId);
		new OrderDao().insertCartOrder(dto, cart);
	}

	// 주문정보
	public OrderDto getOrderInfo(String memberId) {
		OrderDto dto = new OrderDao().orderInfo(memberId);
		return dto;
	}

	// 주문목록
	public ArrayList<OrderDto> getOrderList(String memberId){
		return new OrderDao().orderList(memberId);
	}
}
