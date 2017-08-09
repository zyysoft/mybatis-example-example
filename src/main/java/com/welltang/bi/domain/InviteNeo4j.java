package com.welltang.bi.domain;

public class InviteNeo4j extends Neo4jNode {
	 
	//邀请时间
	public long createTime;
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Date createTime) {
		this.createTime = createTime.getTime();
	}
}