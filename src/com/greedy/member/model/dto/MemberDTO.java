package com.greedy.member.model.dto;

import java.util.Date;

public class MemberDTO {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private int age;
	private Date enrollDate;
	
	public MemberDTO() {}

	public MemberDTO(int memberNo, String memberId, String memberPwd, String memberName, String gender, String email,
			String phone, String address, int age, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "\n[ 회원 번호 : " + memberNo + "\n회원 아이디 : " + memberId + "\n비밀번호 : " + memberPwd
				+ "\n회원 이름 : " + memberName + "\n성별 : " + gender + "\n이메일 : " + email + "\n전화번호 : " + phone
				+ "\n주소 : " + address + "\n나이 : " + age + "\n등록일 : " + enrollDate + " ]\n";
	}
	
	

}
