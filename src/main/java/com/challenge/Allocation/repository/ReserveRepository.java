package com.challenge.Allocation.repository;

import com.challenge.Allocation.entity.BookRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserveRepository extends JpaRepository<BookRoom, Long> {

    List<BookRoom> findAllByroomNumber(int roomNumber);
}
