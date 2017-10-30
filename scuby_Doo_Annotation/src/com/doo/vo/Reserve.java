package com.doo.vo;

public class Reserve {
	private int seq;
	private String gMid;
	private String hMid;
	private String rsvDate;
	private String rsvTime;
	private int number;
	private String state;
	private String regdate;
	private String bname;
	private String paymth;
	private String paynum;
	private String expiredate;
	private int hit;
	
	public String gethMid() {
		return hMid;
	}
	public void sethMid(String hMid) {
		this.hMid = hMid;
	}
	public Reserve() {
		this(null,null,null,null,0,null,null,null,null,null);
	}
	public Reserve(String gMid,String hMid,String rsvDate,String rsvTime,int number,
			String state, String bname,String paymth,String paynum,String expiredate)
	{
		this.gMid = gMid;
		this.hMid = hMid;
		this.rsvDate = rsvDate;
		this.rsvTime = rsvTime;
		this.number = number;
		this.state = state;
		this.regdate = null;
		this.bname = bname;
		this.paymth = paymth;
		this.paynum = paynum;
		this.expiredate = expiredate;
		this.hit = 0;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getGMid() {
		return gMid;
	}
	public void setGMid(String gMid) {
		this.gMid = gMid;
	}
	public String getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}
	public String getRsvTime() {
		return rsvTime;
	}
	public void setRsvtime(String rsvTime) {
		this.rsvTime = rsvTime;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPaymth() {
		return paymth;
	}
	public void setPaymth(String paymth) {
		this.paymth = paymth;
	}
	public String getPaynum() {
		return paynum;
	}
	public void setPaynum(String paynum) {
		this.paynum = paynum;
	}
	public String getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(String expiredate) {
		this.expiredate = expiredate;
	}
}
