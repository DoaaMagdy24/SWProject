package com.example.demo.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserDto {

    Long id;

    @NotNull
    private  String Name;

    @NotNull
    @Email
    private  String Email;

    @NotNull
    @Size(min = 8 , max = 20)
    private  String Password;

    @NotNull
    @Size(min = 10 , max = 10)
    private  String AccountNumber;

    @NotNull
    @Size(min = 14 , max = 14)
    private  String NationalId;


    public UserDto(String name, String email, String password, String accountNumber , String nationalId) {
        super();
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.AccountNumber = accountNumber;
        this.NationalId = nationalId;
    }
}