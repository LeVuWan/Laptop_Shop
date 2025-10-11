package com.windy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.windy.domains.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
