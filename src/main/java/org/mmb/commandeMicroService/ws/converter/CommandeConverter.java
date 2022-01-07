package org.mmb.commandeMicroService.ws.converter;

import org.mmb.commandeMicroService.entities.Commande;
import org.mmb.commandeMicroService.ws.vo.CommandeVo;

public class CommandeConverter implements Converter<CommandeVo, Commande>{

    @Override
    public Commande fromVoToEn(CommandeVo commandeVo) {
        if (commandeVo == null || commandeVo.getId() == null) return null;
        Commande commande = new Commande();
        commande.setId(commandeVo.getId());
        commande.setReference(commandeVo.getReference()==null?null:commandeVo.getReference());
        commande.setTotalPrice(commandeVo.getTotalPrice()==null?null:Double.parseDouble(commandeVo.getTotalPrice()));
        commande.setDate(commandeVo.getDate()==null?null:commandeVo.getDate());
        return commande;
    }

    @Override
    public CommandeVo fromEnToVo(Commande commande) {
        if (commande == null || commande.getId() == null) return null;
        CommandeVo commandeVo = new CommandeVo();
        commandeVo.setId(commande.getId());
        commandeVo.setReference(commande.getReference()==null?null:commande.getReference());
        commandeVo.setTotalPrice(commande.getTotalPrice()==null?null:commande.getTotalPrice().toString());
        commandeVo.setDate(commande.getDate()==null?null:commande.getDate());
        return commandeVo;
    }
}
