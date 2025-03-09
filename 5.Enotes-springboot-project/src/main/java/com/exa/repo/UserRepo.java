package com.exa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exa.entity.User;
@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
	public boolean existsByEmail(String email);
	public User findByEmail(String email);

}
