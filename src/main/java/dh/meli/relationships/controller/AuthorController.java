package dh.meli.relationships.controller;

import dh.meli.relationships.dto.AuthorDTO;
import dh.meli.relationships.model.Author;
import dh.meli.relationships.repository.AuthorRepository;
import dh.meli.relationships.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AuthorDTO> getDtoById(@PathVariable long id) {
        return ResponseEntity.ok(repository.getById(id));
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById(@PathVariable long id) {
        return ResponseEntity.ok(repository.getNativeById(id));
    }

    @GetMapping("/eagle/{id}")
    public ResponseEntity<AuthorDTO> getDtoEagleById(@PathVariable long id) {
        return ResponseEntity.ok(repository.getDtoEagle(id));
    }

    @PostMapping
    public ResponseEntity<Author> newAuthor(@RequestBody Author newAuthor) {
        // return ResponseEntity.ok(repository.save(newAuthor));
        return ResponseEntity.ok(service.save(newAuthor));
    }

    // TODO: objeter o método delete do prof


}
