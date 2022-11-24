package com.springboot.mundotaci.controller;

import com.springboot.mundotaci.dto.LojaDTO;
import com.springboot.mundotaci.service.LojaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LojaController {

    private LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping("/lojas")
    public ResponseEntity<List<LojaDTO>> GetLojas(){
        return new ResponseEntity<>(lojaService.GetLojas(), HttpStatus.OK);
    }
    @PostMapping("/lojas")
    public ResponseEntity<LojaDTO> AddLoja(@RequestBody LojaDTO lojaDto){
        return new ResponseEntity<>(lojaService.AddLoja(lojaDto), HttpStatus.CREATED);
    }

}
