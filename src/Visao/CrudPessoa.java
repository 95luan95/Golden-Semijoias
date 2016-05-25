/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Bean.PessoaBean;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class CrudPessoa extends javax.swing.JInternalFrame {
    private PessoaBean bean = new PessoaBean();
    JDesktopPane pai = new JDesktopPane();
    
    public CrudPessoa() {
        initComponents();
        atualizaTabela();
    }
    public void atualizaTabela(){
        bean.atualizaTabela(jTable1);
    }
    void setPagina(JDesktopPane areaTrabalho, PessoaBean bean) {
        pai = areaTrabalho;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnExcluir = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnNovo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Pessoa");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        BtnAlterar.setText("Alterar");
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        BtnNovo.setText("Novo");
        BtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnExcluir)
                    .addComponent(BtnAlterar)
                    .addComponent(BtnNovo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione Uma Pessoa", "", WIDTH);
            return;
        }
        int id = (int)(jTable1.getValueAt(row, 0));
        String nome = (String)(jTable1.getValueAt(row, 1));
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir " + nome +"?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.NO_OPTION){
            
        }else{
            bean.delete(id);
            this.atualizaTabela();
        }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void BtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoActionPerformed
        // TODO add your handling code here:
        FrmCadastroPessoa frmCadastro = new FrmCadastroPessoa();
        frmCadastro.setPagina(this, bean);
        pai.add(frmCadastro);
        frmCadastro.setTitle("Nova Pessoa");
        frmCadastro.setVisible(true);
    }//GEN-LAST:event_BtnNovoActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione Uma Pessoa", "", WIDTH);
            return;
        } 
        
        Integer id = (Integer) jTable1.getValueAt(row, 0);
        
        FrmCadastroPessoa frmCadastro = new FrmCadastroPessoa();
        frmCadastro.setPagina(this, bean);
        
        pai.add(frmCadastro);
        
        frmCadastro.alterar(id);
        frmCadastro.setTitle("Alterar Pessoa");
        frmCadastro.setVisible(true);
    }//GEN-LAST:event_BtnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}