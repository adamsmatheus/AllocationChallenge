package com.challenge.Allocation.repository;


import com.challenge.Allocation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByNumber(int numero);

   Room findRoomById(Long id);
}
