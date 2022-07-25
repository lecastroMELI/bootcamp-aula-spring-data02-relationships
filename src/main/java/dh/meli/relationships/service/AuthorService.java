package dh.meli.relationships.service;

import dh.meli.relationships.model.Author;
import dh.meli.relationships.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {
    // ESSA CLASSE VAI CORRIGUR O PROBLEMA DE SALVAR UM ENDEREÇO SEM UM AUTOR

    @Autowired
    private AuthorRepository repository;

    @Transactional // VAI DESFAZER TUDO SE DER ALGUM ERRO NO MOMENTO DA INSERÇÃO.
    public Author save(Author newAuthor) {
        // AJUSTA O ENDEREÇO DO AUTOR, OU SEJA, PREENCHE O ADDRESS DO MODEL AUTHOR (private Address address)
        newAuthor.getAddress().setAuthor(newAuthor);
        return repository.save(newAuthor);
    }
}
