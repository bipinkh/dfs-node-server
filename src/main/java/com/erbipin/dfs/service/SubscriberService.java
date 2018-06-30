package com.erbipin.dfs.service;

import com.erbipin.dfs.exception.ResourceNotFoundException;
import com.erbipin.dfs.model.db.Subscription;
import com.erbipin.dfs.model.db.User;
import com.erbipin.dfs.model.db.UserSubscription;
import com.erbipin.dfs.model.dto.SubscribeRequest;
import com.erbipin.dfs.model.dto.UserSubscriptionDto;
import com.erbipin.dfs.repository.SubscriptionRepo;
import com.erbipin.dfs.repository.UserRepo;
import com.erbipin.dfs.repository.UserSubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.erbipin.dfs.service.SubscriptionService.ACTIVE_SUBSCRIPTION_PACKAGE;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@Service
public class SubscriberService {

    private static final int DEFAULT_USER_STATUS = 1;

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserSubscriptionRepo userSubscriptionRepo;
    @Autowired
    SubscriptionRepo subscriptionRepo;

    public UserSubscriptionDto createSubscription(SubscribeRequest request){

        User user;
        Subscription subscriptionPack;

        Optional<Subscription> subs =  subscriptionRepo.findById( Long.valueOf( request.getSubscriptionPackId() ) );
        if ( ! subs.isPresent() )
            throw new ResourceNotFoundException(" Subscription pack with given id doesn't exist.");
        else if ( subs.get().getStatus() != ACTIVE_SUBSCRIPTION_PACKAGE)
            throw new ResourceNotFoundException(" Subscription pack with given id doesn't exist or isn't available.");
        else
            subscriptionPack = subs.get();

        // get user
        // or, register user if they are not already registered
        Optional<User> u = userRepo.findByUserKey(request.getUserKey());
        if ( ! u.isPresent()){
            user = new User(null, request.getUserKey(), DEFAULT_USER_STATUS, null, null);
            user = userRepo.save(user);
        } else
            user = u.get();

        // create subscription and save it
        UserSubscription subscription = UserSubscription.fromSubscribeRequest(request);
        subscription = userSubscriptionRepo.save(subscription);

        // add bidirectional mapping
        user.addUserSubscription(subscription);
        subscriptionPack.addSubscriber(subscription);

        return UserSubscriptionDto.fromUserSubscription( userSubscriptionRepo.saveAndFlush(subscription) );

    }

}
