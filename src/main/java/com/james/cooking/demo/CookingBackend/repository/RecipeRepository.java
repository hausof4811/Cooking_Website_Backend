package com.james.cooking.demo.CookingBackend.repository;

import com.james.cooking.demo.CookingBackend.entity.RecipeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    RecipeEntity findByUuid(UUID externalId);

    void deleteByUuid(UUID externalId);

    //get all Recipes
    //get Recipe by ID/UUID
    //get Recipe by name
    //Create new Recipe
    //Delete Recipe
    //Update Recipe name
    //Update Recipe ingredients
    //Update Recipe instructions
    //Update Recipe tipsAndTricks
    //Update Recipe blog

}
