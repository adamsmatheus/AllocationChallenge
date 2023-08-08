package com.challenge.Allocation.controller;



import com.challenge.Allocation.dto.Room;
import com.challenge.Allocation.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consult")
public class ConsultController {
    private final ConsultService consultService;

    @Autowired
    public ConsultController(ConsultService consultService) {
        this.consultService = consultService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> findRooms() {
        List<Room> produtos = consultService.findRooms();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findRoomByNumber(@PathVariable int number) {
        Room produto = consultService.findRoomByNumber(number);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createRoom(@RequestBody Room room) {
        consultService.createRoom(room);
        return ResponseEntity.status(201).build();
    }
}
