package main.java.br.com.destevam.domain;

import main.java.br.com.destevam.annotation.TipoChave;

public class Cliente implements Persistance {

    
    private String nome;
    @TipoChave(value = "getCpf")
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;


    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Long getTel(){
        return tel;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd(){
        return end;
    }
    public void setNum(Integer num) {
        this.numero = num;
    }

    public Integer getNum(){
        return numero;
    }
    public void setCid(String cidade) {
        this.cidade = cidade;
    }

    public String getCid(){
        return cidade;
    }
    public void setEst(String estado) {
        this.estado = estado;
    }

    public String getEst(){
        return estado;
    }


}
