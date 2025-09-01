import main.java.br.com.destevam.dao.IClienteDAO;
import main.java.br.com.destevam.domain.Cliente;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public class ClienteDAOMock implements IClienteDAO {

    @Override
    public void excluir(Long cpf) {
        
    }

    @Override
    public void alterar(Cliente cliente) {
       
    }

    @Override
    public Boolean cadastrar(Cliente entidade) throws TipoChaveNaoEncontradoException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }
    

}
