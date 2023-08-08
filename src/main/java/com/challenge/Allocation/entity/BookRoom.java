package com.challenge.Allocation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "book_room")
@Getter
@Setter
public class BookRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ROOM_NUMBER", nullable = false)
    private int roomNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_START", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FINISH", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinish;

    @Column(name = "FINAL_VALUE", nullable = false)
    private Float finalValue;
}
