package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.User;

public class UserDAO {
	public UserDAO() {
		
	}
	
	public User createUser(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
    Session session = factory.getCurrentSession();
    session.getTransaction().begin();
    
    session.persist(user);
    session.flush();
      
    session.getTransaction().commit();
		return user;
	}
	
	public User updateUser(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    User entity = (User)session.get(User.class, user.getId());

      entity.setUsername(user.getUsername());
      entity.setPassword(user.getPassword());
      entity.setFullName(user.getFullName());
      entity.setRole(user.getRole());
      entity.setAddress(user.getAddress());
      entity.setPhoneNumber(user.getPhoneNumber());
      	    
	    session.update(entity);
	    
	    session.flush();
      session.getTransaction().commit();
      return entity;
	}
	
	public long numberOfUsers() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + User.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<User> listUsers(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + User.class.getName() + " p where p.deletedOn = null";
        Query<User> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<User> users = query.list();
        
        session.getTransaction().commit();
        return users;
	}
	
	public User getUserById(int userId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + User.class.getName() + " p where id=:userId";
        Query<User> query = session.createQuery(sql);
        query.setParameter("id", userId);
        
        List<User> users = query.list();
        
        session.getTransaction().commit();
        
        if (users.size() == 0)
        	return null;
        
        return users.get(0);
	}
	
	public void deleteUserById(int userId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    User user = (User)session.get(User.class, userId);
	    
	    user.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(user);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}