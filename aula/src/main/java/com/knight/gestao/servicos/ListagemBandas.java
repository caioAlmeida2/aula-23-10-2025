package com.knight.gestao.servicos;

import java.util.List;

import com.knight.gestao.daos.BandaDAO;
import com.knight.gestao.modelos.Banda;
import com.knight.gestao.modelos.Musico;
import com.knight.gestao.modelos.Usuario;
import jakarta.jws.*;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.ws.Endpoint;

@WebService
public class ListagemBandas {

    //4.1) Listagem das duas tabelas

    @WebResult(name = "banda")
    public List<Banda> listarBandas() {
        return obterDAO().listarBandas();
    }

    @WebResult(name = "musico")
    public List<Musico> listarMusicos() {
        return obterDAO().listarMusicos();
    }

    //4.2) Filtros
    @WebResult(name = "banda")
    public List<Banda> buscarBandasPorGenero(@WebParam(name = "genero") String genero) {
        return obterDAO().buscarBandasPorGenero(genero);
    }

    @WebResult(name = "musico")
    public List<Musico> buscarMusicosPorInstrumento(@WebParam(name = "instrumento") String instrumento) {
        return obterDAO().buscarMusicosPorInstrumento(instrumento);
    }

    //4.3) Inserção autenticada
    public void criarBanda(
            @WebParam(name = "banda") Banda banda,
            @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException, SOAPException {

        autenticar(usuario); // Verifica a senha
        obterDAO().criarBanda(banda);
        System.out.println("Banda '" + banda.getNome() + "' criada com sucesso.");
    }

    public void criarMusico(
            @WebParam(name = "musico") Musico musico,
            @WebParam(name = "usuario", header = true) Usuario usuario)
            throws UsuarioNaoAutorizadoException {

        autenticar(usuario);
        obterDAO().criarMusico(musico);
        System.out.println("Músico '" + musico.getNome() + "' criado com sucesso.");
    }


    private void autenticar(Usuario usuario) throws UsuarioNaoAutorizadoException {
        System.out.println("login: " + usuario.getLogin() + "\nsenha: " + usuario.getSenha());
        if ("soa".equals(usuario.getLogin()) && "soa".equals(usuario.getSenha()))
            return;
        throw new UsuarioNaoAutorizadoException("Usuário ou senha inválidos.");
    }

    private BandaDAO obterDAO() {
        return new BandaDAO();
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/bandas", new ListagemBandas());
        System.out.println("Serviço de BANDAS e MÚSICOS inicializado!");
    }
}