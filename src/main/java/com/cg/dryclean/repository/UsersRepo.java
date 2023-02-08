package com.cg.dryclean.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.dryclean.entity.Usernames;

public interface UsersRepo extends JpaRepository<Usernames, Integer>{

}
