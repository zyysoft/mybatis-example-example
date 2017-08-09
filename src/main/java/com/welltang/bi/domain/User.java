package com.welltang.bi.domain;

import java.util.Set;

//@NodeEntity
public class User {

//	@GraphId
	private int user_id;
	
	private String user_name;
	private String mobile;
	
//	@Relationship(type="BBS_COMMENT", direction = Relationship.INCOMING)
	Set<User> commentSet;
	
//	@Relationship(type="BBS_FOLLOW", direction = Relationship.INCOMING)
	Set<User> followSet;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
