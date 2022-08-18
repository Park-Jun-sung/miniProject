package com.uni.member.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	private static final long serialVersionUID = 6346615596757676147L;
	
	//1. 필드변수 컬럼에 대응~
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	
	public Member() {}

	public Member(String memberId, String memberPwd, String memberName) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberName) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Member [회원번호=" + memberNo + ", 아이디=" + memberId + ", 암호=" + memberPwd
				+ ", 회원명=" + memberName + "]";
	}

	public int getMember_no() {
		return memberNo;
	}

	public void setMember_no(int member_no) {
		this.memberNo = member_no;
	}

	public String getMember_id() {
		return memberId;
	}

	public void setMember_id(String member_id) {
		this.memberId = member_id;
	}

	public String getMember_pwd() {
		return memberPwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.memberPwd = member_pwd;
	}

	public String getMember_name() {
		return memberName;
	}

	public void setMember_name(String member_name) {
		this.memberName = member_name;
	}
	
	
	
}

