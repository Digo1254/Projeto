package main.java.br.com.destevam.dao;

import java.util.HashMap;
import java.util.Map;

import main.java.br.com.destevam.dao.generics.GenericDAO;
import main.java.br.com.destevam.dao.generics.SingletonMap;
import main.java.br.com.destevam.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteDAO(){
        super();

        Map<Long,Cliente> mapaInterno = (Map<Long,Cliente>) SingletonMap.getInstance().getMap().get(getTipoClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(),mapaInterno);
        }
        
    }

    @Override
    public Class<Cliente> getTipoClasse() {
       return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entidade, Cliente entidadeCadastrado) {

        entidadeCadastrado.setNome(entidade.getNome());
        entidadeCadastrado.setCid(entidade.getCid());
        entidadeCadastrado.setEnd(entidade.getEnd());
        entidadeCadastrado.setEst(entidade.getEst());
        entidadeCadastrado.setTel(entidade.getTel());
        entidadeCadastrado.setNum(entidade.getNum());

    }



}
