package com.wander.wander.project.service;

import java.util.List;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;

public interface UserService {

	public void addUser(User user);
	public void addNote(Note note);
	public List<Note> getNotesCurrentUser();
	public boolean isValidUser(User user);
	public void deleteNote(int id);
	public Note getNote(int id);
}
