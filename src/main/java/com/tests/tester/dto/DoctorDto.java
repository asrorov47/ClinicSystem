package com.tests.tester.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {

    private Integer id;
    @NotBlank(message = ("Ismda Hatolik!"))
    private String name;
    @NotBlank(message = ("Familiyada Hatolik!"))
    private String surname;
    @NotBlank(message = ("Yo`nalishda Hatolik!"))
    private String direction;
    @NotBlank(message = ("To`g`ri Kirit *** "))
    @Size(min = 12,max = 13,message = ("Telefon No`mer Uzunligi 12-13 Oralig`ida Bo`lishi Shart!"))
    private String contact;
    private Integer experience;
    private Boolean status;
    private LocalDateTime createdAt;






















}
