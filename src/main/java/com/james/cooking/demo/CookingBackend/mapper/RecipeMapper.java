package com.james.cooking.demo.CookingBackend.mapper;

import com.james.cooking.demo.CookingBackend.domain.request.CreateRecipe;
import com.james.cooking.demo.CookingBackend.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "Spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RecipeMapper {

    RecipeEntity createRecipeToRecipeEntity(CreateRecipe recipe);
    CreateRecipe recipeEntityToCreateRecipe(RecipeEntity recipe);

    RecipeEntity updateRecipeEntityFromCall(CreateRecipe callRecipe, @MappingTarget RecipeEntity recipe);

}
