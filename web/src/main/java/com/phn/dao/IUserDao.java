package com.phn.dao;

import com.phn.model.UserEntity;

public interface IUserDao {
	public boolean isExist(UserEntity user);
}
