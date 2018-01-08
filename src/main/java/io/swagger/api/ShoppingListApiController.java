package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.ShoppingList;
import io.swagger.model.ShoppingLists;

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

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-07T11:49:28.117Z")

@Controller
public class ShoppingListApiController implements ShoppingListApi {



    public ResponseEntity<ShoppingLists> shoppingListGet( @Min(0) @Max(100)@ApiParam(value = "Number of recipes returned", defaultValue = "20") @RequestParam(value = "pageSize", required = false, defaultValue="20") Integer pageSize,
        @ApiParam(value = "Page number", defaultValue = "1") @RequestParam(value = "pageNumber", required = false, defaultValue="1") Integer pageNumber) {
        // do some magic!
        return new ResponseEntity<ShoppingLists>(HttpStatus.OK);
    }

    public ResponseEntity<ShoppingList> shoppingListIdGet(@ApiParam(value = "The ID of a shopping-list",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<ShoppingList>(HttpStatus.OK);
    }

    public ResponseEntity<Void> shoppingListPost(@ApiParam(value = "The shopping-list to create."  )  @Valid @RequestBody ShoppingList shoppingList) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> shoppingListPut(@ApiParam(value = "The shopping-list to update."  )  @Valid @RequestBody ShoppingList shoppingList) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
