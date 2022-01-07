package org.mmb.commandeMicroService.ws.provided;

import org.mmb.commandeMicroService.entities.Commande;
import org.mmb.commandeMicroService.service.CommandeService;
import org.mmb.commandeMicroService.service.ProduitService;
import org.mmb.commandeMicroService.ws.converter.CommandeConverter;
import org.mmb.commandeMicroService.ws.vo.CommandeVo;
import org.mmb.commandeMicroService.ws.vo.ProduitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommandeWs {

    private CommandeService commandeService;
    private CommandeConverter commandeConverter;
    private ProduitService produitService;

    @Autowired
    public CommandeWs(CommandeService commandeService,ProduitService produitService) {
        this.commandeService = commandeService;
        this.produitService = produitService;
        this.commandeConverter = new CommandeConverter();
    }

    @GetMapping("/commandewithproducts/ref/{ref}")
    public CommandeVo findCommandeWithProducts(@PathVariable("ref") String ref) {
        CommandeVo commandeVo = commandeConverter.fromEnToVo(commandeService.findByReference(ref));
        if (commandeVo == null) return null;
        List<ProduitVo> produitVos = produitService.findProductsByCommandeRef(ref);
        if (produitVos != null && produitVos.size() != 0) commandeVo.setProduitVos(produitVos);
        return commandeVo;
    }

    @GetMapping("/")
    public List<CommandeVo> findAll() {
        List<CommandeVo> result = new ArrayList<CommandeVo>();
        for (Commande c : commandeService.findAll()) {
            result.add(commandeConverter.fromEnToVo(c));
        }
        return result;
    }
    @PostMapping("/")
    public CommandeVo save(@RequestBody Commande entity) {
        Commande c = commandeService.save(entity);
        if (c == null) return null;
        CommandeVo result = commandeConverter.fromEnToVo(c);
        return result;
    }
    @GetMapping("/{aLong}")
    public CommandeVo findById(@PathVariable("aLong") Long aLong) {
        Commande c = commandeService.findById(aLong);
        if (c == null) return null;
        CommandeVo result = commandeConverter.fromEnToVo(c);
        return result;
    }
    @DeleteMapping("/{aLong}")
    public void deleteById(@PathVariable("aLong") Long aLong) {
        commandeService.deleteById(aLong);
    }

    @GetMapping("/ref/{ref}")
    public Commande findByReference(@PathVariable("ref") String ref) {
        return commandeService.findByReference(ref);
    }
}
