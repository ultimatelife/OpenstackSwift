package com.swift.dao;

import com.swift.dto.UserInfoDto;

public interface UserInfoDao {
	
	//select + where
	public UserInfoDto userInfoSelectWhere(String id, String pw);
	
	//Update
	public void userInfoUpdate(String id,String pw,String name,String email,String container);

	//Insert
	public void userInfoInsert(String id,String pw,String name,String email,String container);
	
	//Delete
	public void userInfoDelete(String id);
	
}
