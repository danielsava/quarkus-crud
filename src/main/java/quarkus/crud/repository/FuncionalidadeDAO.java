package quarkus.crud.repository;

import jakarta.enterprise.context.ApplicationScoped;
import quarkus.crud.base.RepositoryBase;
import quarkus.crud.entity.Funcionalidade;

import java.util.List;

@ApplicationScoped
public class FuncionalidadeDAO extends RepositoryBase<Funcionalidade> {


    public Funcionalidade findByName(String name) {

        return find("name", name).firstResult();
    }

    public List<Funcionalidade> findByDescricao(String descricao) {

        return list("descricao", descricao);
    }

    public void deleteByUUID(String uuid) {

        delete("uuid", uuid);
    }

}

