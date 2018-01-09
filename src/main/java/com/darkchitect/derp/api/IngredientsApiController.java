package com.darkchitect.derp.api;

import io.swagger.annotations.*;

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
import com.darkchitect.derp.model.Ingredient;
import com.darkchitect.derp.model.Ingredients;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Controller
public class IngredientsApiController implements IngredientsApi {



    public ResponseEntity<Ingredients> ingredientsGet( @Min(0) @Max(100)@ApiParam(value = "Number of recipes returned", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,
        @ApiParam(value = "Page number", defaultValue = "1") @RequestParam(value = "pageNumber", required = false, defaultValue="1") Integer pageNumber) {
        // do some magic!
        return new ResponseEntity<Ingredients>(HttpStatus.OK);
    }

    public ResponseEntity<Ingredient> ingredientsIdGet(@ApiParam(value = "The ID of a ingredient",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Ingredient>(HttpStatus.OK);
    }

    public ResponseEntity<Void> ingredientsPost(@ApiParam(value = "The ingredient to create."  )  @Valid @RequestBody Ingredient ingredient) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> ingredientsPut(@ApiParam(value = "The ingredient to update."  )  @Valid @RequestBody Ingredient ingredient) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
