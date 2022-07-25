package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/* TUDO O QUE FOR MODELADO AQUI, OU SEJA, DENTRO DE UMA CLASSE MODEL, SERÁ PERSISTIDO NO BANCO DE DADOS.
* NUMA CLASSE DTO OU DAO PODEM SER DEFINIDOS OS ATRIBUTOS QUE NÃO DEVEM CONSTAR NO BANCO
*
* PERSISITIR NO BANCO DE DADOS = A CLASSE QUE SERÁ ARMAZENADA NO BANCO DE DADOS
*
* A ANOTAÇÃO @Entity É A ANOTAÇÃO QUE INDICA ESSA PERSISTÊNCIA PARA O JPA. */
@Entity
@Getter @Setter @NoArgsConstructor // LOMBOK - MÉTODOS DE ACESSO
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    /* CARDINALIDADE BI-DIRECIONAL, POIS TEM ESSA CARDINALIDADE EM AMBAS AS CLASSES (Author e Address)
    * PORTANTO, DADO UM AUTOR EU OBTENHO O ENDEREÇO E VICE-VERSA.
    *
    * 🔘 mappedBy = UTILIZADO PARA INDICAR QUAL É A TABELA QUE É PROPRIETÁRIA DO RELACIONAMENTO.
    * COLOCA-SE O NOME DO CAMPO (DEFINIDO NO MODEL ADDRESS) QUE SERÁ USADO COMO REFERÊNCIA PARA O OBJETO AUTHOR.
    *
    * 🔘 fetch = FetchType.LAZY = Faz com que a informação só seja buscada quando for necessário. Ou seja,
    * a consulta só acontece quando o relacionamento exigir.
    * Em nosso exemplo, deixando essa opção, serão feitas duas consultas ao banco de dados,
    * sem essa opção, já é feito o join direto. Usar essa opção com cautela.
    *
    * 🔘 cascade = CascadeType.PERSIST = AO FAZER A PESISTENCIA DO AUTOR, QUERO SALVAR ESSE RELACIONAMENTO TAMBÉM
    * PERSIST é para insert
    * REMOVE para o delete (apaga tudo em cascata)
    * ALL é para qualquer operação que for em cascata.
    *
    * 1:1 - 1 AUTOR PARA 1 ENDEREÇO */
    @OneToOne(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("author") // IGNORA OS DADOS DO AUTOR (AO PREENCHER O ADDRESS NÃO TRAGA OS DADOS DO AUTHOR)
    private Address address; // CAMPO QUE REFERENCIA O OBJETO. NOME DO CAMPO: address
}
