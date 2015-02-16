package com.github.williamcosta303.controle;

import java.sql.*;
import com.github.williamcosta303.modelo.ContatoBanco;
import com.github.williamcosta303.modelo.Login;
import com.github.williamcosta303.modelo.Chamado;
import com.github.williamcosta303.modelo.Registro;
import com.github.williamcosta303.modelo.Equipe;
import java.util.ArrayList;

public class ControleBanco {
    
    // Cadastrar login
    public void cadastrarLogin(Login L) throws SQLException{
        ContatoBanco.cadastrarPessoa(L);
    }
    
    // Verificar login
    public boolean verificarLogin(String usuario, String senha) throws SQLException, Exception{
        return ContatoBanco.usuarioConfere(usuario, senha);
    }
    
    // Dados principais
    public Login getDadosPrincipais(String username) throws SQLException{
        return ContatoBanco.getDadosPrincipais(username);
    }
    
    // Buscar usuário
    public static Login buscarUsuario(String username) throws SQLException, Exception{
        return ContatoBanco.buscarUsuario(username);
    }
    
    // Atualizar usuário no banco
    public static void atualizarCadastro(Login L, boolean alterandoSomenteSenha) throws SQLException{
        ContatoBanco.atualizarCadastro(L, alterandoSomenteSenha);
    }
    
    // Cadastrar chamado
    public void cadastrarChamado(Chamado C) throws SQLException{
        ContatoBanco.cadastrarChamado(C);
    }
    
    // Alterar dados do chamado
    public static void editarDadosChamado(int codigoChamado, String titulo, String categoria, String localizacao, String nomeEstacao, String descricao) throws SQLException{
        ContatoBanco.editarDadosChamado(codigoChamado, titulo, categoria, localizacao, nomeEstacao, descricao);
    }
    
    /**
     * ---------------
     * | Métodos pessoas com permissões
     * ---------------
     */
    
    // Receber equipes para cadastrar usuário
    public ArrayList<Equipe> receberEquipes() throws SQLException{
        return ContatoBanco.receberEquipes();
    }
    
    // Receber chamados
    public ArrayList<Chamado> receberChamados(int responsavel) throws SQLException{
        return ContatoBanco.receberMeusChamados(responsavel);
    }
    
    // Contagem chamados abertos usuarios
    public int receberChamados(int responsavel, int estado) throws SQLException{
        return ContatoBanco.contarMeusChamados(responsavel, estado);
    }
    
    // Contagem chamados abertos equipes
    public int receberChamadosEquipe(int equipe, int estado) throws SQLException{
        return ContatoBanco.contarChamadosEquipe(equipe, estado);
    }
    
    // Receber lista de chamados
    public ArrayList<Chamado> receberListaChamados(boolean usuario, int equipe, int estado) throws SQLException{
        return ContatoBanco.receberListaChamados(usuario, equipe, estado);
    }
    
    // Receber um único chamado
    public Chamado receberChamado(int codigo) throws SQLException{
        return ContatoBanco.receberChamado(codigo);
    }
    
    // Receber nome de um responsável pelo código
    public String receberNomeResponsavel(int codigoResponsavel) throws SQLException{
        return ContatoBanco.receberNomeResponsavel(codigoResponsavel);
    }
    
    // Receber nome de uma equipe pelo código
    public String receberNomeEquipe(int codigoEquipe) throws SQLException{
        return ContatoBanco.receberNomeEquipe(codigoEquipe);
    }
    
    // Receber funcionários de um setor
    public static ArrayList<Login> receberFuncionariosSetor(int codigoSetor) throws SQLException{
        return ContatoBanco.receberFuncionariosSetor(codigoSetor);
    }
    
    // Receber codigo de um usuário pelo nome
    public static int receberCodigoUsuarioPorNome(String nome) throws SQLException{
        return ContatoBanco.receberCodigoUsuarioPorNome(nome);
    }
    
    // Retorna o número de um chamado criado anteriormente
    public static int receberNumeroChamado(String descricao, String nomeEstacao, String titulo) throws SQLException{
        return ContatoBanco.receberNumeroChamado(descricao, nomeEstacao, titulo);
    }
    
    /**
     * -------------------
     * Controles de chamados
     * -------------------
     */
    
    // Capturar chamado
    public static void capturarChamado(int numeroChamado, int codigoUsuario, int codigoEquipe) throws SQLException{
        ContatoBanco.capturarChamado(numeroChamado, codigoUsuario, codigoEquipe);
    }
    
    // Alterar estado de um chamado
    public static void alterarEstadoChamado(int codigo, int estado) throws SQLException{
        ContatoBanco.alterarEstadoChamado(codigo, estado);
    }
    
    // Recebe nome de responsável para selecionar
    public static String receberNomeResponsavelSelecionavel(int codigoChamado) throws SQLException{
        return ContatoBanco.receberNomeResponsavelSelecionavel(codigoChamado);
    }
    
    // Encaminha chamado a equipe/funcionário responsável
    public static void encaminharChamado(boolean transfereEquipe, int codigoChamado, int codigoResponsavel) throws SQLException{
        ContatoBanco.encaminharChamado(transfereEquipe, codigoChamado, codigoResponsavel);
    }
    
    /**
     * -------------------
     * REGISTROS DOS CHAMADOS
     * -------------------
     */
    
    // Cria um novo registro
    public static void criarNovoRegistro(String autor, String data, String horario, String registro, int codigoChamado) throws SQLException{
        ContatoBanco.criarNovoRegistro(autor, data, horario, registro, codigoChamado);
    }
    
    // Retorna a lista de registros de um chamado
    public static ArrayList<Registro> receberRegistros(int codigoChamado) throws SQLException{
        return ContatoBanco.receberRegistros(codigoChamado);
    }
    
    /**
     * ---------------
     * BUSCA
     * ---------------
     */
    
    // Verificar se chamado existe
    public static boolean chamadoExiste(int codigo) throws SQLException{
        return ContatoBanco.chamadoExiste(codigo);
    }
    
    // Busca chamados por um campo
    public static ArrayList<Chamado> pesquisarPorCampo(String campo, String valor, boolean incluirFechados) throws SQLException{
        return ContatoBanco.pesquisarPorCampo(campo, valor, incluirFechados);
    }
    
    // Busca chamados por um registro
    public static ArrayList<Chamado> pesquisarPorRegistro(String registro, boolean incluirFechados) throws SQLException{
        return ContatoBanco.pesquisarPorRegistro(registro, incluirFechados);
    }
    
}
