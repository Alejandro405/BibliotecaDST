package com.example.BibliotecaDST.controller;

import com.example.BibliotecaDST.model.Book;
import com.example.BibliotecaDST.repo.BookRepo;
import com.example.BibliotecaDST.tools.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController extends Book {
    private final BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> res = bookRepo.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        Book res = bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException("Book by id = " + id + " no found"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        return new ResponseEntity<>(bookRepo.save(newBook), HttpStatus.OK);
    }

    @PostMapping("/addAll")
    public HttpStatus addAllBooks(@RequestBody List<Book> data) {
        for (Book x :
                data) {

            bookRepo.save(x);

            System.out.println("Libro ->" + x.toString() + "<-");
        }

        return HttpStatus.OK;
    }

    @PostMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        if (bookRepo.existsById(book.getId())) {
            bookRepo.deleteById(book.getId());
        }

        return new ResponseEntity<>(bookRepo.save(book), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Book> deleteById(@RequestBody List<Long> ids) {
        for (Long x :
                ids) {
            bookRepo.deleteById(x);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
