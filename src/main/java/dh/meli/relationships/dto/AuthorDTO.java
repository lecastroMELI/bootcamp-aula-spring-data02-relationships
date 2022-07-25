package dh.meli.relationships.dto;

import dh.meli.relationships.model.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor // IMPORTANTE ELE SEMPRE SER DECLADO, PORQUE O JPA PRECISA DELE A PRINCÍPIO
public class AuthorDTO {
    // ATRIBUTOS QUE DEVERÃO SER RETORNADOS NO JSON DA REQUISIÇÃO
    private String name; // name É O NOME QUE APARECE NO JSON
    private AddressDTO addressDTO; // addressDTO É O NOME QUE APARECE NO JSON

    // É AQUI QUE ACONTECE A TRANSFORMAÇÃO
    // CONSTRUTOR RECEBE COMO PARÂMETRO UM AUTOR (id, name, address)
    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.addressDTO = new AddressDTO(author.getAddress()); // TRANSFORMA O ENDEREÇO RECEBIDO EM ENDEREÇO DTO
    }
}
