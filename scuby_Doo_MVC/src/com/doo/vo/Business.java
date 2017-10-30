package com.doo.vo;

public class Business {
	
	private String dept;
	private String address;
	private String mid;
	private String name;
	private int price;
	private String intro;
	private String regdate;
	private int hit;
	private String fileSrc;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public Business() {
		this(null,null,null,null,null);
	}
	
	public Business(String dept,String code,String mid,String name, String intro)
	{
		this.dept = dept;
		this.address = address;
		this.mid = mid;
		this.name = name;
		this.intro = intro;
		this.regdate = null;
		this.hit = 0;
	}

	@Override
	public String toString() {
		return "Business [dept=" + dept + ", address=" + address + ", mid=" + mid + ", name=" + name + ", intro=" + intro
				+ ", regdate=" + regdate + ", hit=" + hit + "]";
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
}
