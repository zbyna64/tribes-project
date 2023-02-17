package com.gfa.springadvanced.repositories;

import com.gfa.springadvanced.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
