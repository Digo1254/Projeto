import main.java.br.com.destevam.dao.IProdutoDAO;
import main.java.br.com.destevam.domain.Produto;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public class ProdutoDAOMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entidade) throws TipoChaveNaoEncontradoException {
        return true;
    }

    @Override
    public void excluir(Long valor) {
        
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradoException {
        
    }

    @Override
    public Produto consultar(Long valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

}
