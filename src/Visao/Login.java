/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Bean.LoginMB;
import DTO.PessoaCompletaDTO;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class Login extends javax.swing.JDialog {
    private Principal telaPai = new Principal();
    private LoginMB bean = new LoginMB();
    /**
     * Creates new form Login
     * @param parent
     * @param modal
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    void setPai(Principal pai) {
        telaPai = pai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AcessarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SenhaPasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Golden Semijoias");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        AcessarButton.setText("Acessar");
        AcessarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcessarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        IDTextField.setText("1");
        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Senha:");

        SenhaPasswordField.setText("admin");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AcessarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDTextField)
                            .addComponent(SenhaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SenhaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcessarButton)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AcessarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcessarButtonActionPerformed
        // TODO add your handling code here:
        if(SenhaPasswordField.getPassword().equals("") || IDTextField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Login/Senha Invalidos", "Erro", WIDTH);
        }else{
            PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
            
            if(bean.login(IDTextField, SenhaPasswordField) == null){
                JOptionPane.showMessageDialog(this, "Usuario invalido", "Erro", WIDTH);
            }else{
                pessoaCompletaDTO = bean.login(IDTextField, SenhaPasswordField);
                
                if(pessoaCompletaDTO.getTipoPessoa().equals("2")){
                    JOptionPane.showMessageDialog(this, "O usuario não pode ser um cliente", "Erro", WIDTH);
                    return;
                }else{
                    if(pessoaCompletaDTO != null){
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(this, "Login/Senha Errado", "Erro", WIDTH);
                    }
                }
            }
        }
    }//GEN-LAST:event_AcessarButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcessarButton;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JPasswordField SenhaPasswordField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables


}
