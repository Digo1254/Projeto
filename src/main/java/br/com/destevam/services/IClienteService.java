package main.java.br.com.destevam.services;

import main.java.br.com.destevam.dao.generics.IGenericService;
import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public interface IClienteService extends IGenericService<Cliente> {

    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradoException;

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradoException;

}
