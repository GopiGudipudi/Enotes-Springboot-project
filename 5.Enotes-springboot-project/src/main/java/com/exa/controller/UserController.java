package com.exa.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exa.entity.Notes;
import com.exa.entity.User;
import com.exa.repo.UserRepo;
import com.exa.service.NotesService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private NotesService notesService;
	@ModelAttribute
	public User getUser(Principal p, Model m) {

		String email=p.getName();
		User user=userRepo.findByEmail(email);
		m.addAttribute("user",user);
		return user;
		
	}
	@GetMapping("/addnotes")
	public String addnotes() {
		return "addnotes";
	}
	@GetMapping("/editnotes/{id}")
	public String editnotes(@PathVariable int id, Model m) {
		Notes notes=notesService.getNotesById(id);
		m.addAttribute("n", notes);
		return "editnotes";
	}
	@GetMapping("/viewnotes")
	public String viewnotes(Model m,Principal p,@RequestParam(defaultValue="0") Integer pageNo) {
		User user=getUser(p,m);
	Page<Notes> notes=notesService.getNotesByUser(user,pageNo);
	m.addAttribute("currentPage",pageNo);
	m.addAttribute("totalElements",notes.getTotalElements());
	m.addAttribute("totalPages",notes.getTotalPages());

	m.addAttribute("notesList",notes.getContent());
	   return"viewnotes";
	}
	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Notes notes,HttpSession session,Principal p,Model m) {
		notes.setDate(LocalDate.now());
	   notes.setUser(getUser(p,m));
		Notes saveNotes=notesService.saveNotes(notes);
		if(saveNotes!=null) {
			session.setAttribute("msg", "Notes Save Success");
		}else {
			session.setAttribute("msg","Something wrong on server");
		}
		return "redirect:/user/addnotes";
	}
	@PostMapping("/updateNotes")
	public String updateNotes(@ModelAttribute Notes notes,HttpSession session,Principal p,Model m) {
		notes.setDate(LocalDate.now());
	   notes.setUser(getUser(p,m));
		Notes saveNotes=notesService.saveNotes(notes);
		if(saveNotes!=null) {
			session.setAttribute("msg", "Notes Save Success");
		}else {
			session.setAttribute("msg","Something wrong on server");
		}
		return "redirect:/user/viewnotes";
	}
	@GetMapping("/deleteNotes/{id}")
	public String deleteNotes(@PathVariable int id,HttpSession session) {
		boolean f=notesService.deleteNotes(id);
		if(f) {
			session.setAttribute("msg", "Delete Success");
		}else {
			session.setAttribute("msg","Something wrong on server");
		}
	
		return "redirect:/user/viewnotes";
	}

}
