package com.erbipin.dfs.repository;

import com.erbipin.dfs.model.db.File;
import com.erbipin.dfs.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserKey(String key);
}
