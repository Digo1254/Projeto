import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import main.java.br.com.destevam.dao.*;
import main.java.br.com.destevam.domain.Produto;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    private Produto produto;

    public ProdutoDAOTest(){
        produtoDAO = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradoException{
        
        produto = new Produto();

        produto.setCodigo(19L);
        produto.setNome("Clips");
        produto.setSetor("Papelaria");

        produtoDAO.cadastrar(produto);

        
    }

    @Test
    public void pesquisarProduto(){

        Produto produtoConsultado = produtoDAO.consultar(produto.getCodigo());

        Assert.assertNotNull(produtoConsultado);

    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradoException{

        produtoDAO.cadastrar(produto);
    }


    @Test
    public void excluirProduto(){
        produtoDAO.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradoException{
        produto.setNome("Grampeador");
        produtoDAO.alterar(produto);

        Assert.assertEquals("Grampeador", produto.getNome());
    }

}
