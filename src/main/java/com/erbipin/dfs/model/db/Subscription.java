package com.erbipin.dfs.model.db;

import com.erbipin.dfs.model.dto.SubscriptionDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "subscriptionPackage", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Pricing> pricings;

    @OneToMany(mappedBy = "subscriptionPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    List<UserSubscription> subscribers;


    public void addPricing(Pricing pricing){
        this.pricings.add(pricing);
        pricing.setSubscriptionPackage(this);
    }

    public void addSubscriber(UserSubscription subscriber){
        this.subscribers.add(subscriber);
        subscriber.setSubscriptionPackage(this);
    }


    public static Subscription fromSubscriptionDto(SubscriptionDto dto){
        return new Subscription(
                null,
                dto.getPackageName(),
                dto.getStatus(),
                dto.getSizeProvided(),
                dto.getTimeSpan(),
                dto.getBandwidthProvided(),
                new ArrayList<Pricing>(),
                new ArrayList<UserSubscription>()
        );
    }

}
