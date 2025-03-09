package com.exa.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.entity.Notes;
import com.exa.entity.User;
@Repository

public interface NotesRepo extends JpaRepository<Notes,Integer> {
	public Page<Notes> findByUser(User user,Pageable pageable);

}
