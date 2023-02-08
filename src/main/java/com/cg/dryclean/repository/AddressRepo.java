package com.cg.dryclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.dryclean.entity.Addresses;


@Repository
public interface AddressRepo extends JpaRepository<Addresses, Integer> {

}
