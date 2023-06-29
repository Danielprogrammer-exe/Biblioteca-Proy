package com.biblioteca.repository;
import java.util.Optional;

import com.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findOneByEmail(String email);

}
