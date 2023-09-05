package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    public boolean existsByNome(String nome);

    public List<Animal> findByNome(String nome);

    @Query("select max(s.id) from Animal s")
    public Integer findMaxId();
}