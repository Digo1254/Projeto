package main.java.br.com.destevam.domain;

import main.java.br.com.destevam.annotation.TipoChave;

public class Produto implements Persistance {

    private String nome;
    @TipoChave(value="getCodigo")
    private Long codigo;
    private String setor;



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
   

    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
}
