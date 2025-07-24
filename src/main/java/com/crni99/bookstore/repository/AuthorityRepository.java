package com.crni99.bookstore.repository;



import com.crni99.bookstore.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}

