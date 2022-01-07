package org.mmb.commandeMicroService.service;

import org.mmb.commandeMicroService.dao.CommandeDao;
import org.mmb.commandeMicroService.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private CommandeDao commandeDao;

    @Autowired
    public CommandeService(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    public Commande save(Commande entity) {
        return commandeDao.save(entity);
    }

    public Commande findById(Long aLong) {
        return commandeDao.findById(aLong).get();
    }

    public void deleteById(Long aLong) {
        commandeDao.deleteById(aLong);
    }

    public Commande findByReference(String ref) {
        return commandeDao.findByReference(ref);
    }
}
