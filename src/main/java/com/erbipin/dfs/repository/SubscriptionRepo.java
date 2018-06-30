package com.erbipin.dfs.repository;

import com.erbipin.dfs.model.db.File;
import com.erbipin.dfs.model.db.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public interface SubscriptionRepo extends JpaRepository<Subscription,Long> {

    List<Subscription> findByStatus(int active);
}
