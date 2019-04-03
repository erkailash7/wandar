package com.wander.wander;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;
import com.wander.wander.project.service.UserService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WanderApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void isLoginTest() {
		User user = new User();
		user.setUserId(12);
		user.setPassword("Tesmp");
		assertEquals(false, userService.isValidUser(user));
	}
	
	@Test
	public void createTest() {
		User user = new User();
		user.setUserId(12);
		user.setPassword("Tesmp");
		userService.addUser(user);
		assertEquals(true, userService.isValidUser(user));
	}
	
	@Test
	public void createNotes() {
		Note note = new Note();
		note.setDescription("THis note book for dhoni");
		note.setTitle("Book of Dhoni");
		userService.addNote(note);
		List<Note> notes = userService.getNotesCurrentUser();
		assertEquals(1, notes.size());
	}
	
	@Test
	public void createDelete() {
		int id =1;
		userService.deleteNote(id);
		List<Note> notes = userService.getNotesCurrentUser();
		assertEquals(0, notes.size());
	}

}

