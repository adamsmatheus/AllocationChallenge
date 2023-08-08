package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.service.ConsultService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/consult")
@AllArgsConstructor
public class ConsultController {

    private final ConsultService consultService;

    @PostMapping("/{id}")
    public ResponseEntity<List<RoomDto>> findReserve(@PathVariable Long id, @RequestBody Date date) {
        var response = consultService.findConsult(id,date);
        return ResponseEntity.ok().build();
    }
}
