package com.erbipin.dfs.model.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String packageName;

    private int status;             // active, deactive or deleted

    private double sizeProvided;    // volume provided

    private int timeSpan;           // time of subscriptionPackage in days

    private double bandwidthProvided;  // bandwidth for given time in GB

    @OneToMany
    @JsonManagedReference
    Collection<Pricing> pricings;

    public void addPricing(Pricing pricing){
        this.pricings.add(pricing);
        pricing.setSubscriptionPackage(this);
    }



}
