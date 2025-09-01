package main.java.br.com.destevam.exception;

public class TipoChaveNaoEncontradoException extends Exception {

    public TipoChaveNaoEncontradoException(String msg) { this(msg, null); }

    public TipoChaveNaoEncontradoException(String msg, Throwable e) { super(msg, e);}


}
