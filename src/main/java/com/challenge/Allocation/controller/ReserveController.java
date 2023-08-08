package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.service.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
@AllArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;

    @PostMapping
    public ResponseEntity makeReserve(@RequestBody BookRoomDto bookRoomDto) {
        reserveService.makeReserve(bookRoomDto);
        return ResponseEntity.status(201).build();
    }
}
