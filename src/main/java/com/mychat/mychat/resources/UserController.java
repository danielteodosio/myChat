package com.mychat.mychat.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mychat.mychat.business.UserBusiness;
import com.mychat.mychat.entities.User;


@Controller
@CrossOrigin
@RequestMapping(value = "/myChat")
public class UserController {
	
	@Autowired
	private UserBusiness userBusiness;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> getAllUsers() {
		return ResponseEntity.ok(userBusiness.getUsers());
	}
	@RequestMapping(value = "/checkIfEmailExists", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkIfEmailExists(@RequestParam("email") String email){
		return ResponseEntity.ok(userBusiness.emailExists(email));
	}
	@RequestMapping(value = "/checkIfemailAndPassMatch", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkIfemailAndPassMatch(@RequestParam("email") String email, @RequestParam("pass") String pass){
		return ResponseEntity.ok(userBusiness.emailAndPassMatch(email, pass));
	}
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveUser(@RequestBody User user){
		userBusiness.saveUser(user);
		return ResponseEntity.ok(true);
	}
	@RequestMapping(value = "/getUserByNameAndPass", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmailAndPass(@RequestParam("userEmail") String userEmail, @RequestParam("userPass") String userPass){
		return ResponseEntity.ok(userBusiness.getUserByEmailAndPassword(userEmail, userPass));
	};
}
