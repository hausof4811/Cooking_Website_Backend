package com.james.cooking.demo.CookingBackend.controller;
import com.james.cooking.demo.CookingBackend.domain.request.CreateRecipe;
import com.james.cooking.demo.CookingBackend.entity.RecipeEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.james.cooking.demo.CookingBackend.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor //this creates a constructor with all required arguments, this can replace autowired
public class RecipeController {

    private final RecipeService recipeService;

    //get one recipe by UUID
    @GetMapping(value = "/recipe")
    public ResponseEntity<RecipeEntity[]> getRecipeByUuid(@RequestParam UUID externalId) {
         return new ResponseEntity(recipeService.getRecipeByUuid(externalId) , HttpStatus.OK);
    }

    //get an amount of recipe names and UUIDs to return for list view
    @GetMapping(value = "/recipes")
    public ResponseEntity<RecipeEntity> getRecipes(@RequestParam int PageWanted, @RequestParam int numRecipesWantedPerPage){
        return new ResponseEntity(recipeService.getRecipes(PageWanted, numRecipesWantedPerPage), HttpStatus.OK);
    }

    @DeleteMapping(value = "/recipe")
    public ResponseEntity deleteRecipeByUuid(@RequestParam UUID externalId) {
        recipeService.deleteRecipeByUuid(externalId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/recipe")
    public ResponseEntity<RecipeEntity> createRecipe(@RequestBody CreateRecipe recipe) {
        return new ResponseEntity(recipeService.createRecipe(recipe), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/recipe")
    public ResponseEntity<RecipeEntity> updateRecipe(@RequestBody CreateRecipe callRecipe,@RequestParam UUID externalId) {
        return new ResponseEntity(recipeService.updateRecipe(externalId, callRecipe),HttpStatus.ACCEPTED);
    }
}
