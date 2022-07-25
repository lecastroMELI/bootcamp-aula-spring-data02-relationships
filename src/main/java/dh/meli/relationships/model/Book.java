package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String title;

    // N LIVRO = 1 ASSUNTO
    @ManyToOne // um assunto está em vários livros
    @JoinColumn(name = "id_subject")
    @JsonIgnoreProperties("books") // ignorar a lista de livros do subject, quando pesquisar pelo livro
    private Subject subject;
}
