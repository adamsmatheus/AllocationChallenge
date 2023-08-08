package com.challenge.Allocation.repository;

import com.challenge.Allocation.entity.BookRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveRepository extends JpaRepository<BookRoom, Long> {

    List<BookRoom> findAllByroomNumber(int roomNumber);

    @Query(value = """
            SELECT * FROM BOOK_ROOM BK
            WHERE BK.ID = :id
            """, nativeQuery = true)
    BookRoom findByCodeReserve(@Param("id") Long id);

}
