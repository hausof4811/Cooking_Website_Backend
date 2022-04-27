package com.james.cooking.demo.CookingBackend.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateRecipe {

    //these are the key pieces of info being received from the API
    @NotBlank(message = "Name can not be null")
    private String recipeName;

    @Size(max = 65535, message = "Must be between 0 and 65535 characters long.")
    private String blog;

    @Size(max = 65535, message = "Must be between 0 and 65535 characters long.")
    private String ingredients;

    @Size(max = 65535, message = "Must be between 0 and 65535 characters long.")
    private String directions;

    @Size(max = 5000, message = "Must be between 0 and 5000 characters long.")
    private String tips_and_tricks;

}
