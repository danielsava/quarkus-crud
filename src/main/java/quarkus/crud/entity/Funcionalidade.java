package quarkus.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import quarkus.crud.base.EntityBase;

import java.util.UUID;

/**
 *
 *    - JSON serialized/deserialized:
 *       * Construtor Padrão: A default constructor is required by the JSON serialization layer.
 *
 *
 */



@Entity
@Table(name = "funcionalidade")
public class Funcionalidade extends EntityBase {


    @Column(name = "nome")
    public String nome;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "uuid")
    public String uuid;


    public Funcionalidade() {

        this.uuid = UUID.randomUUID().toString();
    }


    public String getNome() {

        return nome != null ? nome.toUpperCase() : null;
    }

}
