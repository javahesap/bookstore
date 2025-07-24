package com.crni99.bookstore.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.crni99.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

