package com.mohammadmarediya.quiz_app.Repositories;

import com.mohammadmarediya.quiz_app.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);
}
