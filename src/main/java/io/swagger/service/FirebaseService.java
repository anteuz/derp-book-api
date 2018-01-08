package io.swagger.service;

import io.swagger.config.auth.firebase.FirebaseTokenHolder;

public interface FirebaseService {

	FirebaseTokenHolder parseToken(String idToken);

}