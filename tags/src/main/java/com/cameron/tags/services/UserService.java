package com.cameron.tags.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cameron.tags.models.LoginUser;
import com.cameron.tags.models.User;
import com.cameron.tags.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository uRepo;
	
    
	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
    public User register(User newUser, BindingResult result) {
//		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
//		TypeTool typeTool = new TypeTool();
//		typeTool.printType(potentialUser.isPresent());
		if(uRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email","GENERAL_ERROR", "Email Already Registered, Please Log In Or Select Another.");
		}
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Confirm Password must match Password!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hash);
			return this.uRepo.save(newUser);
		}
    }
    
    public User login(LoginUser loginUser, BindingResult result) {
    	Optional<User> potentialUser = uRepo.findByEmail(loginUser.getEmail());
        User user = potentialUser.get();
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
		    result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
    }
}
