import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.destevam.dao.ClienteDAO;
import main.java.br.com.destevam.dao.IClienteDAO;
import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradoException{
        
        cliente = new Cliente();

        cliente.setCpf(123L);
        cliente.setNome("Diego");
        cliente.setCid("Sao caetano");
        cliente.setEnd("Rua rafael correa");
        cliente.setEst("SP");
        cliente.setNum(1350);
        cliente.setTel(1L); 

        clienteDAO.cadastrar(cliente);

        
    }

    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradoException{

        clienteDAO.cadastrar(cliente);
    }


    @Test
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradoException{
        cliente.setNome("Camily");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Camily", cliente.getNome());
    }

}
