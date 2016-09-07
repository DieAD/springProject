package com.phn.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.phn.dao.IUserDao;
import com.phn.model.UserEntity;

public class UserDaoImpl implements IUserDao{
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public boolean isExist(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from UserEntity where username = ? and password= ?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		if(query.list().size()>=1){
			return true;
		}
		return false;
	}

}
