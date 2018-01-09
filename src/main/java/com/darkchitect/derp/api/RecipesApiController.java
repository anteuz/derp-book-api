package com.darkchitect.derp.api;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.darkchitect.derp.model.Error;
import com.darkchitect.derp.model.Recipe;
import com.darkchitect.derp.model.Recipes;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Controller
public class RecipesApiController implements RecipesApi {

    public ResponseEntity<Recipes> recipesGet( @Min(0) @Max(100)@ApiParam(value = "Number of recipes returned", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,
        @ApiParam(value = "Page number", defaultValue = "1") @RequestParam(value = "pageNumber", required = false, defaultValue="1") Integer pageNumber) {
        // do some magic!
    		Recipes recipes = new Recipes();
    		Recipe recipe = new Recipe();
    		recipe.setId("1111-2222-3333");
    		recipe.setName("Tasty stuff");
    		recipe.setDescription("Very tasty..");
    		recipes.add(recipe);
        return new ResponseEntity<Recipes>(recipes, HttpStatus.OK);
    }

    public ResponseEntity<Recipe> recipesIdGet(@ApiParam(value = "The ID of a Recipe",required=true ) @PathVariable("id") String id) {
        // do some magic!
    		
        return new ResponseEntity<Recipe>(HttpStatus.OK);
    }

    public ResponseEntity<Void> recipesPost(@ApiParam(value = "the recipe to create."  )  @Valid @RequestBody Recipe recipe) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> recipesPut(@ApiParam(value = "The recipe to update."  )  @Valid @RequestBody Recipe recipe) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
