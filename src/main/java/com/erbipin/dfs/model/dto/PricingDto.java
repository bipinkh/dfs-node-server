package com.erbipin.dfs.model.dto;

import com.erbipin.dfs.model.db.Pricing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricingDto {

    private int coinType;

    private double price;

    public static PricingDto fromPricing(Pricing price) {
        PricingDto dto = new PricingDto(
                price.getCoinType(),
                price.getPrice()
        );
        return dto;
    }
}
