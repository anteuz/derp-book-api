/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.ShoppingList;
import io.swagger.model.ShoppingLists;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Api(value = "shoppingList", description = "the shoppingList API")
public interface ShoppingListApi {

    @ApiOperation(value = "Gets list of all shopping lists", notes = "Returns a list containing all of the shopping lists", response = ShoppingLists.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of ingredients", response = ShoppingLists.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/shoppingList",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ShoppingLists> shoppingListGet( @Min(0) @Max(100)@ApiParam(value = "Number of recipes returned", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,@ApiParam(value = "Page number", defaultValue = "1") @RequestParam(value = "pageNumber", required = false, defaultValue="1") Integer pageNumber);


    @ApiOperation(value = "Gets one shopping list", notes = "Returns one shopping list, corresponding with given id", response = ShoppingList.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested shopping list by id", response = ShoppingList.class),
        @ApiResponse(code = 400, message = "The queried shopping list does not exists.", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/shoppingList/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ShoppingList> shoppingListIdGet(@ApiParam(value = "The ID of a shopping-list",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "Creates a shopping list", notes = "Adds new shopping list to the shopping list repository", response = Void.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Shopping list created succesfully.", response = Void.class),
        @ApiResponse(code = 400, message = "Shopping list could not have been created!", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/shoppingList",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> shoppingListPost(@ApiParam(value = "The shopping-list to create."  )  @Valid @RequestBody ShoppingList shoppingList);


    @ApiOperation(value = "Updates a shopping list", notes = "Update ashopping list in the shopping list repository", response = Void.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Shopping list updated succesfully.", response = Void.class),
        @ApiResponse(code = 400, message = "Shopping list could not have been updated!", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/shoppingList",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> shoppingListPut(@ApiParam(value = "The shopping-list to update."  )  @Valid @RequestBody ShoppingList shoppingList);

}