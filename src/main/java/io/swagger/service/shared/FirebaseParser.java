package io.swagger.service.shared;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.Task;
import com.google.firebase.tasks.Tasks;

import io.swagger.config.auth.firebase.FirebaseTokenHolder;
import io.swagger.service.exception.FirebaseTokenInvalidException;
import io.swagger.util.StringUtil;



public class FirebaseParser {
	public FirebaseTokenHolder parseToken(String idToken) {
		if (StringUtil.isBlank(idToken)) {
			throw new IllegalArgumentException("FirebaseTokenBlank");
		}
		try {
			Task<FirebaseToken> authTask = FirebaseAuth.getInstance().verifyIdToken(idToken);

			Tasks.await(authTask);

			return new FirebaseTokenHolder(authTask.getResult());
		} catch (Exception e) {
			throw new FirebaseTokenInvalidException(e.getMessage());
		}
	}
}