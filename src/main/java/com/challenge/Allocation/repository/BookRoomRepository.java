package com.challenge.Allocation.repository;

import com.challenge.Allocation.entity.BookRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface BookRoomRepository extends JpaRepository<BookRoom,Long> {


}
