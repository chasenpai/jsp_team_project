package com.laptopzone.service;

import com.laptopzone.dao.MemberDao;
import com.laptopzone.dto.MemberDto;

public class MemberService {

	//로그인
	public int getMemberLogin(String memberId, String memberPwd) {
		int result = new MemberDao().memberLogin(memberId, memberPwd);
		
		return result;
	}
	
	//아이디 중복체크
	public int getIdCheck(String memberId) {
		int result = new MemberDao().checkId(memberId);
		
		return result;
	}
	
	//회원가입
	public void getMemberJoin(String memberId, String memberPwd, String memberName, String MemberPhone, 
			String memberZipcode, String memberAddress, String memberAddressDetail, String memberAddressEtc) {
		
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setMemberPhone(MemberPhone);
		dto.setMemberZipcode(memberZipcode);
		dto.setMemberAddress(memberAddress);
		dto.setMemberAddressDetail(memberAddressDetail);
		dto.setMemberAddressEtc(memberAddressEtc);
		
		new MemberDao().memberJoin(dto);
	}
	
	//회원정보
	public MemberDto getMemberInfo(String memberId) {
		MemberDto dto = new MemberDao().showMemberInfo(memberId);
		return dto;
	}
	
	//회원정보수정
	public void getMemberUpdate(String memberId, String memberPwd, String memberName, String MemberPhone, 
			String memberZipcode, String memberAddress, String memberAddressDetail, String memberAddressEtc) {
		
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberId);
		dto.setMemberPwd(memberPwd);
		dto.setMemberName(memberName);
		dto.setMemberPhone(MemberPhone);
		dto.setMemberZipcode(memberZipcode);
		dto.setMemberAddress(memberAddress);
		dto.setMemberAddressDetail(memberAddressDetail);
		dto.setMemberAddressEtc(memberAddressEtc);
		
		new MemberDao().memberUpdate(dto);
		
	}
	
	//회원탈퇴
	public void getMemberDelete(String memberId) {
		new MemberDao().memberDelete(memberId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
