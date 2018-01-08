package io.swagger.service;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.swagger.model.UserEntity;
import io.swagger.service.shared.RegisterUserInit;

public interface UserService extends UserDetailsService {

	UserEntity registerUser(RegisterUserInit init);

}