package org.mmb.commandeMicroService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private Double totalPrice;
    private String date;
}
