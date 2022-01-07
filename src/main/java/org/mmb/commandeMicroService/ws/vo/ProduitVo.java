package org.mmb.commandeMicroService.ws.vo;


import lombok.Data;

@Data
public class ProduitVo {
    private Long id;
    private String reference;
    private String qte;
    private String prixUnitaire;
    private String commandeVoRef;
}
