package com.wander.wander.project.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;
import com.wander.wander.project.config.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao{


	public static int currentUserId ;
	
	@Override
	public void addUser(User user) {
		System.out.println("Dao calling..................");
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction  tr = 	session.beginTransaction();
	    
	    currentUserId= 	 (int) session.save(user);
	    System.out.println("Current user id = "+currentUserId);
		tr.commit();
	}

	@Override
	public void addNote(Note note) {
		System.out.println("Dao calling..................");
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user  = session.get(User.class, currentUserId);
		note.setUser(user);
		if(note.getNoteId() == 0) {
			note.setCreatedDate(new Date());
		}else {
			note.setUpdatedDate(new Date());
		}
		
	    Transaction  tr = 	session.beginTransaction();
		session.saveOrUpdate(note);
		tr.commit();
		
	}


	@Override
	public List<Note> getNotesCurrentUser() {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery(" from Note n where n.user.userId =:userId");
		 q.setParameter("userId", currentUserId);
		 List<Note> notes   = q.getResultList();
		return notes;
	}
	

	@Override
	public List<User> getUsers() {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery(" from User", User.class);
		 List<User> users   = q.getResultList();
		return users;
	}

	@Override
	public boolean isValidUser(User user) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery("  from User where userName =:userName and password =:password");
		 q.setParameter("userName", user.getUserName());
		 q.setParameter("password", user.getPassword());
		 List<User> users   = q.getResultList();
		 if(users == null || users.size()  ==0) {
			 return false;
		 }else {
			 currentUserId  = users.get(0).getUserId();
			 return true;
		 }
		
	}

	@Override
	public void deleteNote(int id) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Transaction  tr = 	session.beginTransaction();
		 Query q = session.createQuery(" delete from Note where noteId=:noteId");
		 q.setParameter("noteId", id);
		 q.executeUpdate();
		 tr.commit();
		
	}

	@Override
	public Note getNote(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Note user  = session.get(Note.class, id);
		return user;
	}

}
