package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String name;

    // ------- LIVRO (BOOK) -------- //
    // O MESMO LIVRO PODE TER '1' ASSUNTO (e um assunto pode ter 'N' livros)
    // 1:N
    @OneToMany(mappedBy = "subject") // TABELA PROPRIETÁRIA DO RELACIONAMENTO: subject
    @JsonIgnoreProperties("subject") // AO PESQUISAR PELO LIVRO: 'dentro do livro não trazer o assunto'
    private List<Book> books;
}
