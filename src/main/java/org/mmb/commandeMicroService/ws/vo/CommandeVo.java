package org.mmb.commandeMicroService.ws.vo;

import lombok.Data;

import java.util.List;

@Data
public class CommandeVo {
    private String id;
    private String reference;
    private String TotalPrice;
    private String date;
    private List<ProduitVo> produitVos;
}
