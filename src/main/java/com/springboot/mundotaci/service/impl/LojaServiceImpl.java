package com.springboot.mundotaci.service.impl;

import com.springboot.mundotaci.dto.LojaDTO;
import com.springboot.mundotaci.entity.Loja;
import com.springboot.mundotaci.exception.ResourceNotFoundException;
import com.springboot.mundotaci.repository.LojaRepository;
import com.springboot.mundotaci.service.LojaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LojaServiceImpl implements LojaService {

    private LojaRepository lojaRepository;

    private ModelMapper mapper;

    @Autowired
    public LojaServiceImpl(LojaRepository lojaRepository, ModelMapper mapper){
        this.lojaRepository = lojaRepository;
        this.mapper = mapper;
    }

    @Override
    public LojaDTO AddLoja(LojaDTO lojaDTO) {

        Loja loja = mapToEntity(lojaDTO);

        Loja novaLoja  = lojaRepository.save(loja);

        LojaDTO retorno = mapToDTO(novaLoja);

        return retorno;
    }

    @Override
    public List<LojaDTO> GetLojas(){
        List<Loja> lojaList = lojaRepository.findAll();
        return mapToListDTO(lojaList);
    }


    private LojaDTO mapToDTO(Loja entity){
        return mapper.map(entity, LojaDTO.class);
    }

    private List<LojaDTO> mapToListDTO(List<Loja> lojaList) {
        List<LojaDTO> listaLojasDTO= new ArrayList<>();

        for (Loja loja : lojaList
             ) {
            listaLojasDTO.add(mapper.map(loja, LojaDTO.class));
        }

        return listaLojasDTO;
    }

    private Loja mapToEntity(LojaDTO dto){
        return mapper.map(dto, Loja.class);
    }
}
