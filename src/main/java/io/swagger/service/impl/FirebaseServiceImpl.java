package io.swagger.service.impl;
import org.springframework.stereotype.Service;

import io.swagger.config.auth.firebase.FirebaseTokenHolder;
import io.swagger.service.FirebaseService;
import io.swagger.service.shared.FirebaseParser;
import io.swagger.spring.conditionals.FirebaseCondition;

@Service
@FirebaseCondition
public class FirebaseServiceImpl implements FirebaseService {
	@Override
	public FirebaseTokenHolder parseToken(String firebaseToken) {
		return new FirebaseParser().parseToken(firebaseToken);
	}
}