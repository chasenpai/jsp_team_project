package com.laptopzone.service;

import com.laptopzone.dao.MemberDao;

public class MemberService {

	public int getMemberLogin(String memberId, String memberPwd) {
		int result = new MemberDao().memberLogin(memberId, memberPwd);
		
		return result;
	}
}
