package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/* TUDO O QUE FOR MODELADO AQUI, SERÁ PERSISTIDO NO BANCO DE DADOS. NUMA CLASSE DTO OU DAO PODEM SER DEFINIDOS OS ATRIBUTOS QUE NÃO DEVEM CONSTAR NO BANCO

PERSISITIR NO BANCO DE DADOS - ESSA CLASSE DEVE SER ARMAZENADA NO BANCO DE DADOS */
@Entity
// LOMBOK - MÉTODOS DE ACESSO
@Getter @Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    /* CARDINALIDADE BI-DIRECIONAL, POIS TEM ESSA CARDINALIDADE EM AMBOS
    * PORTANTO, DADO UM AUTOR EU OBTENHO O ENDEREÇO E VICE-VERSA.
    *
    * mappedBy = UTILIZADO PARA INDICAR QUAL É A TABELA QUE É PROPRIETÁRIA DO RELACIONAMENTO.
    * COLOCA-SE O NOME DO CAMPO DA TABELA ADDRESS QUE É USADO COMO REFERÊNCIA PARA O OBJETO
    *
    * fetch = FetchType.LAZY = Faz com que a informação só seja buscada quando for necessário. Ou seja,
    * a consulta só acontece quando o relacionamento exigir. Desse jeito serão feitas duas consultas,
    * sem essa opção, já é feito o join direto  */
    @OneToOne(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("author") // IGNORA OS DADOS DO AUTOR (AO PREENCHER O ADDRESS NÃO TRAGA OS DADOS DO AUTHOR)
    private Address address;
}
