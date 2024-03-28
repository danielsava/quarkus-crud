package quarkus.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import quarkus.crud.base.EntityBase;

import java.util.List;

@Entity
@Table(name = "sistema")
public class Sistema extends EntityBase {

    @Column(name = "nome")
    public String nome;

    @Column(name = "descricao")
    public String descricao;

    @OneToMany(mappedBy = "sistema")
    public List<Funcionalidade> funcionalidades;


}
