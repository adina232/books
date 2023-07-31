package com.example2.demo.cumparaturi.service;

import com.example2.demo.cumparaturi.repository.ProdusEntity;
import com.example2.demo.cumparaturi.repository.ProdusRepository;
import com.example2.demo.cumparaturi.rest.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;

//    List<Produs> cumparaturi = new ArrayList<>();

    public void addProdus(Produs produs) {
        ProdusEntity produsEntity = new ProdusEntity();
        produsEntity.setName(produs.getNumeProdus());
        produsEntity.setType(produs.getTipCantitate());
        produsEntity.setQuantity(produs.getCantitate());

        produsRepository.save(produsEntity);
    }

    public List<Produs> getCumparaturi() {
        List<ProdusEntity> all = (List<ProdusEntity>) produsRepository.findAll();
        List<Produs> response = new ArrayList<>();

        for (ProdusEntity produsEntity : all) {
            Produs produs = new Produs();
            produs.setNumeProdus(produsEntity.getName());
            produs.setTipCantitate(produsEntity.getType());
            produs.setCantitate(produsEntity.getQuantity());
            response.add(produs);
        }
        return response;
    }

    public Produs getProdus(String numeProdus) {
        ProdusEntity produsEntity = produsRepository.findByName(numeProdus);
        Produs produs = new Produs();
        produs.setNumeProdus(produsEntity.getName());
        produs.setTipCantitate(produsEntity.getType());
        produs.setCantitate(produsEntity.getQuantity());

        return produs;
    }

    public void modifyProdus(String numeProdus, Produs produsNou) {
        ProdusEntity produsEntity = produsRepository.findByName(numeProdus);
        produsEntity.setName(produsNou.getNumeProdus());
        produsEntity.setType(produsNou.getTipCantitate());
        produsEntity.setQuantity(produsNou.getCantitate());

        produsRepository.save(produsEntity);
    }

    public void deleteProdus(String numeProdus) {
        ProdusEntity produsEntity = produsRepository.findByName(numeProdus);
        produsRepository.delete(produsEntity);
    }
}
