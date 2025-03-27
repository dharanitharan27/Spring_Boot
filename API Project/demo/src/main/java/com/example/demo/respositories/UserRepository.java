package com.example.demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteById(Long id);

    // JPQL query to find a user by email
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}
