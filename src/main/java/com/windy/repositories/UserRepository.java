package com.windy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.windy.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
}
