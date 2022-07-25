package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // PERSISITR OS DADOS NO BANCO
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String title;

    // ----- ASSUNTO (SUBJECT) ------- //
    // O MESMO ASSUNTO PODE TER 'N' LIVROS (e o livro só pode ter '1' assunto)
    // N:1
    @ManyToOne
    @JoinColumn(name = "id_subject") // CHAVE ESTRANGEIRA (FK)
    @JsonIgnoreProperties("books") // ignorar a lista de livros do subject, quando pesquisar pelo livro
    private Subject subject;
}
