package com.erbipin.dfs.model.db;

import com.erbipin.dfs.model.dto.PricingDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int coinType;       // Ethereum and other tokens

    private double price;       // amount of subscriptionPackage

    @ManyToOne
    @JsonBackReference
    Subscription subscriptionPackage;

    public static Pricing fromPricingDto(PricingDto pricingDto) {
        Pricing pricing = new Pricing();
        pricing.setCoinType(pricingDto.getCoinType());
        pricing.setPrice(pricingDto.getPrice());
        return pricing;
    }
}
