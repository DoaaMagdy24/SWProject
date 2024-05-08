package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")

public class Account {

        @Id
        @Column(name = "id" , length = 20 )
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @Column(name = "number" , length = 20 , unique = true)
        private  String number;

        @Column(name = "balance" , length = 20 )
        private  double balance;

        @Column(name = "customer_id")
        private Long customer_id;

}

