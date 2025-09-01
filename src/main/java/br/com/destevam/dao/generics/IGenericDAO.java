package main.java.br.com.destevam.dao.generics;

import main.java.br.com.destevam.domain.*;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public interface IGenericDAO <T extends Persistance> {

    public Boolean cadastrar(T entidade) throws TipoChaveNaoEncontradoException;

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradoException;

    public T consultar(Long valor);



}
