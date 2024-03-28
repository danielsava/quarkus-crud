package quarkus.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "permissao")
public class Permissao extends EntityBase {


    @ManyToOne
    @JoinColumn(name = "perfil_id")
    public Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "funcionalidade_id")
    public Funcionalidade funcionalidade;

}
