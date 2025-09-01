package main.java.br.com.destevam.dao.generics;

import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.domain.Persistance;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public class GenericService<T extends Persistance> implements IGenericService<T> {

    private IGenericDAO<T> genericDAO;

    public GenericService(IGenericDAO generic){

         genericDAO = generic;

    }



    @Override
    public Boolean salvar(T entidade) throws TipoChaveNaoEncontradoException {
        return genericDAO.cadastrar(entidade);
    }

    @Override
    public T buscarPorCpf(Long cpf) {
        return genericDAO.consultar(cpf);
        
    }

    @Override
    public void excluir(Long cpf) {
        genericDAO.excluir(cpf);
    }

    @Override
    public void alterar(T entidade) throws TipoChaveNaoEncontradoException {
        genericDAO.alterar(entidade);
    }


}
