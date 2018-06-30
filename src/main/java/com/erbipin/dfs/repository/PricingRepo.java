package com.erbipin.dfs.repository;

import com.erbipin.dfs.model.db.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public interface PricingRepo extends JpaRepository<Pricing,Long> {
}
