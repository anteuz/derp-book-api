package io.swagger.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.config.auth.firebase.FirebaseTokenHolder;
import io.swagger.model.FirebaseToken;
import io.swagger.model.UserTokenState;
import io.swagger.security.TokenHelper;
import io.swagger.service.FirebaseService;
import io.swagger.service.UserService;
import io.swagger.service.shared.RegisterUserInit;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Controller
public class AuthApiController implements AuthApi {
	
	@Autowired
	private FirebaseService firebaseService;
	
    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private UserService userService;

    public ResponseEntity<UserTokenState> authPost(@ApiParam(value = "Firebase authentication token"  )  @Valid @RequestBody FirebaseToken token) {
    

    		FirebaseTokenHolder holder = firebaseService.parseToken(token.getToken());
    		
    		if(holder != null) {

    			if(userService.loadUserByUsername(holder.getUid()) == null) {
    				userService.registerUser(new RegisterUserInit(holder.getUid(), holder.getEmail()));
    			}
    			
    			String jws = tokenHelper.generateToken(holder.getUid());
    			int expiresIn = tokenHelper.getExpiredIn();
    			
    			return new ResponseEntity<UserTokenState>(new UserTokenState(jws, expiresIn), HttpStatus.OK);
    		}
    		else {
    			return new ResponseEntity<UserTokenState>(HttpStatus.UNAUTHORIZED);
    		}
    }

}
