package com.springboot.mundotaci.service.impl;

import com.springboot.mundotaci.dto.LojaDTO;
import com.springboot.mundotaci.entity.Loja;
import com.springboot.mundotaci.entity.Lojista;
import com.springboot.mundotaci.exception.ResourceNotFoundException;
import com.springboot.mundotaci.repository.LojaRepository;
import com.springboot.mundotaci.repository.LojistaRepository;
import com.springboot.mundotaci.service.LojaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LojaServiceImpl implements LojaService {

    private LojaRepository lojaRepository;
    private LojistaRepository lojistaRepository;
    private ModelMapper mapper;

    @Autowired
    public LojaServiceImpl(LojaRepository lojaRepository, LojistaRepository lojistaRepository, ModelMapper mapper){
        this.lojaRepository = lojaRepository;
        this.lojistaRepository = lojistaRepository;
        this.mapper = mapper;
    }

    @Override
    public LojaDTO AddLoja(long lojistaId, LojaDTO lojaDTO) {

        Loja loja = mapToEntity(lojaDTO);

        Lojista lojista = lojistaRepository.findById(lojistaId).orElseThrow(() -> new ResourceNotFoundException("Lojista", "id", lojistaId));

        loja.setLojista(lojista);

        Loja novaLoja  = lojaRepository.save(loja);

        LojaDTO retorno = mapToDTO(novaLoja);

        return retorno;
    }


    private LojaDTO mapToDTO(Loja entity){
        return mapper.map(entity, LojaDTO.class);
    }

    private Loja mapToEntity(LojaDTO dto){
        return mapper.map(dto, Loja.class);
    }
}
