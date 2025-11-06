package com.knight.estoque.servicos;

public class UsuarioNaoAutorizadoException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoAutorizadoException() {
    }

    public UsuarioNaoAutorizadoException(String message) {
        super(message);
    }

    public UsuarioNaoAutorizadoException(Throwable cause) {
        super(cause);
    }

    public UsuarioNaoAutorizadoException(String message,
            Throwable cause) {
        super(message, cause);
    }
    
}
