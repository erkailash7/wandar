package com.wander.wander.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;
import com.wander.wander.project.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void addNote(Note note) {
		userDao.addNote(note);
		
	}

	@Override
	public List<Note> getNotesCurrentUser() {
		return userDao.getNotesCurrentUser();
	}

	@Override
	public boolean isValidUser(User user) {
		return userDao.isValidUser(user);
	}

	@Override
	public void deleteNote(int id) {
		userDao.deleteNote(id);
		
	}

	@Override
	public Note getNote(int id) {
		return userDao.getNote(id);
	}

}
