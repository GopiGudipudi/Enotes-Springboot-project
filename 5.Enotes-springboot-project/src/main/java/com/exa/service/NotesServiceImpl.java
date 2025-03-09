package com.exa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exa.entity.Notes;
import com.exa.entity.User;
import com.exa.repo.NotesRepo;
@Service
public class NotesServiceImpl implements NotesService {
	public NotesServiceImpl(NotesRepo notesRepo) {
		super();
		this.notesRepo = notesRepo;
	}

	private NotesRepo notesRepo;

	@Override
	public Notes saveNotes(Notes notes) {
		
		return notesRepo.save(notes);
	}

	@Override
	public Notes getNotesById(int id) {
		return notesRepo.findById(id).get();
	}

	@Override
	public  Page<Notes> getNotesByUser(User user,int pageNo) {
		Pageable pageable=PageRequest.of(pageNo,5);
		return notesRepo.findByUser(user,pageable);
	}

	@Override
	public Notes updateNotes(Notes notes) {
		
		return notesRepo.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) {
		Notes notes=notesRepo.findById(id).get();
		if(notes!=null) {
			notesRepo.delete(notes);
			return true;
		}
		return false;
	}

}
