package dh.meli.relationships.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String location;

    /* CARDINALIDADE BI-DIRECIONAL, POIS TEM ESSA CARDINALIDADE EM AMBAS AS CLASSES
     * PORTANTO, DADO UM ENDEREÇO EU OBTENHO O AUTOR E VICE-VERSA
     *
     * 1:1  -  1 ENDEREÇO PARA 1 AUTOR */
    @OneToOne
    @JoinColumn(name = "id_author") // NOME PARA A CHAVE ESTRANGEIRA (FK)
    private Author author; // CAMPO QUE REFERENCIA O OBJETO. NOME DO CAMPO: author
}
