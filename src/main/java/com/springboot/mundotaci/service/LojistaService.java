package com.springboot.mundotaci.service;

import com.springboot.mundotaci.dto.LojistaDTO;

import java.util.List;

public interface LojistaService {

    LojistaDTO AddLojista(LojistaDTO lojista);

    List<LojistaDTO> getAllLojistas();

    LojistaDTO getLojistaById(long id);

    LojistaDTO updateLojista(LojistaDTO dto, long id);

    void deletePostById(long id);

}
