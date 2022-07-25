package dh.meli.relationships.controller;

import dh.meli.relationships.model.Subject;
import dh.meli.relationships.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository repository; // NÃO É UMA BOA PRÁTICA INJETAR O REPOSITÓRIO NO CONTROLLER

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
