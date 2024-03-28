package quarkus.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import quarkus.crud.base.EntityBase;

import java.util.Set;

/**
 *
 *    - JSON serialized/deserialized:
 *       * Construtor Padrão: A default constructor is required by the JSON serialization layer.
 *
 *
 */



@Entity
@Table(name = "perfil")
public class Perfil extends EntityBase {

    @Column(name = "nome")
    public String nome;

    @ManyToMany
    public Set<Funcionalidade> permissoes;

}
