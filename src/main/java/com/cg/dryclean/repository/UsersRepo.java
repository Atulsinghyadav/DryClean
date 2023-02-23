package com.cg.dryclean.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.dryclean.entity.Usernames;

public interface UsersRepo extends JpaRepository<Usernames, Integer>{
	Optional<Usernames> findUserByEmail(String email);
}
