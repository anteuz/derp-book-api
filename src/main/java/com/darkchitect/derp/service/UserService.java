package com.darkchitect.derp.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.darkchitect.derp.model.UserEntity;
import com.darkchitect.derp.service.shared.RegisterUserInit;

public interface UserService extends UserDetailsService {

	UserEntity registerUser(RegisterUserInit init);

}