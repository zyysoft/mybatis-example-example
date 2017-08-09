package com.welltang.bi.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.welltang.bi.domain.CommentNeo4j;
import com.welltang.bi.domain.FollowNeo4j;
import com.welltang.bi.domain.InviteNeo4j;
import com.welltang.bi.domain.PostsPraiseNeo4j;
import com.welltang.bi.domain.User;
import com.welltang.bi.mapper.provider.UserRelationshipProvider;

public interface UserRelationshipMapper {
	@SelectProvider(method = "getInvite", type = UserRelationshipProvider.class)
	public List<InviteNeo4j> getInvite(@Param("begindate") Date begindate);

	@Select("select a.user_id as masterId,b.user_id as passiveId,count(1) as cnt "
			+ " from bbs.t_posts_comment a,bbs.t_posts b " 
			+ " where a.posts_id=b.id" 
			+ " group by a.user_id,b.user_id")
	public List<CommentNeo4j> getComment();
	
	@Select("select a.user_id as masterId,b.user_id as passiveId,count(1) as cnt"
			+ " from bbs.t_posts_praise a,bbs.t_posts b " 
			+ " where a.posts_id=b.id" 
			+ " group by a.user_id,b.user_id")
	public List<PostsPraiseNeo4j> getPostsPraise();
	
	@Select("select master_id as masterId,passive_id as passiveId,status,create_time as createTime,last_modify_time as lastmodifyTime"
				+ " from bbs.t_follow "
				+ "where last_modify_time >= #{begindate}")
	public List<FollowNeo4j> getFollow(@Param("begindate") Date beginDate);
	
	@Select("select a.user_id as user_id,a.name as user_name,substring(a.mobile,1,11) as mobile"
				+ " from analyze.dw_fact_doctor a"
				+ " union all "
				+ " select a.user_id as masterId,a.name as user_name,substring(a.mobile,1,11) as mobile"
				+ " from analyze.dw_fact_patient a")
	@Results(value={
			@Result(column="user_id",property="user_id",javaType=Integer.class,jdbcType=JdbcType.INTEGER),
			@Result(column="user_name",property="user_name")
	})
	public List<User> getUsers();
}