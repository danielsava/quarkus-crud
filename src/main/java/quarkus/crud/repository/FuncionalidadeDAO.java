package quarkus.crud.repository;

import jakarta.enterprise.context.ApplicationScoped;
import quarkus.crud.entity.Funcionalidade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class FuncionalidadeDAO {


    public boolean existe(Long id) {

        return Funcionalidade.count("id", id) > 0;
    }

    public Funcionalidade findByName(String name) {

        return Funcionalidade.find("name", name).firstResult();
    }

    public List<Funcionalidade> findByDescricao(String descricao) {

        return Funcionalidade.list("descricao", descricao);
    }

    public void deleteByUUID(String uuid) {

        Funcionalidade.delete("uuid", uuid);
    }

    public List<Funcionalidade> find(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return Funcionalidade.list("id = :id or nome = :nome or descricao = :desc", params);
    }


    public List<Funcionalidade> findContains(Long id, String nome, String desc) {

        Map<String , Object> params = new HashMap<>();

        params.put("id", id);
        params.put("nome", nome);
        params.put("desc", desc);

        return Funcionalidade.list("id = :id or nome like CONCAT('%', CONCAT(:nome, '%')) or descricao = :desc", params);
    }





}

