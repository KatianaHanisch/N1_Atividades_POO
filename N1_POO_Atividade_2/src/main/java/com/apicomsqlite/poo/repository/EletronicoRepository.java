package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Eletronico;

@Repository
public interface EletronicoRepository extends JpaRepository<Eletronico, Integer> {

    public boolean existsByNomeModelo(String nomeModelo);

    public List<Eletronico> findByNomeModelo(String nomeModelo);

    @Query("select max(s.id) from Eletronico s")
    public Integer findMaxId();
}