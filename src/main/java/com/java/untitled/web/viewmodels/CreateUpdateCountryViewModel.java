package com.java.untitled.web.viewmodels;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUpdateCountryViewModel {
    @NotBlank
    @Size(min = 5, max = 25, message = "Name must be between 5 and 25 characters long!")
    private String name;
}
