package com.james.cooking.demo.CookingBackend.mapper;

import com.james.cooking.demo.CookingBackend.domain.request.CreateRecipe;
import com.james.cooking.demo.CookingBackend.entity.RecipeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-27T15:48:59-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeEntity createRecipeToRecipeEntity(CreateRecipe recipe) {
        if ( recipe == null ) {
            return null;
        }

        RecipeEntity recipeEntity = new RecipeEntity();

        recipeEntity.setRecipeName( recipe.getRecipeName() );
        recipeEntity.setBlog( recipe.getBlog() );
        recipeEntity.setIngredients( recipe.getIngredients() );
        recipeEntity.setDirections( recipe.getDirections() );
        recipeEntity.setTips_and_tricks( recipe.getTips_and_tricks() );

        return recipeEntity;
    }

    @Override
    public CreateRecipe recipeEntityToCreateRecipe(RecipeEntity recipe) {
        if ( recipe == null ) {
            return null;
        }

        CreateRecipe createRecipe = new CreateRecipe();

        createRecipe.setRecipeName( recipe.getRecipeName() );
        createRecipe.setBlog( recipe.getBlog() );
        createRecipe.setIngredients( recipe.getIngredients() );
        createRecipe.setDirections( recipe.getDirections() );
        createRecipe.setTips_and_tricks( recipe.getTips_and_tricks() );

        return createRecipe;
    }

    @Override
    public RecipeEntity updateRecipeEntityFromCall(CreateRecipe callRecipe, RecipeEntity recipe) {
        if ( callRecipe == null ) {
            return null;
        }

        if ( callRecipe.getRecipeName() != null ) {
            recipe.setRecipeName( callRecipe.getRecipeName() );
        }
        if ( callRecipe.getBlog() != null ) {
            recipe.setBlog( callRecipe.getBlog() );
        }
        if ( callRecipe.getIngredients() != null ) {
            recipe.setIngredients( callRecipe.getIngredients() );
        }
        if ( callRecipe.getDirections() != null ) {
            recipe.setDirections( callRecipe.getDirections() );
        }
        if ( callRecipe.getTips_and_tricks() != null ) {
            recipe.setTips_and_tricks( callRecipe.getTips_and_tricks() );
        }

        return recipe;
    }
}
