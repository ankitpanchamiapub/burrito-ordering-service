package com.generali.burritoorderingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

@Getter
@Setter
public class VegetableDto {

    @NotBlank(message = "Vegetable cannot be empty.")
    @Pattern(regexp = "cabbage|corn|jalapenos", flags = Flag.CASE_INSENSITIVE, message = "Sorry, this vegetable(s) are not available.")
    private String vegetable;
}
