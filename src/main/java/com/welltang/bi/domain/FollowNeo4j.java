package com.welltang.bi.domain;

import java.util.Date;

public class FollowNeo4j extends Neo4jNode{
	//关注状态
	public int status;
	//关注时间
	public long createTime;
	public long lastmodifyTime;
 
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime.getTime();
	}
	public long getLastmodifyTime() {
		return lastmodifyTime;
	}
	public void setLastmodifyTime(Date lastmodifyTime) {
		this.lastmodifyTime = lastmodifyTime.getTime();
	}
}
