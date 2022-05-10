package com.generali.burritoorderingservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

@Getter
@Setter
public class ExtraDto {

    @NotBlank(message = "Extra cannot be empty.")
    @Pattern(regexp = "avocado|queso", flags = Flag.CASE_INSENSITIVE, message = "Sorry, this extra(s) are not available.")
    private String extra;
}
