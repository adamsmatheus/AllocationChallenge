package com.challenge.Allocation.repository;

import com.challenge.Allocation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByNumber(Long numero);

}
