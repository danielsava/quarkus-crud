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
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "uuid")
    private String uuid;


    public Funcionalidade() {

        this.uuid = UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
