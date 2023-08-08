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
    public ResponseEntity<List<Room>> listarProdutos() {
        List<Room> produtos = consultService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity createRoom(@RequestBody Room room) {
        consultService.criarProduto(room);
        return ResponseEntity.status(201).build();
    }
}
