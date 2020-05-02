package com.cts.training.backendservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	int userid;
	String seatno;
	String username;
	String password;
	String bookid;
	public Users() {}
	public Users(int userid, String seatno, String username, String password, String bookid) {
		super();
		this.userid = userid;
		this.seatno = seatno;
		this.username = username;
		this.password = password;
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", seatno=" + seatno + ", username=" + username + ", password=" + password
				+ ", bookid=" + bookid + "]";
	}
	
	
}
