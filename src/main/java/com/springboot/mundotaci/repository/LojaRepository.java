package com.springboot.mundotaci.repository;

import com.springboot.mundotaci.entity.Loja;
import com.springboot.mundotaci.entity.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {

}
