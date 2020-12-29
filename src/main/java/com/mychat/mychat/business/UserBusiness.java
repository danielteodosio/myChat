package com.mychat.mychat.business;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mychat.mychat.entities.User;
import com.mychat.mychat.repositories.UserRepository;

@Service
public class UserBusiness {
	
	@Autowired
	private UserRepository userRepository;
	
    public ArrayList<User> getUsers() {
    	return (ArrayList<User>) userRepository.findAll();
    }
    
    public User getUserByEmailAndPassword(String email, String pass) {
    	return userRepository.findUserByEmailAndPassword(email, pass);
    }
    
    public User getUserById(Integer userId) {
    	return ((ArrayList<User>)userRepository.findAllById(Arrays.asList(userId))).get(0);
    }
    
    public Boolean emailExists(String email) {
    	return userRepository.emailExists(email);
    }
    
    public Boolean emailAndPassMatch(String email, String pass) {
    	return userRepository.emailAndPassMatch(email, pass);
    }
	
    public void saveUser(User user) {
    	userRepository.save(user);
    }
}
