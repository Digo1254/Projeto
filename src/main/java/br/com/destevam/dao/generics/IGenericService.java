package main.java.br.com.destevam.dao.generics;

import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.domain.Persistance;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;


public interface IGenericService<T extends Persistance> {

    Boolean salvar(T entidade) throws TipoChaveNaoEncontradoException;

    T buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(T entidade) throws TipoChaveNaoEncontradoException;

}
