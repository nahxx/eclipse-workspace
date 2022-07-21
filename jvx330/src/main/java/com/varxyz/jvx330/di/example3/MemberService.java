package com.varxyz.jvx330.di.example3;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public List<Member> getAllMembers() {
		return memberDao.findAllMembers();
	}
}
