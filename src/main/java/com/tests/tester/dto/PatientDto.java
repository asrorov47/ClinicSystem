package com.tests.tester.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto {
    

    private Integer id;
    @NotBlank(message = ("Ismda xatolik mavjud!"))
    private String name;
    @NotNull(message = ("Ismi mavjud bo`lishi kerak!"))
    @NotEmpty(message = ("Familiyasi bo`lishi shart!"))
    @Size(min = 8,max =255)
    private String surname;
    @NotBlank(message = ("Invalid birthday!"))
    private LocalDateTime birthday;
    @NotBlank(message = ("Invalid contact!"))
    @Size(min = 12,max = 13,message = ("Kontakni to`g`ri kirit(ing) *** 12-13 oralig`ida!"))
    private String contact;
    private Integer age;
    private Boolean status;
    private LocalDateTime createdAt;

















}
