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
@Table(name = "transfer")
public class Transfer {

    @Id
    @Column(name = "id" , length = 20 )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "sender_acc" , length = 20 )
    private  String sender_acc;//forgienKey

    @Column(name = "target_acc" , length = 20 )
    private  String target_acc;

    @Column(name = "amount" , length = 20 )
    private  Integer amount;

    @Column(name = "time")
    private LocalDateTime time;


    public Transfer(String sender_acc, String target_acc, Integer amount) {
        this.sender_acc = sender_acc;
        this.target_acc = target_acc;
        this.amount = amount;
    }
}


