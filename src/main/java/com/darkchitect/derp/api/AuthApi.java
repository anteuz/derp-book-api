/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.darkchitect.derp.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.darkchitect.derp.model.Error;
import com.darkchitect.derp.model.FirebaseToken;
import com.darkchitect.derp.model.UserTokenState;

import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "Generate API Authorization token from Firebase Authentication token", notes = "Generates new token used to access other API endpoints", response = UserTokenState.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "API Access token", response = UserTokenState.class),
        @ApiResponse(code = 401, message = "Invalid Auth Token", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<UserTokenState> authPost(@ApiParam(value = "Firebase authentication token"  )  @Valid @RequestBody FirebaseToken token);

}
