package com.eindopdracht.BE.ReneWeerts.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


import java.time.LocalDate;


public class PersonDto {
    public Long id;
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    @NotBlank
    public String email;
    @NotNull
    public int phoneNumber;
    @Past // datum moet in verleden zijn
    public static LocalDate dob;


    // input en output dto (data van gebruiker of server)


}
