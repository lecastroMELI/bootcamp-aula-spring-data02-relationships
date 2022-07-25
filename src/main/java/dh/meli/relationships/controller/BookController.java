package dh.meli.relationships.controller;

import dh.meli.relationships.model.Book;
import dh.meli.relationships.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
