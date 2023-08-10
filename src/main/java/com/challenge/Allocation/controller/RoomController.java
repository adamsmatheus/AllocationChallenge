package com.challenge.Allocation.controller;


import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public String home() {
        roomService.findRooms();
        return "room";
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findRoomByNumber(@PathVariable Long number) {
        RoomDto produto = roomService.findRoomByNumber(number);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public String create(RoomDto roomDto) {
        roomService.createRoom(roomDto);
        return "redirect:/room/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        var room = roomService.findRooms();
        ModelAndView mv = new ModelAndView("room/list");
        mv.addObject("room", room);

        return mv;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        var response = roomService.updateRoom(id, roomDto);
        if (response == true) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
