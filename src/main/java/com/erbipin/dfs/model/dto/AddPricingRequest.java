package com.erbipin.dfs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class AddPricingRequest {

    @JsonProperty("coin_type")
    private int coinType;
    @JsonProperty("price")
    private double price;
    @JsonProperty("subscription_id")
    private Long subsId;

}
