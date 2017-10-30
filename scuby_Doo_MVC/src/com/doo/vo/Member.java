package com.doo.vo;

public class Member {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	private String birthday;
	private String phone;
	private String address;
	private String email;
	private String proper;
	private String state;
	private String regdate;
	private String dist;
	
	public Member() {
		this(null,null,null,null,0,null,null,null,null,null,null);
	}
	
	public Member(String mid,String pwd,String name,String gender,int age,
			String birthday, String phone, String address,String email,String proper,String state)
	{
		this.mid = mid;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.proper = proper;
		this.state = state;
		this.regdate = null;
		this.dist = null;
	}

	public String getProper() {
		return proper;
	}

	public void setProper(String proper) {
		this.proper = proper;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Member [mid=" + mid + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", birthday=" + birthday + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", state=" + state + ", regdate=" + regdate + ", dist=" + dist + "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}
	
	
}
