package dh.meli.relationships.repository;

import dh.meli.relationships.dto.AuthorDTO;
import dh.meli.relationships.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    // MÉTODOS PERSONALIZADOS (NÃO INTERPRETADOS PELO JPA)
    // source: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

    /*
    * JPQL = EXECUTA UM CONSULTA NO BANCO COM SUAS PARTICULARIDADES
    * SELECT A FROM Author A = seleciona todos os atributos do autor.
    * O "A" É UM ALIAS PARA MINHA CLASSE (LEMBRNADO QUE A CLASSE EQUIVALE A TABELA NO BANCO)
    * PORTANTO AO CRIAR "SELECT A" EQUIVALE A "SELECT *"
    * WHERE a.id = informar o parâmetro que o método recebe
    * ?1 ?2 ?3 ... parâmetro por ordem de entrada.
     * */
    @Query("SELECT A FROM Author A WHERE A.id = ?1") // SQL JPQL
    AuthorDTO getById(long id);

    // CONSULTA SQL NATIVA (IGUAL FAZ NO BANCO)
    /* O RETORNO DO SELECT TEM QUE SER DO MESMO TIPO QUE O MÉTODO ESPERA */
    @Query(value = "SELECT * FROM Author WHERE id = ?1", nativeQuery = true) // SQL NATIVO
    Author getNativeById(long id);

    /*
    * A CONSULTA COMENTADA ABAIXO EQUIVALE A CONSULTA JPQL
    * SELECT *
    * FROM Author
    * LEFT JOIN Address ON Author.id  = Address.id_author WHERE id = ?1
    *
    * :id = CORRESPONDE AO PARÂMETRO DO MÉTODO getDtoEagle()
    *
    *
    *
    * fetch = INDICA QUE SERÁ FEITA UMA CONSULTA ANTECIPADA, OU SEJA, UMA CONSULTA ÚNICA. SEM ELE, SERIAM DUAS CONSULTAS
    * */
    @Query("SELECT A " +
        "FROM Author A LEFT JOIN FETCH A.address" +
        " WHERE A.id = :id") // SQL JPQL
    AuthorDTO getDtoEagle(long id);
}
