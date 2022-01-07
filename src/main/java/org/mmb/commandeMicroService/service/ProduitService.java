package org.mmb.commandeMicroService.service;

import org.mmb.commandeMicroService.ws.vo.ProduitVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "produitMicroService", url = "http://localhost:8050/api")
public interface ProduitService {
    @GetMapping("/products/commandeRef/{ref}")
    public List<ProduitVo> findProductsByCommandeRef(@PathVariable("ref") String ref);
}
