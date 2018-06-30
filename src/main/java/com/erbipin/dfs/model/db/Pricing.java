package com.erbipin.dfs.model.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private int coinType;       // Ethereum and other tokens

    private double price;       // amount of subscriptionPackage


    @ManyToOne
    @JsonBackReference
    @PrimaryKeyJoinColumn
    Subscription subscriptionPackage;

}
