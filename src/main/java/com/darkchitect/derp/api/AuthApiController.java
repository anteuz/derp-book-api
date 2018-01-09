package com.darkchitect.derp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.darkchitect.derp.config.auth.firebase.FirebaseTokenHolder;
import com.darkchitect.derp.model.FirebaseToken;
import com.darkchitect.derp.model.UserTokenState;
import com.darkchitect.derp.security.TokenHelper;
import com.darkchitect.derp.service.FirebaseService;
import com.darkchitect.derp.service.UserService;
import com.darkchitect.derp.service.shared.RegisterUserInit;

import io.swagger.annotations.ApiParam;
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
