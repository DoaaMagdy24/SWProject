package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class user {

        @Id
        @Column(name = "id" , length = 50 )
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @Column(name = "name" , length = 100 )
        private  String name;

        @Column(name = "email" , length = 100 ,unique = true )
        private  String email;

        @Column(name = "password" , length = 80 )
        private  String password;

        @Column(name = "monthly_income")
        private BigDecimal monthlyIncome;

        @Column(name = "AccountNumber" , length = 20 , unique = true)
        private String AccountNumber;

        @Column(name = "NationalId" , length = 20 , unique = true)
        private String NationalId;

        @Column(name = "role" , length = 10)
        private String Role;

        public user(String name, String email, String password, String accountNumber, String nationalId, String role) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.AccountNumber = accountNumber;
            this.NationalId = nationalId;
            this.Role = role;
        }
}
