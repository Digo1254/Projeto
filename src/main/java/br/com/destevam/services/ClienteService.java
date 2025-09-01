package main.java.br.com.destevam.services;

import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;
import main.java.br.com.destevam.dao.*;
import main.java.br.com.destevam.dao.generics.GenericService;
import main.java.br.com.destevam.dao.generics.IGenericDAO;

public class ClienteService extends GenericService<Cliente> implements IClienteService{


    public ClienteService(IGenericDAO genericDAO) {
        super(genericDAO);
        
    }

    // ClienteService(){
    //     super();
    // }
    
    // private IClienteDAO clienteDAO;

    // public ClienteService(IClienteDAO dao){
    //     clienteDAO = dao;
    // }

    // @Override
    // public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradoException {
    //     return clienteDAO.cadastrar(cliente);
    // }

    // @Override
    // public Cliente buscarPorCpf(Long cpf) {
    //     return clienteDAO.consultar(cpf);
    // }

    // @Override
    // public void excluir(Long cpf) {
    //     clienteDAO.excluir(cpf);
    // }

    // @Override
    // public void alterar(Cliente cliente) throws TipoChaveNaoEncontradoException {
    //     clienteDAO.alterar(cliente);
    // }



}
