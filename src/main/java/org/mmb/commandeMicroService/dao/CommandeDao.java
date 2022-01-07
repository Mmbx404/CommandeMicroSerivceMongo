package org.mmb.commandeMicroService.dao;

import org.mmb.commandeMicroService.entities.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommandeDao extends MongoRepository<Commande, Long> {
    public Commande findByReference(String ref);
}
