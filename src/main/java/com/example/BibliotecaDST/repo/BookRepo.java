package com.example.BibliotecaDST.repo;

import com.example.BibliotecaDST.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
