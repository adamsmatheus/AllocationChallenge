package com.challenge.Allocation.service;



import com.challenge.Allocation.dto.Room;
import com.challenge.Allocation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultService {

    private final HotelRepository hotelRepository;

    @Autowired
    public ConsultService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Room> listarProdutos() {
        var response = hotelRepository.findAll();

        return Room.fromEntity(response);
    }

    public void criarProduto(Room room) {

        hotelRepository.save(Room.toEntity(room));
    }

   // public Room buscarProdutoPorId(Long id) {
   //     Optional<Room> produtoOptional = hotelRepository.findById(id);
   //     return produtoOptional.orElse(null);
   // }
//
   // public Room criarProduto(Room room) {
   //     return hotelRepository.save(room);
   // }
//
   // public void deletarProduto(Long id) {
   //     hotelRepository.deleteById(id);
   // }
}
