package com.springboot.mundotaci.service.impl;

import com.springboot.mundotaci.dto.LojistaDTO;
import com.springboot.mundotaci.entity.Lojista;
import com.springboot.mundotaci.exception.ResourceNotFoundException;
import com.springboot.mundotaci.repository.LojistaRepository;
import com.springboot.mundotaci.service.LojistaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LojistaServiceImpl  implements LojistaService {

    private LojistaRepository repository;

    private ModelMapper mapper;

    @Autowired
    public LojistaServiceImpl(LojistaRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LojistaDTO AddLojista(LojistaDTO dto) {
        //convert DTO to entity
        Lojista lojista = mapToEntity(dto);
        //save entity
        Lojista novoLojista = repository.save(lojista);
        //convert entity to DTO
        LojistaDTO logistaResponse = mapToDTO(lojista);
        return logistaResponse;
    }

    @Override
    public List<LojistaDTO> getAllLojistas() {
        List<Lojista> lojistas = repository.findAll();
        return lojistas.stream().map(x -> mapToDTO(x)).collect(Collectors.toList());
    }

    @Override
    public LojistaDTO getLojistaById(long id) {
        Lojista lojista = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lojista", "id", id));
        return mapToDTO(lojista);
    }

    @Override
    public LojistaDTO updateLojista(LojistaDTO dto, long id) {
        Lojista lojista = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lojista", "id", id));

        lojista.setCnpj(dto.getCnpj());
        lojista.setNome(dto.getNome());

        Lojista updatedEntity = repository.save(lojista);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void deletePostById(long id) {
        Lojista lojista = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lojista", "id", id));
        repository.delete(lojista);
    }

    private LojistaDTO mapToDTO(Lojista entity){
        return mapper.map(entity, LojistaDTO.class);
    }

    private Lojista mapToEntity(LojistaDTO dto){
        return mapper.map(dto, Lojista.class);
    }

}
