package com.cameron.loginRegRevised.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameron.loginRegRevised.models.LoginUser;
import com.cameron.loginRegRevised.models.User;
import com.cameron.loginRegRevised.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uRepo;

	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public Object validate(User newUser, BindingResult result) {
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
//		TypeTool typeTool = new TypeTool();
//		typeTool.printType(potentialUser.isPresent());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "GENERAL_ERROR", "Email Already Registered, Please Log In Or Select Another.");
			
		}
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Confirm Password must match Password!");
			
		}
		return null;

	}
	public User register(User newUser) {
			String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hash);
			return this.uRepo.save(newUser);
		}
	

	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> potentialUser = uRepo.findByEmail(loginUser.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "GENERAL_ERROR", "Email Not Registered, Please Register.");
			return null;
		}
		User user = potentialUser.get();
		if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		} else {
			return user;
		}
	}
}
