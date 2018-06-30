package com.erbipin.dfs.service;

import com.erbipin.dfs.exception.ResourceNotFoundException;
import com.erbipin.dfs.model.db.Pricing;
import com.erbipin.dfs.model.db.Subscription;
import com.erbipin.dfs.model.dto.PricingDto;
import com.erbipin.dfs.model.dto.SubscriptionDto;
import com.erbipin.dfs.repository.PricingRepo;
import com.erbipin.dfs.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepo subscriptionRepo;
    @Autowired
    PricingRepo pricingRepo;

    public SubscriptionDto addPackage(SubscriptionDto subsRequest) {

        Subscription subs = subscriptionRepo.save( Subscription.fromSubscriptionDto(subsRequest) );

        List<PricingDto> pricingDtos = subsRequest.getPricings();
        for (PricingDto pricingDto : pricingDtos){
            Pricing pricing = Pricing.fromPricingDto(pricingDto);
            pricing = pricingRepo.save( pricing );
            subs.addPricing( pricing );
        }
        return SubscriptionDto.fromSubscription( subscriptionRepo.saveAndFlush( subs ) );
    }



    public SubscriptionDto getPackage(Long id) {
        Optional<Subscription> subs = subscriptionRepo.findById(id);
        if (! subs.isPresent())
            throw new ResourceNotFoundException("cannot get the subscription package for given id");
        return SubscriptionDto.fromSubscription( subs.get() );
    }
}
