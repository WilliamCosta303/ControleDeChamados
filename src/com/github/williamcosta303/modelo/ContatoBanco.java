package com.github.williamcosta303.modelo;

import java.sql.*;
import java.util.ArrayList;

public class ContatoBanco {
    
    /**
     * ------------
     * | Métodos relacionados ao login dos usuários
     * ------------
     */
    // Cadastrar login
    public static void cadastrarPessoa(Login L) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            sta.execute("INSERT INTO usuarios(username,senha,privilegio,codigoEquipe) VALUES ('" + L.getNome() + "','" + L.getSenha() + "'," + L.getPrivilegio() + ", " + L.getCodigoEquipe() + ");");
        }catch(SQLException SE){
            throw new SQLException("Erro cadastrando usuário!\nCausa: " + SE.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    // Confere usuário e senha com banco
    public static boolean usuarioConfere(String usuario, String senha) throws SQLException, Exception{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try{
            Login L = new Login();
            ResultSet rs = sta.executeQuery("SELECT * FROM usuarios WHERE username='" + usuario + "';");
            while(rs.next()){
                L.setNome(rs.getString("username"));
                L.setSenha(rs.getString("senha"));
            }
            rs.close();
            
            if(usuario.equals(L.getNome())){
                if(senha.equals(L.getSenha())){
                    return true;
                } else {
                    throw new Exception("Senha incorreta");
                }
            } else {
                return false;
            }
            
        }catch(SQLException SE){
            throw new SQLException("Erro conferindo usuário ao BD!\nCausa: " + SE.getMessage());
        }catch(Exception E){
            throw new Exception("ERRO!\nCausa: " + E.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    // Dados principais para tela de chamado
    public static Login getDadosPrincipais(String username) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try{
            Login L = new Login();
            ResultSet rs = sta.executeQuery("SELECT * FROM usuarios WHERE username='" + username + "';");
            while(rs.next()){
                L.setCodigo(rs.getInt("codigo"));
                L.setNome(rs.getString("username"));
                L.setPrivilegio(rs.getInt("privilegio"));
                L.setCodigoEquipe(rs.getInt("codigoEquipe"));
            }
            rs.close();
            
            return L;
        }catch(SQLException SE){
            throw new SQLException("Erro recebendo dados do BD!\nCausa: " + SE.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    // Buscar usuário para alteração
    public static Login buscarUsuario(String username) throws SQLException, Exception{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try{
            Login L = new Login();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM usuarios WHERE username='" + username + "';");
            while(rs.next()){
                L.setCodigo(rs.getInt("codigo"));
                L.setNome(rs.getString("username"));
                L.setSenha(rs.getString("senha"));
                L.setPrivilegio(rs.getInt("privilegio"));
                L.setCodigoEquipe(rs.getInt("codigoEquipe"));
            }
            rs.close();
            
            if(L.getNome().isEmpty()){
                throw new Exception("Usuário não localizado!");
            }
            
            return L;
        }catch(SQLException SE){
            throw new SQLException("Erro recebendo dados do BD!\nCausa: " + SE.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    // Atualizar usuário no banco
    public static void atualizarCadastro(Login L, boolean alterandoSomenteSenha) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try{
            if(!alterandoSomenteSenha){
                if(L.getSenha().equals("(inalterada)")){
                    // Alterar usuário SEM alterar a senha
                    sta.execute("UPDATE usuarios SET username='" + L.getNome() + "',privilegio=" + L.getPrivilegio() + ",codigoEquipe=" + L.getCodigoEquipe() + " WHERE codigo=" + L.getCodigo() + ";");
                } else {
                    // Alterar usuário E a senha
                    sta.execute("UPDATE usuarios SET username='" + L.getNome() + "',senha='" + L.getSenha() + "',privilegio=" + L.getPrivilegio() + ",codigoEquipe=" + L.getCodigoEquipe() + " WHERE codigo=" + L.getCodigo() + ";");
                }
            } else {
                sta.execute("UPDATE usuarios SET senha='" + L.getSenha() + "' WHERE codigo=" + L.getCodigo() + ";");
            }
        }catch(SQLException SE){
            throw new SQLException("Erro atualizando cadastro do BD!\nCausa: " + SE.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    /**
     * ------------
     * | Métodos relacionados a equipes
     * ------------
     */
    
    // Equipes para adicionar usuário
    public static ArrayList<Equipe> receberEquipes() throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try {
            ArrayList<Equipe> listaEquipes = new ArrayList<>();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM equipe ORDER BY codigo ASC ;");
            while(rs.next()){
                Equipe E = new Equipe();
                E.setCodigo(rs.getInt("codigo"));
                E.setNome(rs.getString("nome"));
                
                listaEquipes.add(E);
            }
            rs.close();
            
            return listaEquipes;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo equipes!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Receber nome equipe
    public static String receberNomeEquipe(int codigoEquipe) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try {
            if(codigoEquipe != 1){
                ResultSet rs = sta.executeQuery("SELECT * FROM equipe WHERE codigo=" + codigoEquipe + ";");
                rs.close();
                
                return rs.getString("nome");   
            } else {
                return "";
            }
            
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo nome da equipe!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Receber funcionarios de um setor/equipe
    public static ArrayList<Login> receberFuncionariosSetor(int codigoSetor) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try {
            ArrayList<Login> listaFuncionarios = new ArrayList<>();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM usuarios WHERE codigoEquipe=" + codigoSetor + ";");
            while(rs.next()){
                Login L = new Login();
                L.setCodigo(rs.getInt("codigo"));
                L.setNome(rs.getString("username"));
                
                listaFuncionarios.add(L);
            }
            
            rs.close();
            
            return listaFuncionarios;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    /**
     * ------------
     * | Métodos relacionados a chamados
     * ------------
     */
    
    // Abrir chamado
    public static void cadastrarChamado(Chamado C) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        try{
            sta.execute("INSERT INTO chamados(titulo,categoria,localizacao,nomeEstacao,descricao,abertoPor,equipe,responsavel,estado) VALUES ('" + C.getTitulo() + "','" + C.getCategoria() + "','" + C.getLocalizacao()+ "','" + C.getNomeEstacao() + "','" + C.getDescricao() + "','" + C.getAbertoPor() + "'," + C.getEquipe() + "," + C.getResponsavel() + "," + C.getEstado() + ");");
        }catch(SQLException SE){
            throw new SQLException("Erro cadastrando chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Chamados de um usuário (suporte)
    public static ArrayList<Chamado> receberMeusChamados(int responsavel) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Chamado> listaChamados = new ArrayList<>();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM chamados WHERE responsavel=" + responsavel +";");
            while(rs.next()){
                Chamado C = new Chamado();
                C.setCodigo(rs.getInt("codigo"));
                C.setTitulo(rs.getString("titulo"));
                C.setCategoria(rs.getString("categoria"));
                C.setLocalizacao(rs.getString("localizacao"));
                C.setNomeEstacao(rs.getString("nomeEstacao"));
                C.setDescricao(rs.getString("descricao"));
                C.setAbertoPor(rs.getString("abertoPor"));
                C.setEquipe(rs.getInt("equipe"));
                C.setResponsavel(rs.getInt("responsavel"));
                C.setEstado(rs.getInt("estado"));
                listaChamados.add(C);
            }
            
            rs.close();
            
            return listaChamados;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Editar dados do chamado
    public static void editarDadosChamado(int codigoChamado, String titulo, String categoria, String localizacao, String nomeEstacao, String descricao) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            sta.execute("UPDATE chamados SET titulo='" + titulo + "', categoria='" + categoria + "', localizacao='" + localizacao + "', nomeEstacao='" + nomeEstacao + "', descricao='" + descricao + "' WHERE codigo=" + codigoChamado + ";");
        }catch(SQLException SE){
            throw new SQLException("Erro editando dados do chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Contagem de chamados de um usuário
    public static int contarMeusChamados(int responsavel, int estado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            int resultado = -1;
            
            ResultSet rs = sta.executeQuery("SELECT COUNT(*) as chamadosAbertos FROM chamados WHERE responsavel=" + responsavel + " AND estado=" + estado + ";");
            while(rs.next()){
                resultado = rs.getInt("chamadosAbertos");
            }
            
            rs.close();
            
            return resultado;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Contagem de chamados de uma equipe
    public static int contarChamadosEquipe(int equipe, int estado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            int resultado = -1;
            
            ResultSet rs = sta.executeQuery("SELECT COUNT(*) as chamadosAbertos FROM chamados WHERE equipe=" + equipe + " AND estado=" + estado + ";");
            while(rs.next()){
                resultado = rs.getInt("chamadosAbertos");
            }
            
            rs.close();
            
            return resultado;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Lista de chamados
    public static ArrayList<Chamado> receberListaChamados(boolean usuario, int codigo, int estado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Chamado> listaChamados = new ArrayList<>();
            
            ResultSet rs;
            
            if(usuario){
                rs = sta.executeQuery("SELECT * FROM chamados WHERE responsavel=" + codigo + " AND estado=" + estado + " ORDER BY codigo DESC;");
            } else {
                rs = sta.executeQuery("SELECT * FROM chamados WHERE equipe=" + codigo + " AND estado=" + estado + " ORDER BY codigo DESC;");
            }
            while(rs.next()){
                Chamado C = new Chamado();
                C.setCodigo(rs.getInt("codigo"));
                C.setTitulo(rs.getString("titulo"));
                C.setCategoria(rs.getString("categoria"));
                C.setLocalizacao(rs.getString("localizacao"));
                C.setNomeEstacao(rs.getString("nomeEstacao"));
                C.setDescricao(rs.getString("descricao"));
                C.setAbertoPor(rs.getString("abertoPor"));
                C.setEquipe(rs.getInt("equipe"));
                C.setResponsavel(rs.getInt("responsavel"));
                C.setEstado(rs.getInt("estado"));
                
                listaChamados.add(C);
            }
            
            rs.close();
            
            return listaChamados;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // "Capturar" um chamado
    public static void capturarChamado(int numeroChamado, int codigoUsuario, int codigoEquipe) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            sta.execute("UPDATE chamados SET equipe=" + codigoEquipe + ", responsavel=" + codigoUsuario + " WHERE codigo=" + numeroChamado + ";");
        }catch(SQLException SE){
            throw new SQLException("Erro capturando chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Repassar chamado de equipe/responsável
    public static void encaminharChamado(boolean transfereEquipe, int codigoChamado, int codigoResponsavel) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            if(transfereEquipe){
                sta.execute("UPDATE chamados SET equipe=" + codigoResponsavel + ", responsavel=1 WHERE codigo=" + codigoChamado + ";");
            } else {
                sta.execute("UPDATE chamados SET responsavel=" + codigoResponsavel + " WHERE codigo=" + codigoChamado + ";");
            }
        }catch(SQLException SE){
            throw new SQLException("Erro encaminhando chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Recebe um único chamado
    public static Chamado receberChamado(int codigo) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Chamado> listaChamados = new ArrayList<>();
            Chamado C = new Chamado();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM chamados WHERE codigo=" + codigo + ";");
                
            while(rs.next()){
                C.setCodigo(rs.getInt("codigo"));
                C.setTitulo(rs.getString("titulo"));
                C.setCategoria(rs.getString("categoria"));
                C.setLocalizacao(rs.getString("localizacao"));
                C.setNomeEstacao(rs.getString("nomeEstacao"));
                C.setDescricao(rs.getString("descricao"));
                C.setAbertoPor(rs.getString("abertoPor"));
                C.setEquipe(rs.getInt("equipe"));
                C.setResponsavel(rs.getInt("responsavel"));
                C.setEstado(rs.getInt("estado"));
            }
            
            rs.close();
            
            return C;
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Receber nome responsavel de um chamado
    public static String receberNomeResponsavel(int codigoResponsavel) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            if(codigoResponsavel != 1){
                ResultSet rs = sta.executeQuery("SELECT * FROM usuarios WHERE codigo=" + codigoResponsavel + ";");
                String tmp = "";
                while(rs.next()){
                    tmp = rs.getString("username");
                }
                rs.close();
                
                return tmp;   
            } else {
                return "";
            }
            
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo nome do responsável!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Verifica se um chamado existe no BD
    public static boolean chamadoExiste(int codigo) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            boolean resultado = false;
            
            ResultSet rs = sta.executeQuery("SELECT * FROM chamados WHERE codigo=" + codigo + ";");
            while(rs.next()){
                int tmp = rs.getInt("codigo");
                if(tmp == codigo){
                    resultado = true;
                    break;
                }
            }
            rs.close();
            
            return resultado;
        }catch(SQLException SE){
            throw new SQLException("Erro procurando chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Atualiza o estado de um chamado
    public static void alterarEstadoChamado(int codigo, int estado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            sta.execute("UPDATE chamados SET estado=" + estado + " WHERE codigo=" + codigo + ";");
        }catch(SQLException SE){
            throw new SQLException("Erro alterando estado do chamado!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Recebe nome do responsável de um chamado
    public static String receberNomeResponsavelSelecionavel(int codigoChamado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            String resultado = "";
            
            ResultSet rs = sta.executeQuery("SELECT usuarios.username AS nome FROM usuarios JOIN chamados ON usuarios.codigo = chamados.responsavel WHERE chamados.codigo = " + codigoChamado + ";");
            
            while(rs.next()){
                resultado = rs.getString("nome");
            }
            
            rs.close();
            
            return resultado;
        }catch(SQLException SE){
            throw new SQLException("Erro recebendo nome de responsável!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Busca chamados por um campo
    public static ArrayList<Chamado> pesquisarPorCampo(String campo, String valor, boolean incluirFechados) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Chamado> listaChamados = new ArrayList<>();
            
            ResultSet rs;
            
            if(incluirFechados){
                rs = sta.executeQuery("SELECT * FROM chamados WHERE " + campo + " LIKE '%" + valor + "%' ORDER BY codigo DESC;");
            } else {
                rs = sta.executeQuery("SELECT * FROM chamados WHERE " + campo + " LIKE '%" + valor + "%' AND estado<2 ORDER BY codigo DESC;");
            }
            
            while(rs.next()){
                Chamado C = new Chamado();
                C.setCodigo(rs.getInt("codigo"));
                C.setTitulo(rs.getString("titulo"));
                C.setCategoria(rs.getString("categoria"));
                C.setLocalizacao(rs.getString("localizacao"));
                C.setNomeEstacao(rs.getString("nomeEstacao"));
                C.setDescricao(rs.getString("descricao"));
                C.setAbertoPor(rs.getString("abertoPor"));
                C.setEquipe(rs.getInt("equipe"));
                C.setResponsavel(rs.getInt("responsavel"));
                C.setEstado(rs.getInt("estado"));
                
                listaChamados.add(C);
            }
            
            rs.close();
            
            return listaChamados;
            
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Busca chamados por um registro
    public static ArrayList<Chamado> pesquisarPorRegistro(String registro, boolean incluirFechados) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Chamado> listaChamados = new ArrayList<>();
            
            ResultSet rs;
            
            if(incluirFechados){
                rs = sta.executeQuery("SELECT DISTINCT C.codigo,C.titulo,C.categoria,C.localizacao,C.nomeEstacao,C.descricao,C.abertoPor,C.equipe,C.responsavel,C.estado FROM chamados C JOIN registros R WHERE C.codigo=R.codigoChamado AND R.registro LIKE '%" + registro + "%' ORDER BY C.codigo DESC;");
            } else {
                rs = sta.executeQuery("SELECT DISTINCT C.codigo,C.titulo,C.categoria,C.localizacao,C.nomeEstacao,C.descricao,C.abertoPor,C.equipe,C.responsavel,C.estado FROM chamados C JOIN registros R WHERE C.codigo=R.codigoChamado AND R.registro LIKE '%" + registro + "%' AND C.estado<2 ORDER BY C.codigo DESC;");
            }
            
            while(rs.next()){
                Chamado C = new Chamado();
                C.setCodigo(rs.getInt("codigo"));
                C.setTitulo(rs.getString("titulo"));
                C.setCategoria(rs.getString("categoria"));
                C.setLocalizacao(rs.getString("localizacao"));
                C.setNomeEstacao(rs.getString("nomeEstacao"));
                C.setDescricao(rs.getString("descricao"));
                C.setAbertoPor(rs.getString("abertoPor"));
                C.setEquipe(rs.getInt("equipe"));
                C.setResponsavel(rs.getInt("responsavel"));
                C.setEstado(rs.getInt("estado"));
                
                listaChamados.add(C);
            }
            
            rs.close();
            
            return listaChamados;
            
        } catch (SQLException SE) {
            throw new SQLException("Erro recebendo chamados!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    /**
     * ------------
     * | Métodos relacionados a registros dos chamados
     * ------------
     */
    
    // Realiza novo registro em um chamado
    public static void criarNovoRegistro(String autor, String data, String horario, String registro, int codigoChamado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            sta.execute("INSERT INTO registros(autor,data,horario,registro,codigoChamado) VALUES ('" + autor + "','" + data + "','" + horario + "','" + registro + "'," + codigoChamado + ");");
        } catch (SQLException SE) {
            throw new SQLException("Erro criando registro!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Receber lista de registros
    public static ArrayList<Registro> receberRegistros(int codigoChamado) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try {
            ArrayList<Registro> listaRegistros = new ArrayList<>();
            
            ResultSet rs = sta.executeQuery("SELECT * FROM registros WHERE codigoChamado=" + codigoChamado + ";");
            while(rs.next()){
                Registro R = new Registro();
                R.setCodigoRegistro(rs.getInt("codigoRegistro"));
                R.setAutor(rs.getString("autor"));
                R.setData(rs.getString("data"));
                R.setHorario(rs.getString("horario"));
                R.setRegistro(rs.getString("registro"));
                
                listaRegistros.add(R);
            }
            
            rs.close();
            
            return listaRegistros;
            
        } catch (SQLException SE) {
            throw new SQLException("Erro criando registro!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Editar dados do chamado
    public static void editarRegistro(int codigoRegistro, String data, String horario, String registro) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            sta.execute("UPDATE registros SET data='" + data + "', horario='" + horario + "', registro='" + registro + "' WHERE codigoRegistro=" + codigoRegistro + ";");
        }catch(SQLException SE){
            throw new SQLException("Erro editando dados do chamado!\nCausa: " + SE.getMessage());
        }finally{
            sta.close();
            conectado.close();
        }
    }
    
    // Receber código de um usuário por nome
    public static int receberCodigoUsuarioPorNome(String nome) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            int resultado = 0;
            
            ResultSet rs = sta.executeQuery("SELECT codigo FROM usuarios WHERE username='" + nome + "';");
            while(rs.next()){
                resultado = rs.getInt("codigo");
            }
            
            rs.close();
            
            return resultado;
        }catch(SQLException SE){
            throw new SQLException("Erro recebendo código do usuário!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
    
    // Retorna número do chamado aberto anteriormente
    public static int receberNumeroChamado(String descricao, String nomeEstacao, String titulo) throws SQLException{
        Connection conectado = Conexao.conecta();
        Statement sta = conectado.createStatement();
        
        try{
            int resultado = 0;
            
            ResultSet rs = sta.executeQuery("SELECT codigo FROM chamados WHERE descricao='" + descricao + "' AND nomeEstacao='" + nomeEstacao + "' AND titulo='" + titulo + "';");
            while(rs.next()){
                resultado = rs.getInt("codigo");
            }
            
            return resultado;
        }catch(SQLException SE){
            throw new SQLException("Erro recebendo código do usuário!\nCausa: " + SE.getMessage());
        } finally {
            sta.close();
            conectado.close();
        }
    }
}
