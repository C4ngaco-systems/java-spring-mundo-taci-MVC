package com.springboot.mundotaci.controller;

import com.springboot.mundotaci.dto.LojaDTO;
import com.springboot.mundotaci.service.LojaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class LojaController {

    private LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/lojistas/{lojistaId}/lojas")
    public ResponseEntity<LojaDTO> AddLoja(@PathVariable(value = "lojistaId") long logistaId, @RequestBody LojaDTO lojaDto){
        return new ResponseEntity<>(lojaService.AddLoja(logistaId, lojaDto), HttpStatus.CREATED);
    }

}
