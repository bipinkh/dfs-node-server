package com.erbipin.dfs.model.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JsonBackReference
    User user;

    @ManyToOne
    @JsonManagedReference
    Subscription subscriptionPackage;

    private Timestamp startedDate;

    private Timestamp endingDate;

    private Timestamp lastRenewedDate;

    private double sizeConsumed;

    private double bandwidthConsumed;

}
