package com.springboot.mundotaci.controller;

import com.springboot.mundotaci.dto.LojistaDTO;
import com.springboot.mundotaci.service.LojistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lojista")
public class LojistaController {

    private LojistaService lojistaService;

    public LojistaController(LojistaService lojistaService){
        this.lojistaService = lojistaService;
    }

    @PostMapping
    public ResponseEntity<LojistaDTO> addLojista(@RequestBody LojistaDTO dto) {
        return new ResponseEntity<>(lojistaService.AddLojista(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LojistaDTO> getAllLojistas() {
        return lojistaService.getAllLojistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LojistaDTO> getLojistaById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(lojistaService.getLojistaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LojistaDTO> updateLojista(@RequestBody LojistaDTO dto, @PathVariable(name = "id") long id){
        LojistaDTO retorno = lojistaService.updateLojista(dto, id);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLojista(@PathVariable(name = "id") long id){
        lojistaService.deletePostById(id);
        return new ResponseEntity<>("Lojista deleted successfully", HttpStatus.OK);
    }

}
