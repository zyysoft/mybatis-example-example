package com.welltang.bi.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welltang.bi.domain.CommentNeo4j;
import com.welltang.bi.domain.FollowNeo4j;
import com.welltang.bi.domain.InviteNeo4j;
import com.welltang.bi.domain.PostsPraiseNeo4j;
import com.welltang.bi.domain.User;
import com.welltang.bi.mapper.UserRelationshipMapper;
import com.welltang.bi.service.IUserRelationshipService;

@Service("userRelationshipService")
public class UserRelationshipServiceImpl implements IUserRelationshipService{
	
	private static Logger logger = LoggerFactory.getLogger(IUserRelationshipService.class);
	
	@Autowired
    private UserRelationshipMapper userRelationshipMapper;
	
	@Override
	public List<CommentNeo4j> getComment() {
		// TODO Auto-generated method stub
		List<CommentNeo4j> list = userRelationshipMapper.getComment();
		return list;
	}

	@Override
	public List<FollowNeo4j> getFollow(Date beginDate) {
		// TODO Auto-generated method stub
		return userRelationshipMapper.getFollow(beginDate);
	}

	@Override
	public List<InviteNeo4j> getInvite(Date begindate) {
		// TODO Auto-generated method stub
		return userRelationshipMapper.getInvite(begindate);
	}

	@Override
	public List<PostsPraiseNeo4j> getPostsPraise() {
		// TODO Auto-generated method stub
		List<PostsPraiseNeo4j> list =userRelationshipMapper.getPostsPraise();
		return list;
	}

	@Override
	public List<User> getUserInfor() {
		// TODO Auto-generated method stub
		return userRelationshipMapper.getUsers();
	}
	
}