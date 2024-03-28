package quarkus.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import quarkus.crud.base.EntityBase;

/**
 *
 *    - JSON serialized/deserialized:
 *       * Construtor Padrão: A default constructor is required by the JSON serialization layer.
 *
 *
 */



@Entity
@Table(name = "acao")
public class Acao extends EntityBase {

    @Column(name = "nome")
    public String nome;   // Incluir, Alterar, Excluir, Visualizar, Imprimir

    @Column(name = "descricao")
    public String descricao;


    public String getNome() {

        return nome != null ? nome.toUpperCase() : null;
    }

}
