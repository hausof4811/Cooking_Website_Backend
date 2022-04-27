package com.james.cooking.demo.CookingBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "recipe_table")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @JsonIgnore
    private int id;

    //This creates a unique, non-null tag for JPA for the uuid
    @Column(name = "external_id",unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();

    //This tags the variable as a column name for JPA
    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name = "story")
    private String blog;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "directions")
    private String directions;

    @Column(name = "tips_and_tricks")
    private String tips_and_tricks;
}
