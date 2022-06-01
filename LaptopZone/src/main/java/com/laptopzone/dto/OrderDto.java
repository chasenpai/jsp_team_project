package com.laptopzone.dto;

public class OrderDto {

	private int orderNum;
	private String memberId;
	private int totalPrice;
	private String receiverName;
	private String receiverPhone;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String addressEtc;
	private String orderRegdate;
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getAddressEtc() {
		return addressEtc;
	}
	public void setAddressEtc(String addressEtc) {
		this.addressEtc = addressEtc;
	}
	public String getOrderRegdate() {
		return orderRegdate;
	}
	public void setOrderRegdate(String orderRegdate) {
		this.orderRegdate = orderRegdate;
	}
	
	
	
}
