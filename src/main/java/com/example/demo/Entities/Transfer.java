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
    private  Long sender_acc_id;//forgienKey

    @Column(name = "target_acc" , length = 20 )
    private  Long target_acc_id;

    @Column(name = "amount" , length = 20 )
    private  double amount;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "userId")
    private Integer userId;


    public Transfer(Long sender_acc, Long target_acc, double amount) {
        this.sender_acc_id = sender_acc;
        this.target_acc_id = target_acc;
        this.amount = amount;
    }
}


