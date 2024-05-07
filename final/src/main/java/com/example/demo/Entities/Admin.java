package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "id" , length = 20 )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name" , length = 100 )
    private  String name;

    @Column(name = "email" , length = 100 , unique = true)
    private  String email;

    @Column(name = "password" , length = 80 )
    private  String password;

    @Column(name = "role" , length = 10)
    private String Role;


}
