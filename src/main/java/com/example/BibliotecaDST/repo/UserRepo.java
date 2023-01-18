package com.example.BibliotecaDST.repo;

import com.example.BibliotecaDST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
