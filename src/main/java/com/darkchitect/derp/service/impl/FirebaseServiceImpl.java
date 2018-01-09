package com.darkchitect.derp.service.impl;
import org.springframework.stereotype.Service;

import com.darkchitect.derp.config.auth.firebase.FirebaseTokenHolder;
import com.darkchitect.derp.service.FirebaseService;
import com.darkchitect.derp.service.shared.FirebaseParser;
import com.darkchitect.derp.spring.conditionals.FirebaseCondition;

@Service
@FirebaseCondition
public class FirebaseServiceImpl implements FirebaseService {
	@Override
	public FirebaseTokenHolder parseToken(String firebaseToken) {
		return new FirebaseParser().parseToken(firebaseToken);
	}
}