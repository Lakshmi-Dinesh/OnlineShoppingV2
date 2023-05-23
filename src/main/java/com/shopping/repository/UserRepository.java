package com.shopping.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.shopping.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("select i from User i where i.userName = ?1")
	ArrayList<User> findByName(String userName);

}
