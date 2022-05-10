package com.generali.burritoorderingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long id;

    @NotBlank(message = "Tortilla cannot be null, you need a base to add the ingredients.")
    @Pattern(regexp = "corn|flour", flags = Flag.CASE_INSENSITIVE, message = "Sorry, we do not carry this tortilla.")
    private String tortilla;

    @NotBlank(message = "Protein cannot be null, you need it to stay healthy!")
    @Pattern(regexp = "bean|beef|chicken|pork|shrimp|steak", flags = Flag.CASE_INSENSITIVE, message = "Sorry, we do not carry this protein.")
    private String protein;

    @NotBlank(message = "Salsa cannot be null, add some to make it tasty!")
    @Pattern(regexp = "mild|medium|hot", flags = Flag.CASE_INSENSITIVE, message = "Sorry, we do not carry this salsa.")
    private String salsa;

    private List<@Valid VegetableDto> vegetables;

    private List<@Valid ExtraDto> extras;
}
