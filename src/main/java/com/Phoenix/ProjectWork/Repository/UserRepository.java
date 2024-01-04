package com.Phoenix.ProjectWork.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Phoenix.ProjectWork.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


	@Query(nativeQuery =true,value="select * from user_table ut where ut.username =?1")
	Optional<User> findByUsername(String userName);

}
