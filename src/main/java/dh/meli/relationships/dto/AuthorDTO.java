package dh.meli.relationships.dto;

import dh.meli.relationships.model.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AuthorDTO {
    // ATRIBUTOS QUE DEVERÃO SER RETORNADOS
    private String name;
    private AddressDTO addressDTO;

    // É AQUI QUE ACONTECE A TRANSFORMAÇÃO
    // CONSTRUTOR RECEBE COMO PARÂMETRO UM AUTOR (id, name, address)
    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.addressDTO = new AddressDTO(author.getAddress()); // TRANSFORMA O ENDEREÇO RECEBIDO EM ENDEREÇO DTO
    }
}
