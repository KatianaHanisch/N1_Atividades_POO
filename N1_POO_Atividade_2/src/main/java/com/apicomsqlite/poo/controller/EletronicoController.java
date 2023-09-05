package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Eletronico;
import com.apicomsqlite.poo.service.EletronicoService;

@RestController
public class EletronicoController {

    @Autowired
    private EletronicoService eletronicoService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createeletronico", method = RequestMethod.POST)
    public String createeletronico(@RequestBody Eletronico eletronico) {
        return eletronicoService.createeletronico(eletronico);
    }

    @RequestMapping(value = "readeletronicos", method = RequestMethod.GET)
    public List<Eletronico> readeletronicos() {
        return eletronicoService.readeletronicos();
    }

    @RequestMapping(value = "updateeletronico", method = RequestMethod.PUT)
    public String updateeletronico(@RequestBody Eletronico eletronico) {
        return eletronicoService.updateeletronico(eletronico);
    }

    @RequestMapping(value = "deleteeletronico", method = RequestMethod.DELETE)
    public String deleteeletronico(@RequestBody Eletronico eletronico) {
        return eletronicoService.deleteeletronico(eletronico);
    }
}
