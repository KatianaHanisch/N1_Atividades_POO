package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.poo.enity.Eletronico;
import com.apicomsqlite.poo.repository.EletronicoRepository;
import jakarta.transaction.Transactional;

@Service
public class EletronicoService {

    @Autowired(required = false)
    private EletronicoRepository eletronicoRespository;

    @Transactional
    public String createeletronico(Eletronico eletronico) {
        try {
            if (!eletronicoRespository.existsByNomeModelo(eletronico.getNomeModelo())) {
                eletronico.setId(null == eletronicoRespository.findMaxId() ? 1 : eletronicoRespository.findMaxId() + 1);
                eletronicoRespository.save(eletronico);
                return "eletronico cadastrado com sucesso.";
            } else {
                return "eletronico já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Eletronico> readeletronicos() {
        return eletronicoRespository.findAll();
    }

    @Transactional
    public String updateeletronico(Eletronico eletronico) {
        if (eletronicoRespository.existsByNomeModelo(eletronico.getNomeModelo())) {
            try {
                List<Eletronico> eletronicos = eletronicoRespository.findByNomeModelo(eletronico.getNomeModelo());
                eletronicos.stream().forEach(s -> {
                    Eletronico eletronicoToBeUpdate = eletronicoRespository.findById(s.getId()).get();
                    eletronicoToBeUpdate.setNomeModelo(eletronico.getNomeModelo());
                    eletronicoToBeUpdate.setFabricante(eletronico.getFabricate());
                    eletronicoToBeUpdate.setTipo(eletronico.getTipo());
                    eletronicoToBeUpdate.setEspecificacoes(eletronico.getEspecificacoes());
                    eletronicoToBeUpdate.setPreco(eletronico.getPreco());
                    eletronicoRespository.save(eletronicoToBeUpdate);
                });
                return "eletronico atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "eletronico não existe no banco.";
        }
    }

    @Transactional
    public String deleteeletronico(Eletronico eletronico) {
        if (eletronicoRespository.existsByNomeModelo(eletronico.getNomeModelo())) {
            try {
                List<Eletronico> eletronicos = eletronicoRespository.findByNomeModelo(eletronico.getNomeModelo());
                eletronicos.stream().forEach(s -> {
                    eletronicoRespository.delete(s);
                });
                return "eletronico deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "eletronico n\u00E3o existe no banco.";
        }
    }
}