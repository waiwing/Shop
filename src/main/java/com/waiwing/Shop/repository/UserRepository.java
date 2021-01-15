package com.waiwing.Shop.repository;

import com.waiwing.Shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    User findUserByEmail(String email);

    Optional<User> findUserByOpenid(String openId);

    User findUserByUnifyUid(Long uuid);
}
