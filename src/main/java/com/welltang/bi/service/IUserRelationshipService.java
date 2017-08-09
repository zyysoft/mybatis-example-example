package com.welltang.bi.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.welltang.bi.domain.CommentNeo4j;
import com.welltang.bi.domain.FollowNeo4j;
import com.welltang.bi.domain.InviteNeo4j;
import com.welltang.bi.domain.PostsPraiseNeo4j;
import com.welltang.bi.domain.User;
@Transactional(readOnly = true)
public interface IUserRelationshipService {

	/**
	 * 用户评价信息
	 */
	public List<CommentNeo4j> getComment();
	/**
	 * 用户关注信息
	 * @param beginDate
	 * @return
	 */
	public List<FollowNeo4j> getFollow(Date beginDate);
	/**
	 * 用户邀请信息
	 */
	public List<InviteNeo4j> getInvite(Date begindate);
	/**
	 * 用户点赞信息
	 * @return
	 */
	public List<PostsPraiseNeo4j> getPostsPraise();
	/**
	 * 获得用户信息
	 */
	public List<User> getUserInfor();
}
