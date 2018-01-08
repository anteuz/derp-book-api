/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Recipe;
import io.swagger.model.Recipes;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Api(value = "recipes", description = "the recipes API")
public interface RecipesApi {

    @ApiOperation(value = "Gets list of all recipes", notes = "Returns a list containing all of the recipes", response = Recipes.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of Recipe", response = Recipes.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/recipes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Recipes> recipesGet( @Min(0) @Max(100)@ApiParam(value = "Number of recipes returned", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,@ApiParam(value = "Page number", defaultValue = "1") @RequestParam(value = "pageNumber", required = false, defaultValue="1") Integer pageNumber);


    @ApiOperation(value = "Gets recipe", notes = "Returns one recipe, corresponding with given id", response = Recipe.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested recipe by id", response = Recipe.class),
        @ApiResponse(code = 400, message = "The queried Recipe does not exists.", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/recipes/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Recipe> recipesIdGet(@ApiParam(value = "The ID of a Recipe",required=true ) @PathVariable("id") String id);


    @ApiOperation(value = "Creates a recipe", notes = "Adds new recipe to the recipes repository", response = Void.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Recipe created succesfully.", response = Void.class),
        @ApiResponse(code = 400, message = "Recipe could not have been created!", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/recipes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> recipesPost(@ApiParam(value = "the recipe to create."  )  @Valid @RequestBody Recipe recipe);


    @ApiOperation(value = "Updates a recipe", notes = "Update a recipe in the shopping recipe repository", response = Void.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Recipe updated succesfully.", response = Void.class),
        @ApiResponse(code = 400, message = "Recipe could not have been updated!", response = Void.class),
        @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    
    @RequestMapping(value = "/api/recipes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> recipesPut(@ApiParam(value = "The recipe to update."  )  @Valid @RequestBody Recipe recipe);

}
