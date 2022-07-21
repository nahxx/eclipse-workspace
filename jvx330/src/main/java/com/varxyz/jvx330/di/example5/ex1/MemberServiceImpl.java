package com.varxyz.jvx330.di.example5.ex1;

public class MemberServiceImpl implements MemberService {
	
	public MemberServiceImpl() {
		System.out.println("빈 생성 : " + this);
	}
	
	@Override
	public void addMember(String id, String passwd) {
		System.out.println("New member inserted : " + id + "/" + passwd);
	}
}
