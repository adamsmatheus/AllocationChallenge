package com.challenge.Allocation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(name = "NUMERO", unique = true, nullable = false)
    private int numero;

    @Column(name = "VALUE_DAY", nullable = false)
    private float valueDay;
}
