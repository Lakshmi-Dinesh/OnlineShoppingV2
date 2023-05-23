package com.shopping.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.api.SuccessResponse;
import com.shopping.model.User;
import com.shopping.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public ArrayList<User> getAllUsers() {
		return (ArrayList<User>) userRepo.findAll();
	}

	public ArrayList<User> findByName(String userName) {
		return (ArrayList<User>) userRepo.findByName(userName);
	}

	public SuccessResponse isUserNameUnique(String userName) {
		// return new
		// SuccessResponse(!(Optional.ofNullable(findByName(userName)).isPresent()));
		return new SuccessResponse((findByName(userName)).isEmpty());
	}

	public SuccessResponse createUser(User user) {

		if (validatePassword(user.getPassword())) {
			userRepo.save(user);
			return new SuccessResponse(true);
		} else {
			return new SuccessResponse(false);
		}
	}

	private boolean validatePassword(String password) {

		if (password.length() >= 8 && Pattern.compile("[\\p{Lower}]").matcher(password).find()
				&& Pattern.compile("[\\p{Upper}]").matcher(password).find()
				&& Pattern.compile("[\\p{Digit}]").matcher(password).find()
				&& Pattern.compile("[\\p{Punct}]").matcher(password).find()) {
			return true;
		} else
			return false;
	}

	public SuccessResponse login(User user) {
		ArrayList<User> userlist = userRepo.findByName(user.getuserName());
		if(!(userlist.isEmpty())&&(userlist.get(0).getPassword().compareTo(user.getPassword())==0)) {
			return new SuccessResponse(true);
		}
		else
			return new SuccessResponse(false);
	}
	
}
