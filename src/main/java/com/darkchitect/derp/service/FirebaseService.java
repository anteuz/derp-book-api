package com.darkchitect.derp.service;

import com.darkchitect.derp.config.auth.firebase.FirebaseTokenHolder;

public interface FirebaseService {

	FirebaseTokenHolder parseToken(String idToken);

}