package quarkus.crud.entity;

import jakarta.persistence.*;
import quarkus.crud.base.EntityBase;

@Entity
@Table(name = "funcionalidade")
public class Funcionalidade extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "sistema_id")
    public Sistema sistema;

    @Column(name = "nome")
    public String nome;

    @Column(name = "descricao")
    public String descricao;

    @ManyToOne
    @JoinColumn(name = "acao_id")
    public Acao acao;


    public String getNome() {

        return nome != null ? nome.toUpperCase() : null;
    }

}
