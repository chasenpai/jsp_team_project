package com.laptopzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.laptopzone.dto.CartDto;
import com.laptopzone.dto.OrderDetailDto;
import com.laptopzone.dto.OrderDto;

public class OrderDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 주문정보 입력
	public void insertOrder(OrderDto dto) {
		String query = "insert into orders values(order_num, ?, ?, ?, ?, ?, ?, ?, ?, now())";

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setInt(2, dto.getTotalPrice());
			pstmt.setString(3, dto.getReceiverName());
			pstmt.setString(4, dto.getReceiverPhone());
			pstmt.setString(5, dto.getZipcode());
			pstmt.setString(6, dto.getAddress());
			pstmt.setString(7, dto.getAddressDetail());
			pstmt.setString(8, dto.getAddressEtc());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 주문 상세정보 입력
	public void insertOrderDetail(OrderDetailDto dto) {
		String query1 = "select max(order_num) from orders";
		String query2 = "insert order_detail values(order_detail_num, ?, ?, ? ,?)";
		int orderNum = 0;

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query1);
			rs = pstmt.executeQuery();

			rs.next();
			orderNum = rs.getInt(1);

			rs.close();
			pstmt.close();

			pstmt = conn.prepareStatement(query2);
			pstmt.setInt(1, orderNum);
			pstmt.setInt(2, dto.getProductNum());
			pstmt.setInt(3, dto.getProduct_price());
			pstmt.setInt(4, dto.getAmount());
			pstmt.executeUpdate();

		} catch (SQLException e) {

		}
	}

	//장바구니 주문 상세정보 입력
	public void insertCartOrderDetail(ArrayList<CartDto> cart) {
		String query1 = "select max(order_num) from orders";
		String query2 = "insert order_detail values(order_detail_num, ?, ?, ? ,?)";
		int orderNum = 0;

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query1);
			rs = pstmt.executeQuery();

			rs.next();
			orderNum = rs.getInt(1);
			System.out.println(orderNum);

			rs.close();
			pstmt.close();
			
			for (int i = 0; i < cart.size(); i++) {
				pstmt = conn.prepareStatement(query2);
				pstmt.setInt(1, orderNum);
				pstmt.setInt(2, cart.get(i).getProductNum());
				pstmt.setInt(3, cart.get(i).getProductPrice());
				pstmt.setInt(4, cart.get(i).getAmount());
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {

		}
	}

	// 주문정보
	public OrderDto orderInfo(String memberId) {
		OrderDto dto = new OrderDto();
		String query = "select * from orders where member_id = ?";

		try {
			conn = DBconnector.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setOrderNum(rs.getInt("order_num"));
				dto.setMemberId(rs.getNString("member_id"));
				dto.setReceiverName(rs.getString("receiver_name"));
				dto.setReceiverPhone(rs.getString("receiver_phone"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress(rs.getString("address"));
				dto.setAddressDetail(rs.getString("address_detail"));
				dto.setAddressEtc(rs.getString("address_etc"));
				dto.setOrderRegdate(rs.getString("order_regdate"));
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
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 주문목록
//	public ArrayList<OrderDto> orderList(String memberId){
//		ArrayList<OrderDto> list = new ArrayList<OrderDto>();
//		String query = "";
//	}

	

}
