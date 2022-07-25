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

    @OneToMany(mappedBy = "subject") // 1:N um assunto vários livros
    @JsonIgnoreProperties("subject") // Dentro do livro não trazer o assunto, partindo do pressutos que a pesquisa será feita a partir do livro
    private List<Book> books;
}
