package com.welltang.bi.mapper.provider;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRelationshipProvider {
	private static Logger logger = LoggerFactory.getLogger(UserRelationshipProvider.class);
			
	public String getInvite(Date begindate) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("select a.creator_id as masterId,a.user_id as passiveId,a.register_time as createTime");
		querySql.append(" from analyze.dw_fact_patient a");
		querySql.append(" where  a.register_dt >= ");
		querySql.append(" #{begindate,jdbcType=DATE,javaType=java.sql.Date}");
		querySql.append(" and creator_id > 0");
		logger.info(querySql.toString());
		return querySql.toString();
	}
}
