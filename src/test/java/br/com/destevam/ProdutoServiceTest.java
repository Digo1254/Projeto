import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.destevam.domain.*;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;
import main.java.br.com.destevam.dao.*;

import main.java.br.com.destevam.services.*;



public class ProdutoServiceTest {

    private Produto produto;

    private IProdutoService produtoService;

    public ProdutoServiceTest(){
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init(){
        
        produto = new Produto();

        produto.setCodigo(10L);
        produto.setNome("Papel");
        produto.setSetor("Cosmético");


       
    }

    @Test
    public void pesquisarProduto(){

        Produto produtoConsultado = produtoService.buscarPorCpf(produto.getCodigo());

        Assert.assertNotNull(produtoConsultado);

    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradoException{

        Boolean retorno = produtoService.salvar(produto);

        Assert.assertEquals(true, retorno);
    }

    @Test
    public void excluirProduto(){
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarproduto() throws TipoChaveNaoEncontradoException{
        produto.setNome("Papel Higienico");

        produtoService.alterar(produto);

        Assert.assertEquals("Papel Higienico", produto.getNome());
    }






}
