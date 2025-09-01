import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.destevam.domain.*;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;
import main.java.br.com.destevam.dao.*;

import main.java.br.com.destevam.services.*;


public class ClienteServiceTest {

    private Cliente cliente;

    private IClienteService clienteService;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        
        cliente = new Cliente();

        cliente.setCpf(123L);
        cliente.setNome("Diego");
        cliente.setCid("Sao caetano");
        cliente.setEnd("Rua rafael correa");
        cliente.setEst("SP");
        cliente.setNum(1350);
        cliente.setTel(1L); 

       
    }

    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradoException{

        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertEquals(true, retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradoException{
        cliente.setNome("Camily");

        clienteService.alterar(cliente);

        Assert.assertEquals("Camily", cliente.getNome());
    }

}
