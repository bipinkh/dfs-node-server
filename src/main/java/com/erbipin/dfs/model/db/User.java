package com.erbipin.dfs.model.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String userKey;

    private int userStatus;     //active, deactive, blocked

    @OneToOne
    @JsonManagedReference
    @PrimaryKeyJoinColumn
    UserSubscription userSubscription;

    @OneToMany
    @JsonManagedReference
    Collection<File> file;

    public void addUserSubscription(UserSubscription subscription){
        this.setUserSubscription(subscription);
        subscription.setUser(this);
    }

    public void addFile(File file){
        this.file.add(file);
        file.setUser(this);
    }


}
