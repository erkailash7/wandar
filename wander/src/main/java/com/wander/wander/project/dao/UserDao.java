package com.wander.wander.project.dao;

import java.util.List;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;

public interface UserDao {

	public void addUser(User user);
	public void addNote(Note note);
	public List<Note> getNotesCurrentUser();
	
	public List<User> getUsers();
	
	public boolean isValidUser(User user);
	
	public void deleteNote(int id);
	
	public Note getNote(int id);
	
}
