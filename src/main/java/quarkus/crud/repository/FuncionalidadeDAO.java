package quarkus.crud.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import quarkus.crud.entity.Funcionalidade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class FuncionalidadeDAO implements PanacheRepository<Funcionalidade> {






    public boolean existe(Long id) {

        return count("id", id) > 0;
    }

    public Funcionalidade findByName(String name) {

        return find("name", name).firstResult();
    }

    public List<Funcionalidade> findByDescricao(String descricao) {

        return list("descricao", descricao);
    }

    public void deleteByUUID(String uuid) {

        delete("uuid", uuid);
    }

    public List<Funcionalidade> find(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return list("id = :id or nome = :nome or descricao = :desc", params);
    }


    public List<Funcionalidade> findContains(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return list("id = :id or nome like CONCAT('%', CONCAT(:nome, '%')) or descricao = :desc", params);
    }





}

