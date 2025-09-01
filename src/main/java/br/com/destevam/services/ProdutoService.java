package main.java.br.com.destevam.services;

import main.java.br.com.destevam.dao.generics.GenericService;
import main.java.br.com.destevam.dao.generics.IGenericDAO;
import main.java.br.com.destevam.domain.Produto;

public class ProdutoService extends GenericService<Produto> implements IProdutoService{

    public ProdutoService(IGenericDAO generic) {
        super(generic);
    }

}
