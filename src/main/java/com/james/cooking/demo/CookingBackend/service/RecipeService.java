package com.james.cooking.demo.CookingBackend.service;

import com.james.cooking.demo.CookingBackend.domain.request.CreateRecipe;
import com.james.cooking.demo.CookingBackend.entity.RecipeEntity;
import com.james.cooking.demo.CookingBackend.exceptions.NotFoundException;
import com.james.cooking.demo.CookingBackend.mapper.RecipeMapper;
import com.james.cooking.demo.CookingBackend.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository; //this creates an instance of the repository class for operations
    private final RecipeMapper recipeMapper;

    //get recipe by UUID
    public RecipeEntity getRecipeByUuid(UUID externalId) {
        RecipeEntity recipe = recipeRepository.findByUuid(externalId);
        if(recipe == null) {
            throw new NotFoundException(1,"recipe not found");
        }
        return recipe;
    }

    //get recipe entities, Max for use on web display
    public Page<RecipeEntity> getRecipes(int PageWanted, int numRecipesWanted) {
        Pageable recipesByName = PageRequest.of(PageWanted, numRecipesWanted, Sort.by("recipeName").descending());
        return recipeRepository.findAll(recipesByName);
    }

    public void deleteRecipeByUuid(UUID externalId) {
        recipeRepository.deleteByUuid(externalId);
    }

    public RecipeEntity createRecipe(CreateRecipe recipe) {
        if(recipe == null) {
            throw new NotFoundException(2,"failure to create new recipe");
        }
        return recipeRepository.save(recipeMapper.createRecipeToRecipeEntity(recipe));
    }

    public RecipeEntity updateRecipe(UUID externalId,CreateRecipe callRecipe) {
        RecipeEntity original = recipeRepository.findByUuid(externalId);
        recipeMapper.updateRecipeEntityFromCall(callRecipe, original);

        if(original == null || callRecipe == null) {
            throw new NotFoundException(3,"failure to update recipe with new data");
        }
        return recipeRepository.save(original);
    }
}
