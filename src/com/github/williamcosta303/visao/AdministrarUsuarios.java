package com.github.williamcosta303.visao;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.github.williamcosta303.controle.ControleBanco;
import com.github.williamcosta303.modelo.Login;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdministrarUsuarios extends javax.swing.JInternalFrame {

    int privilegio, bkpCodigoEquipe;
    
    public AdministrarUsuarios() {
        initComponents();
        
        // Inicia com usuário selecionado e desabilita escolha de equipe
        this.cCadastroPrivUsuario.setSelected(true);
        this.cCadastroEquipe.setSelectedIndex(0);
        this.cCadastroEquipe.setEnabled(false);
        
        // Seta senha padrão de acordo com o ano
        this.cCadastroSenhaPadrao.setText("hcpa" + this.receberAno());
        
        // Desativa os campos de alteração
        this.setEnabledCamposAlteracao(false, false);
        
        // Recebe equipes para as caixas de seleção
        try{
            ControleBanco CB = new ControleBanco();
            for(int i = 1; i < CB.receberEquipes().size(); i++){
                this.cCadastroEquipe.addItem(CB.receberEquipes().get(i).getNome());
                this.cAlteracaoEquipe.addItem(CB.receberEquipes().get(i).getNome());
            }
        }catch(SQLException SE){
            JOptionPane.showMessageDialog(this, "Erro com banco de dados!\nCausa: " + SE.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gCadastroPrivilegio = new javax.swing.ButtonGroup();
        gAlteracaoPrivilegio = new javax.swing.ButtonGroup();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cCadastroNomeUsuario = new javax.swing.JTextField();
        cCadastroSenhaPadrao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cCadastroPrivUsuario = new javax.swing.JRadioButton();
        cCadastroPrivSuporte = new javax.swing.JRadioButton();
        cCadastroPrivAdm = new javax.swing.JRadioButton();
        cCadastroEquipe = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cAlteracaoUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cAlteracaoCodigo = new javax.swing.JTextField();
        cAlteracaoNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cAlteracaoSenha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cAlteracaoPrivUsuario = new javax.swing.JRadioButton();
        cAlteracaoPrivSuporte = new javax.swing.JRadioButton();
        cAlteracaoPrivAdmin = new javax.swing.JRadioButton();
        cAlteracaoEquipe = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bAlteracaoAlterar = new javax.swing.JButton();
        bAlteracaoCancelar = new javax.swing.JButton();
        bAlteracaoBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administração de usuários");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome de usuário");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha padrão");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Privilégio");

        gCadastroPrivilegio.add(cCadastroPrivUsuario);
        cCadastroPrivUsuario.setText("Usuário");
        cCadastroPrivUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCadastroPrivUsuarioActionPerformed(evt);
            }
        });

        gCadastroPrivilegio.add(cCadastroPrivSuporte);
        cCadastroPrivSuporte.setText("Suporte");
        cCadastroPrivSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCadastroPrivSuporteActionPerformed(evt);
            }
        });

        gCadastroPrivilegio.add(cCadastroPrivAdm);
        cCadastroPrivAdm.setText("Administrador");
        cCadastroPrivAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCadastroPrivAdmActionPerformed(evt);
            }
        });

        cCadastroEquipe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Equipe");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cCadastroNomeUsuario)
                            .addComponent(cCadastroSenhaPadrao)
                            .addComponent(cCadastroPrivUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cCadastroPrivSuporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cCadastroPrivAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cCadastroEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cCadastroNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cCadastroSenhaPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cCadastroPrivUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCadastroPrivSuporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCadastroPrivAdm))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cCadastroEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bCadastrar)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        abas.addTab("Cadastro", jPanel1);

        jLabel5.setText("Usuário");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edição de usuário"));

        jLabel6.setText("Código");

        cAlteracaoCodigo.setEditable(false);

        jLabel7.setText("Nome");

        jLabel8.setText("Senha");

        jLabel9.setText("Privilégio");

        gAlteracaoPrivilegio.add(cAlteracaoPrivUsuario);
        cAlteracaoPrivUsuario.setText("Usuário");
        cAlteracaoPrivUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlteracaoPrivUsuarioActionPerformed(evt);
            }
        });

        gAlteracaoPrivilegio.add(cAlteracaoPrivSuporte);
        cAlteracaoPrivSuporte.setText("Suporte");
        cAlteracaoPrivSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlteracaoPrivSuporteActionPerformed(evt);
            }
        });

        gAlteracaoPrivilegio.add(cAlteracaoPrivAdmin);
        cAlteracaoPrivAdmin.setText("Administrador");
        cAlteracaoPrivAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlteracaoPrivAdminActionPerformed(evt);
            }
        });

        cAlteracaoEquipe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---" }));

        jLabel10.setText("Equipe");

        bAlteracaoAlterar.setText("Alterar");
        bAlteracaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlteracaoAlterarActionPerformed(evt);
            }
        });

        bAlteracaoCancelar.setText("Cancelar");
        bAlteracaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlteracaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAlteracaoAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAlteracaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAlteracaoAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAlteracaoCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cAlteracaoEquipe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cAlteracaoNome)
                    .addComponent(cAlteracaoCodigo)
                    .addComponent(cAlteracaoSenha)
                    .addComponent(cAlteracaoPrivUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cAlteracaoPrivSuporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cAlteracaoPrivAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cAlteracaoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAlteracaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAlteracaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cAlteracaoPrivUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAlteracaoPrivSuporte)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cAlteracaoPrivAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAlteracaoEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bAlteracaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/github/williamcosta303/imagens/pesquisar-16.png"))); // NOI18N
        bAlteracaoBuscar.setText("Buscar");
        bAlteracaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlteracaoBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cAlteracaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAlteracaoBuscar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAlteracaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bAlteracaoBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        abas.addTab("Alteração", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cCadastroPrivUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCadastroPrivUsuarioActionPerformed
        this.cCadastroEquipe.setSelectedIndex(0);
        this.cCadastroEquipe.setEnabled(false);
    }//GEN-LAST:event_cCadastroPrivUsuarioActionPerformed

    private void cCadastroPrivSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCadastroPrivSuporteActionPerformed
        if(!this.cCadastroEquipe.isEnabled()){
            this.cCadastroEquipe.setSelectedIndex(0);
            this.cCadastroEquipe.setEnabled(true);
        }
    }//GEN-LAST:event_cCadastroPrivSuporteActionPerformed

    private void cCadastroPrivAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCadastroPrivAdmActionPerformed
        if(!this.cCadastroEquipe.isEnabled()){
            this.cCadastroEquipe.setSelectedIndex(0);
            this.cCadastroEquipe.setEnabled(true);
        }
    }//GEN-LAST:event_cCadastroPrivAdmActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        try{
            if(!this.cCadastroEquipe.isEnabled()){
                // Cadastrar usuário comum
                if(this.cCadastroNomeUsuario.getText().length() > 0 && this.cCadastroNomeUsuario.getText().length() <= 30){
                    if(this.cCadastroSenhaPadrao.getText().length() > 0 && this.cCadastroSenhaPadrao.getText().length() <= 30){
                        ControleBanco CB = new ControleBanco();
                        Login L = new Login();
                        L.setNome(this.cCadastroNomeUsuario.getText());
                        L.setSenha(this.cCadastroSenhaPadrao.getText());
                        L.setCodigoEquipe(1);
                        L.setPrivilegio(0);
                        
                        CB.cadastrarLogin(L);
                        
                        JOptionPane.showMessageDialog(this, "O usuário '" + this.cCadastroNomeUsuario.getText() + "' foi cadastrado no sistema!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Senha possui quantidade de caracteres inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nome de usuário possui quantidade de caracteres inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }


            } else {
                // Cadastrar um suporte/administrador
                //JOptionPane.showMessageDialog(this, "Não está pronto!", "NOPE.AVI", JOptionPane.INFORMATION_MESSAGE);
                if(this.cCadastroNomeUsuario.getText().length() > 0 && this.cCadastroNomeUsuario.getText().length() <= 30){
                    if(this.cCadastroSenhaPadrao.getText().length() > 0 && this.cCadastroSenhaPadrao.getText().length() <= 30){
                        if(this.cCadastroEquipe.getSelectedIndex() > 0){
                            ControleBanco CB = new ControleBanco();
                            Login L = new Login();
                            L.setNome(this.cCadastroNomeUsuario.getText());
                            L.setSenha(this.cCadastroSenhaPadrao.getText());
                            L.setCodigoEquipe(this.cCadastroEquipe.getSelectedIndex()+1);
                            if(this.cCadastroPrivSuporte.isSelected()){
                                L.setPrivilegio(1);
                            } else {
                                L.setPrivilegio(2);
                            }

                            CB.cadastrarLogin(L);
                            
                            JOptionPane.showMessageDialog(this, "O usuário '" + this.cCadastroNomeUsuario.getText() + "' foi cadastrado no sistema!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            // Limpar campos após cadastro
                            this.limparCamposCadastro();

                        } else {
                            JOptionPane.showMessageDialog(this, "É necessário escolher uma equipe para o usuário!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Senha possui quantidade de caracteres inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nome de usuário possui quantidade de caracteres inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        } catch (SQLException SE){
            JOptionPane.showMessageDialog(this, "Erro com Banco de Dados!\nCausa: " + SE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bAlteracaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlteracaoBuscarActionPerformed
        try {
            // Busca o usuário pesquisado no banco
            Login usuarioAlterado = new ControleBanco().buscarUsuario(this.cAlteracaoUsuario.getText());
            
            // Libera os campos para edição e tranca os de busca
            this.setEnabledCamposAlteracao(false, true);
            this.setEnabledCamposAlteracao(true, false);
            
            // Edita no programa os valores recebidos do banco
            this.cAlteracaoCodigo.setText(Integer.toString(usuarioAlterado.getCodigo()));
            this.cAlteracaoEquipe.setSelectedIndex(usuarioAlterado.getCodigoEquipe()-1);
            this.cAlteracaoNome.setText(usuarioAlterado.getNome());
            this.cAlteracaoSenha.setText("(inalterada)");
            if(usuarioAlterado.getPrivilegio() == 2) {
                this.cAlteracaoPrivAdmin.setSelected(true);
            } else if (usuarioAlterado.getPrivilegio() == 1){
                this.cAlteracaoPrivSuporte.setSelected(true);
            } else {
                this.cAlteracaoPrivUsuario.setSelected(true);
                this.cAlteracaoEquipe.setEnabled(false);
            }
            
            // Seta o valor da equipe em uma variável de backup
            this.bkpCodigoEquipe = usuarioAlterado.getCodigoEquipe()-1;
            
            
        } catch (SQLException SE) {
            JOptionPane.showMessageDialog(this, "Erro com Banco de Dados!\nCausa: " + SE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception E){
            JOptionPane.showMessageDialog(this, "Usuário não encontrado!\nTente digitar novamnete!", "Usuário não encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bAlteracaoBuscarActionPerformed

    private void bAlteracaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlteracaoAlterarActionPerformed
        try{
            // Instancia uma classe Login para receber os dados informados
            Login usuarioAAlterar = new Login();
            
            // Recebe os dados informados pelo usuário
            usuarioAAlterar.setCodigo(Integer.parseInt(this.cAlteracaoCodigo.getText()));
            usuarioAAlterar.setCodigoEquipe(this.cAlteracaoEquipe.getSelectedIndex()+1);
            usuarioAAlterar.setNome(this.cAlteracaoNome.getText());
            if(this.cAlteracaoPrivAdmin.isSelected()){
                usuarioAAlterar.setPrivilegio(2);
            } else if (this.cAlteracaoPrivSuporte.isSelected()){
                usuarioAAlterar.setPrivilegio(1);
            } else {
                usuarioAAlterar.setPrivilegio(0);
            }
            usuarioAAlterar.setSenha(this.cAlteracaoSenha.getText());
            
            // Instancia um objeto para realizar contato com banco
            ControleBanco CB = new ControleBanco();
            // Atualiza o cadastro no banco
            CB.atualizarCadastro(usuarioAAlterar, false);
            // Mensagem de confirmação para o usuário
            JOptionPane.showMessageDialog(this, "Usuário alterado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpa os campos
            this.limparCamposAlteracao();
            // Reabilita o campo de procura e desabilita os campos de alteração
            this.setEnabledCamposAlteracao(true, true);
            this.setEnabledCamposAlteracao(false, false);
        }catch(SQLException SE){
            JOptionPane.showMessageDialog(this, "Erro com Banco de Dados!\nCausa: " + SE.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bAlteracaoAlterarActionPerformed

    private void bAlteracaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlteracaoCancelarActionPerformed
        // Pede confirmação para cancelar a atividade
        int confirma = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar a alteração?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            // Caso "SIM"
            
            // Limpa os campos
            this.limparCamposAlteracao();
            // Reabilita o campo de procura e desabilita os campos de alteração
            this.setEnabledCamposAlteracao(true, true);
            this.setEnabledCamposAlteracao(false, false);
        }
    }//GEN-LAST:event_bAlteracaoCancelarActionPerformed

    private void cAlteracaoPrivUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlteracaoPrivUsuarioActionPerformed
        this.cAlteracaoEquipe.setSelectedIndex(0);
        this.cAlteracaoEquipe.setEnabled(false);
    }//GEN-LAST:event_cAlteracaoPrivUsuarioActionPerformed

    private void cAlteracaoPrivSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlteracaoPrivSuporteActionPerformed
        if(!this.cAlteracaoEquipe.isEnabled()){
            this.cAlteracaoEquipe.setSelectedIndex(this.bkpCodigoEquipe);
            this.cAlteracaoEquipe.setEnabled(true);
        }
    }//GEN-LAST:event_cAlteracaoPrivSuporteActionPerformed

    private void cAlteracaoPrivAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlteracaoPrivAdminActionPerformed
        if(!this.cAlteracaoEquipe.isEnabled()){
            this.cAlteracaoEquipe.setSelectedIndex(this.bkpCodigoEquipe);
            this.cAlteracaoEquipe.setEnabled(true);
        }
    }//GEN-LAST:event_cAlteracaoPrivAdminActionPerformed

    private String receberAno(){
        return new SimpleDateFormat("yyyy").format(new Date());
    }
    
    private void limparCamposCadastro(){
        this.cCadastroNomeUsuario.setText("");
        this.cCadastroSenhaPadrao.setText("hcpa" + this.receberAno());
        this.cCadastroPrivUsuario.setSelected(true);
        this.cCadastroEquipe.setSelectedIndex(0);
        this.cCadastroEquipe.setEnabled(false);
    }
    
    private void setEnabledCamposAlteracao(boolean isCampoBusca, boolean isAtivado){
        if(isCampoBusca){
            this.cAlteracaoUsuario.setEnabled(isAtivado);
            this.bAlteracaoBuscar.setEnabled(isAtivado);
        } else {
            this.cAlteracaoCodigo.setEnabled(isAtivado);
            this.cAlteracaoEquipe.setEnabled(isAtivado);
            this.cAlteracaoNome.setEnabled(isAtivado);
            this.cAlteracaoPrivAdmin.setEnabled(isAtivado);
            this.cAlteracaoPrivSuporte.setEnabled(isAtivado);
            this.cAlteracaoPrivUsuario.setEnabled(isAtivado);
            this.cAlteracaoSenha.setEnabled(isAtivado);
            this.bAlteracaoAlterar.setEnabled(isAtivado);
            this.bAlteracaoCancelar.setEnabled(isAtivado);
        }
    }
    
    private void limparCamposAlteracao(){
        this.cAlteracaoCodigo.setText("");
        this.cAlteracaoEquipe.setSelectedIndex(0);
        this.cAlteracaoNome.setText("");
        this.cAlteracaoSenha.setText("");
        this.cAlteracaoUsuario.setText("");
        this.gAlteracaoPrivilegio.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton bAlteracaoAlterar;
    private javax.swing.JButton bAlteracaoBuscar;
    private javax.swing.JButton bAlteracaoCancelar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JTextField cAlteracaoCodigo;
    private javax.swing.JComboBox cAlteracaoEquipe;
    private javax.swing.JTextField cAlteracaoNome;
    private javax.swing.JRadioButton cAlteracaoPrivAdmin;
    private javax.swing.JRadioButton cAlteracaoPrivSuporte;
    private javax.swing.JRadioButton cAlteracaoPrivUsuario;
    private javax.swing.JTextField cAlteracaoSenha;
    private javax.swing.JTextField cAlteracaoUsuario;
    private javax.swing.JComboBox cCadastroEquipe;
    private javax.swing.JTextField cCadastroNomeUsuario;
    private javax.swing.JRadioButton cCadastroPrivAdm;
    private javax.swing.JRadioButton cCadastroPrivSuporte;
    private javax.swing.JRadioButton cCadastroPrivUsuario;
    private javax.swing.JTextField cCadastroSenhaPadrao;
    private javax.swing.ButtonGroup gAlteracaoPrivilegio;
    private javax.swing.ButtonGroup gCadastroPrivilegio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
