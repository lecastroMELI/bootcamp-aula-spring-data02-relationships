package dh.meli.relationships.service;

import dh.meli.relationships.model.Author;
import dh.meli.relationships.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    /* NESSA CLASSE FOI IMPLEMENTADO UM MÉTODO DE TRANSAÇÃO PARA CORRIGUR O PROBLEMA DE SALVAR UM ENDEREÇO SEM UM AUTOR
    * O ENDEREÇO 4 NO BANCO ESTÁ COM AUTOR NULL */

    @Transactional // VAI DESFAZER TUDO SE DER ALGUM ERRO NO MOMENTO DA INSERÇÃO.
    public Author save(Author newAuthor) {
        // AJUSTA O ENDEREÇO DO AUTOR, OU SEJA, PREENCHE O ADDRESS DO MODEL AUTHOR (LINHA: private Address address)
        newAuthor.getAddress().setAuthor(newAuthor);
        // SALVA O newAuthor AJUSTADO E RETORNA O OBJETO Author
        return repository.save(newAuthor);
    }
}
