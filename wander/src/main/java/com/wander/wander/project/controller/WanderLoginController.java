package com.wander.wander.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wander.wander.project.bean.Note;
import com.wander.wander.project.bean.User;
import com.wander.wander.project.exception.WanderException;
import com.wander.wander.project.service.UserService;

@Controller
public class WanderLoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage( Model model) {
		User user = new User();
		model.addAttribute("user" , user);
		return "plain-login";
	}
	
	@GetMapping("/addUser")
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user" , user);
		return "user-form";
	}
	
	@GetMapping("/addNote")
	public String showFormForNote(Model model) {
		Note note = new Note();
		model.addAttribute("note" , note);
		return "note-form";
	}
		
	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute("user") User user, Model model) {
		User user1 = new User();
		model.addAttribute("user" , user1);
		String errorMessage;
		try {
			if(user.getUserName()  == null || user.getUserName() == "") {
				errorMessage = "Please enter User Name";
				model.addAttribute("errorMessage" , errorMessage);
				return "plain-login";
			}
			if(user.getPassword()  == null || user.getPassword() == "") {
				errorMessage = "Please enter Password ";
				model.addAttribute("errorMessage" , errorMessage);
				return "plain-login";
			}
			boolean isValid   = userService.isValidUser(user);
			if(isValid) {
				return "redirect:/listNotes";
			}else {
				errorMessage = "Invalid User details, Please enter again";
				model.addAttribute("errorMessage" , errorMessage);
				return "plain-login";
			}
		}catch (WanderException e) {
			errorMessage = "Internal error, Please try again";
			model.addAttribute("errorMessage" , errorMessage);
			return "plain-login";
		}
		catch (Exception e) {
			errorMessage = "Internal error, Please try again";
			model.addAttribute("errorMessage" , errorMessage);
			return "plain-login";
		}
		
		
	}
	
	@PostMapping("/saveNote")
	public String saveNote(@ModelAttribute("user") Note note,  Model model) {
		String errorMessage;
		try {
			if(note.getTitle()  == null || note.getTitle() == "") {
				errorMessage = "Please enter Title";
				model.addAttribute("errorMessage" , errorMessage);
				return "note-form";
			}
			if(note.getDescription() == null || note.getDescription() == "") {
				errorMessage = "Please enter Note Description ";
				model.addAttribute("errorMessage" , errorMessage);
				return "note-form";
			}
			userService.addNote(note);
		}
		catch (WanderException e) {
			errorMessage = "Internal error, Please try again";
			model.addAttribute("errorMessage" , errorMessage);
			return "note-form";
		}
		catch (Exception e) {
			errorMessage = "Internal error, Please try again";
			model.addAttribute("errorMessage" , errorMessage);
			return "note-form";
		}
		
		return "redirect:/listNotes";
	}
	@PostMapping("/saveUser")
	public String saveStudent(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/listNotes";
	}
	
	@GetMapping("/listNotes")
	public String listCustomer(Model model) {
		List<Note> notes = userService.getNotesCurrentUser();
		model.addAttribute("notes", notes);
		return "list-user";
	}
	
	// Add request mapping for  access denied
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}
	
	@GetMapping("/note/delete")
	public String deleteNote(@RequestParam("noteId") int id, Model model) {
		String errorMessage;
		try {
			userService.deleteNote(id);
		}catch (WanderException e) {
			errorMessage = "Error while deleting record";
			model.addAttribute("errorMessage" , errorMessage);
			return "redirect:/listNotes";
		}
		catch (Exception e) {
			errorMessage = "Error while deleting record";
			model.addAttribute("errorMessage" , errorMessage);
			return "redirect:/listNotes";
		}
		
		return "redirect:/listNotes";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("noteId") int id, Model model) {
		Note note = userService.getNote(id);
		model.addAttribute("note" , note);
		return "note-form";
	}
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "redirect:/showMyLoginPage";
	}
	
	
}
