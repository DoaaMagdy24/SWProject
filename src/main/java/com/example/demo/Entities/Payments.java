package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payments {

    @Id
    @Column(name = "id" , length = 20 )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "sender_acc" , length = 20 )
    private  String sender_acc;//forgienKey

    @Column(name = "code" , length = 20 )
    private  String code;

    @Column(name = "amount" , length = 20 )
    private  Integer amount;

    @Column(name = "time")
    private LocalDateTime time;


    public Payments(String sender_acc, String code, Integer amount) {
        this.sender_acc = sender_acc;
        this.code = code;
        this.amount = amount;
    }
}

