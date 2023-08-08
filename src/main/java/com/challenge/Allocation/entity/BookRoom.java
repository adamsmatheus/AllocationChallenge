package com.challenge.Allocation.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book_room")
public class BookRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room roomId;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_START", nullable = false)
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FINISH", nullable = false)
    private Date dateFinish;

    @Column(name = "FINAL_VALUE", nullable = false)
    private Float finalValue;
}
