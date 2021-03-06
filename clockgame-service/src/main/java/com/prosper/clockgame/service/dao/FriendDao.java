package com.prosper.clockgame.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prosper.clockgame.service.bean.FriendPair;
import com.prosper.clockgame.service.mapper.FriendMapper;

@Repository
public class FriendDao {
	
	@Autowired
	private FriendMapper friendMapper;

	public FriendPair getOne(long userId, long friendId) {
		return friendMapper.getOne(userId, friendId);
	}

	public void insertOne(FriendPair friendPair) {
		friendMapper.insertOne(friendPair);
		
	}

	public void updateOne(FriendPair friendPair) {
		friendMapper.updateOne(friendPair);
	}

	public List<FriendPair> getListByUserIdAndStatus(long userId, short status) {
		return friendMapper.getListByUserId(userId, status);
	}

	public List<FriendPair> getListByFriendIdAndStatus(long userId, short status) {
		return friendMapper.getListByFriendIdAndStatus(userId, status);
	}
	
}
