package com.mychat.mychat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mychat.mychat.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("select case when count(u) > 0 then true else false end from User u where u.email = :email")
	Boolean emailExists(@Param("email") String email);
	
	@Query("select case when count(u) > 0 then true else false end from User u where u.email = :email and u.password = :pass")
	Boolean emailAndPassMatch(@Param("email") String email, @Param("pass") String pass);
	
	@Query("select u from User u where u.email = :email and u.password = :pass")
	User findUserByEmailAndPassword(@Param("email") String email, @Param("pass") String pass);
	
}
