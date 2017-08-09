package com.welltang.bi;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.welltang.bi.Util.DateUtils;
import com.welltang.bi.domain.CommentNeo4j;
import com.welltang.bi.domain.FollowNeo4j;
import com.welltang.bi.domain.InviteNeo4j;
import com.welltang.bi.domain.PostsPraiseNeo4j;
import com.welltang.bi.domain.User;
import com.welltang.bi.service.IUserRelationshipService;

public class MainService {
	private static Logger logger = LoggerFactory.getLogger(MainService.class);
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-applicationConetext.xml");
		final IUserRelationshipService userRelationshipService = ac.getBean("userRelationshipService",
				IUserRelationshipService.class);
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<List<User>> userFuture =executorService.submit(new Callable<List<User>>() {
			@Override
			public List<User> call() throws Exception {
				logger.info("userRelationshipService.getUserInfor .. START RUNING");
				return userRelationshipService.getUserInfor();
			}
		});
		
//		Future<List<InviteNeo4j>> inviteFuture =executorService.submit(new Callable<List<InviteNeo4j>>() {
//			@Override
//			public List<InviteNeo4j> call() throws Exception {
//				logger.info("userRelationshipService.getInvite .. START RUNING");
//				return userRelationshipService.getInvite(DateUtils.parseDate("20161101"));
//			}
//		});
		Future<List<CommentNeo4j>> commentFuture =executorService.submit(new Callable<List<CommentNeo4j>>() {
			@Override
			public List<CommentNeo4j> call() throws Exception {
				logger.info("userRelationshipService.getComment .. START RUNING");
				return userRelationshipService.getComment();
			}
		});
		
		Future<List<PostsPraiseNeo4j>> postFuture =executorService.submit(new Callable<List<PostsPraiseNeo4j>>() {
			@Override
			public List<PostsPraiseNeo4j> call() throws Exception {
				logger.info("userRelationshipService.getPostsPraise .. START RUNING");
				return userRelationshipService.getPostsPraise();
			}
		});
		
		Future<List<FollowNeo4j>> followFuture =executorService.submit(new Callable<List<FollowNeo4j>>() {
			@Override
			public List<FollowNeo4j> call() throws Exception {
				logger.info("userRelationshipService.getFollow .. START RUNING");
				return userRelationshipService.getFollow(DateUtils.parseDate("20161101"));
			}
		});
		
//		List<InviteNeo4j> inviteList = inviteFuture.get();
		List<CommentNeo4j> commentList = commentFuture.get();
		List<PostsPraiseNeo4j> postsPraiseList = postFuture.get();
		List<FollowNeo4j> followList = followFuture.get();
		List<User> userList = userFuture.get();
		
		System.out.println(commentList.size());
		executorService.shutdown();
		logger.info("inviteList size:{},commentList size:{},postsPraiseList size:{},followList size:{},userList size:{}"
				,commentList.size(),postsPraiseList.size(),followList.size(),userList.size());
	}
}