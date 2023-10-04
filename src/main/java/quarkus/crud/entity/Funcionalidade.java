package quarkus.crud.entity;

import jakarta.persistence.*;
import quarkus.crud.base.entity.EntityBase;

import java.util.UUID;

/**
 *
 *    - JSON serialized/deserialized:
 *       * Construtor Padrão: A default constructor is required by the JSON serialization layer.
 *
 *
 */



@Entity
public class Funcionalidade extends EntityBase {


    @Column
    public String nome;

    @Column
    public String descricao;

    @Column
    public String uuid;


    public Funcionalidade() {

        this.uuid = UUID.randomUUID().toString();
    }


    // Join
    // SELECT g FROM ChessHame g LEFT JOIN FETCH g.playerWhite LEFT JOIN FETCH g.playerBlack WHERE g.playerBlack.nome = <nome>

    public static boolean existe(Long id) {

        return count("id", id) > 0;
    }

}
