package telas;

import controles.BairroControle;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Bairro;
import ferramentas.*;
/**
 *
 * @author Cleber Kreutz
 */
public class CadBairros extends javax.swing.JFrame {

    /**
     * Creates new form CadBairros
     */
    Bairro objBairro;
    BairroControle objBairroControle;
    
    public CadBairros() {
        initComponents(); //renderiza os elementos na tela
        
        limparTela();
    }
    
    private void atualizarTabela(){
        try{
            
            objBairroControle = new BairroControle(null, jtbBairros);
            objBairroControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
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

        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBairros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jtbBairros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbBairros.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jtbBairrosAncestorRemoved(evt);
            }
        });
        jtbBairros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbBairrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBairros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 450, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Campos com * são obrigatórios");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro de Bairros");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;
            //validar os campos
            if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro corretamente", 'a');
                return;
            }

            objBairro = new Bairro();
            objBairro.setNome(txtNome.getText().trim());
            if(!lblId.getText().equals("ID")){
                objBairro.setId(Integer.parseInt(lblId.getText()));
                objBairroControle = new BairroControle(objBairro, null);
                retorno = objBairroControle.alterar();
            }else{
                objBairroControle = new BairroControle(objBairro, null);
                retorno = objBairroControle.incluir();
            }
            
            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
            atualizarTabela();
            limparTela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbBairrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBairrosMousePressed
        try{
            
            int linhaSelecionada = jtbBairros.getSelectedRow();//pega a linha selecionada
            String codigo = jtbBairros.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            if(jtbBairros.isColumnSelected(2)){
                objBairroControle = new BairroControle(null, null);
                objBairro = objBairroControle.buscar(codigo);
                if (objBairro != null && objBairro.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                }
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objBairro = new Bairro();
                        objBairro.setId(Integer.parseInt(lblId.getText()));
                        
                        objBairroControle = new BairroControle(objBairro, null);
                        boolean wControle = objBairroControle.excluir();
                        if (wControle){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }
                    limparTela();

                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{
            
                objBairroControle = new BairroControle(null, null);
                objBairro = objBairroControle.buscar(codigo);
                if (objBairro != null && objBairro.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                }
            }
        
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
        
    }//GEN-LAST:event_jtbBairrosMousePressed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//       boolean wControle = Tela_Menu.preencheJanelas("Bairros", "I");
//        if (wControle){
//          CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao ativar menu 'Ordens'");
//        }
//        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jtbBairrosAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtbBairrosAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbBairrosAncestorRemoved

    private void limparTela(){
        try{
            lblId.setText("ID");
            txtNome.setText("");
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   
    
    private void preencherCampos(){
        try{
            lblId.setText(String.valueOf(objBairro.getId()));
            txtNome.setText(objBairro.getNome());
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadBairros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadBairros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbBairros;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
