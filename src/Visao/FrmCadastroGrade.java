/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Bean.CrudGradeMB;
import Modelo.Grade;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class FrmCadastroGrade extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCadastroPessoa
     */
    private CrudGradeMB bean = new CrudGradeMB();
    private CrudGrade frmGrade = new CrudGrade();
    
    private Integer idGrade;
    
    public FrmCadastroGrade() {
        initComponents();
        
    }
    
    void setPagina(CrudGrade formPai) {
        frmGrade = formPai;
    }
    
    void alterar(int id) {
        Grade g = new Grade();
        idGrade = id;
        
        g = bean.getById(idGrade);
        
        this.NomeGradeTextField.setText(g.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        NomeGradeTextField = new javax.swing.JTextField();
        BtnGravar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel6.setText("Nome da Grade:");

        NomeGradeTextField.setColumns(15);

        BtnGravar.setText("Gravar");
        BtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGravarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGravar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeGradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(NomeGradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGravarActionPerformed
        // TODO add your handling code here:
        
        if(idGrade == null){
            Grade g = new Grade();
            
            g.setNome(this.NomeGradeTextField.getText());
            
            if(bean.insert(g) != -1){
                JOptionPane.showMessageDialog(this, "Grade inserido com sucesso!", "", WIDTH);
                this.setVisible(false);
                frmGrade.atualizaTabela();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao inserir a Grade!", "", WIDTH);
            }
        }else{
            Grade g = new Grade();
            
            g.setIdGrade(idGrade);
            g.setNome(this.NomeGradeTextField.getText());
            
            if(bean.update(g) != -1){
                JOptionPane.showMessageDialog(this, "Grade alterada com sucesso!", "", WIDTH);
                this.setVisible(false);
                frmGrade.atualizaTabela();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao alterar a Grade!", "", WIDTH);
            }
        }
    }//GEN-LAST:event_BtnGravarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGravar;
    private javax.swing.JTextField NomeGradeTextField;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
