package main.java.br.com.destevam.dao;

import java.util.HashMap;
import java.util.Map;

import main.java.br.com.destevam.dao.generics.GenericDAO;
import main.java.br.com.destevam.dao.generics.SingletonMap;
import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAO(){
        super();

        Map<Long,Produto> mapaInterno = (Map<Long,Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(),mapaInterno);
        }
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entidade, Produto entidadeCadastrado) {

        entidadeCadastrado.setCodigo(entidade.getCodigo());
        entidadeCadastrado.setNome(entidade.getNome());
        entidadeCadastrado.setSetor(entidade.getSetor());
        
    }

}
