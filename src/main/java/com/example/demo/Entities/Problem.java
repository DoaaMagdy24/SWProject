package com.example.demo.Entities;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Builder
    @Entity
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "problems")
    public class Problem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name" , length = 50)
        private String fullName;

        @Column(name = "email" , length = 100)
        private String email;

        @Column(name = "message" , length = 500)
        private String message;

        @Column(name = "status" , length = 20)
        private String status;

        @Column(name = "time")
        private LocalDateTime time;

        public Problem(String fullName, String email, String message) {
            this.fullName = fullName;
            this.email = email;
            this.message = message;
        }
    }


