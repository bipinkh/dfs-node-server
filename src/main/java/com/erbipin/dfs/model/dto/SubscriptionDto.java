package com.erbipin.dfs.model.dto;

import com.erbipin.dfs.model.db.Pricing;
import com.erbipin.dfs.model.db.Subscription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {

    @JsonProperty("package_name")
    private String packageName;
    @JsonProperty("size_in_mb")
    private double sizeProvided;
    @JsonProperty("coverage_time")
    private int timeSpan;
    @JsonProperty("bandwidth_provided")
    private double bandwidthProvided;
    @JsonProperty("pricings")
    Collection<PricingDto> pricings;

    public static SubscriptionDto fromSubscription(Subscription subs){
        SubscriptionDto subscriptionDto = new SubscriptionDto(
                subs.getPackageName(),
                subs.getSizeProvided(),
                subs.getTimeSpan(),
                subs.getBandwidthProvided(),
                null
        );
        Collection<Pricing> pricings = subs.getPricings();
        for (Pricing price : pricings){
            subscriptionDto.pricings.add( PricingDto.fromPricing(price) );
        }
        return subscriptionDto;
    }

}
