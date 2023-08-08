package com.challenge.Allocation.service;

import com.challenge.Allocation.repository.BookRoomRepository;
import com.challenge.Allocation.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ConsultService {
    private final BookRoomRepository bookRoomRepository;


    public boolean findConsult(Long id, Date date) {
        //bookRoomRepository.fin()
        return  true;
    }
}
