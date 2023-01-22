package com.example.BibliotecaDST.repo;

import com.example.BibliotecaDST.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByNickEquals(String nick);

    Boolean existsUserByNickEquals(String nick);

}
