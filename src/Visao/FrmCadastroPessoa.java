/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Bean.EnderecoBean;
import Bean.PessoaBean;
import Bean.TelefoneBean;
import DAL.CidadeDAO;
import DAL.EstadoDAO;
import DAL.PaisDAO;
import DTO.PessoaCompletaDTO;
import Modelo.Pessoa;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class FrmCadastroPessoa extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCadastroPessoa
     */
    private PessoaBean bean = new PessoaBean();
    private EnderecoBean beanEnd = new EnderecoBean();
    private TelefoneBean beanTel = new TelefoneBean();
    private CidadeDAO cidDao = new CidadeDAO();
    private EstadoDAO estDao = new EstadoDAO();
    private PaisDAO paisDAO = new PaisDAO();
    private CrudPessoa frmPessoa = new CrudPessoa();
    private Integer idPessoa;
    
    public FrmCadastroPessoa() {
        initComponents();
        bean.CarregaComboBoxPais(PaisComboBox);
        
        SenhaPasswordField.setVisible(false);
        jLabel3.setVisible(false);
    }
    
    void setPagina(CrudPessoa formPai, PessoaBean b) {
        bean = b;
        frmPessoa = formPai;
    }
    
    void alterar(int id) {
        idPessoa = id;
        
        CidadeDAO cidDao = new CidadeDAO();
        EstadoDAO estDao = new EstadoDAO();
        PaisDAO paisDAO = new PaisDAO();
        
        PessoaCompletaDTO pessoaAlterar =  bean.alteraPessoa(id);
        
        this.TipoPessoaComboBox.setSelectedItem(bean);
        this.NomeTextField.setText(pessoaAlterar.getNome());
        this.SenhaPasswordField.setText(pessoaAlterar.getSenha());
        this.CpfTextField.setText(pessoaAlterar.getCpf());
        
        switch(pessoaAlterar.getTipoPessoa()){
            case "1":
                this.TipoPessoaComboBox.setSelectedItem("Vendedor");
            break;

            case "2":
                this.TipoPessoaComboBox.setSelectedItem("Cliente");
            break;

            default:
                JOptionPane.showMessageDialog(this, "Selecione Um Tipo de Pessoa", "", WIDTH);
            break;
        }
        
        this.PaisComboBox.setSelectedItem(paisDAO.getNameById(pessoaAlterar.getIdPais()));
        
        bean.CarregaComboBoxEstado(this.EstadoComboBox, this.PaisComboBox.getSelectedItem().toString());
        
        this.EstadoComboBox.setSelectedItem(estDao.getNameById(pessoaAlterar.getIdEstado()));
        
        bean.CarregaComboBoxCidade(this.CidadeComboBox, this.EstadoComboBox.getSelectedItem().toString());
        
        this.CidadeComboBox.setSelectedItem(cidDao.getNameById(pessoaAlterar.getIdCidade()));
        
        this.CEPTextField.setText(pessoaAlterar.getCep());
        this.EnderecoTextField.setText(pessoaAlterar.getRua());
        this.NumeroTextField.setText(pessoaAlterar.getNumero());
        this.TelefoneTextField.setText(pessoaAlterar.getTelefone());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NomeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CpfTextField = new javax.swing.JTextField();
        PaisComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        EstadoComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EnderecoTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        NumeroTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TelefoneTextField = new javax.swing.JTextField();
        BtnGravar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CEPTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SenhaPasswordField = new javax.swing.JPasswordField();
        CidadeComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        TipoPessoaComboBox = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Cadastro de Pessoa");

        jLabel1.setText("Nome:");

        NomeTextField.setColumns(15);

        jLabel2.setText("CPF:");

        CpfTextField.setColumns(15);

        PaisComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PaisComboBoxItemStateChanged(evt);
            }
        });
        PaisComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaisComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado:");

        EstadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selec. Estado" }));
        EstadoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EstadoComboBoxItemStateChanged(evt);
            }
        });

        jLabel5.setText("Cidade:");

        jLabel9.setText("Endereço:");

        EnderecoTextField.setColumns(15);

        jLabel10.setText("Nº:");

        NumeroTextField.setColumns(3);

        jLabel6.setText("Telefone:");

        TelefoneTextField.setColumns(15);

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

        jLabel7.setText("CEP:");

        CEPTextField.setColumns(10);

        jLabel8.setText("Pais:");

        jLabel3.setText("Senha:");

        CidadeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selec. Cidade" }));
        CidadeComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CidadeComboBoxMousePressed(evt);
            }
        });
        CidadeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CidadeComboBoxActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo Pessoa:");

        TipoPessoaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selec. Tipo Pessoa", "Vendedor", "Cliente" }));
        TipoPessoaComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoPessoaComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TelefoneTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(NomeTextField)
                                                .addComponent(CpfTextField))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(PaisComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CidadeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(10, 10, 10)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(EnderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NumeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EstadoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CEPTextField)
                                .addComponent(SenhaPasswordField)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtnGravar)))
                    .addComponent(TipoPessoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(TipoPessoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SenhaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(EstadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(CidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CEPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(EnderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(NumeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TelefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGravarActionPerformed
        // TODO add your handling code here:
        ArrayList<Pessoa> arrayPessoa = bean.getAllAtivo();
        
        if(idPessoa == null){
            PessoaCompletaDTO pessoaAlterar = new PessoaCompletaDTO();
            int tamanhoDaLista;
            String tipoPessoa;
            
            tipoPessoa = TipoPessoaComboBox.getSelectedItem().toString();
            
            switch(tipoPessoa){
                case "Vendedor":
                    pessoaAlterar.setTipoPessoa("1");
                break;

                case "Cliente":
                    pessoaAlterar.setTipoPessoa("2");
                break;

                default:
                    JOptionPane.showMessageDialog(this, "Selecione um tipo de pessoa", "", WIDTH);
                break;
            }
            
            pessoaAlterar.setNome(NomeTextField.getText());
            pessoaAlterar.setCpf(CpfTextField.getText());
            pessoaAlterar.setSenha(SenhaPasswordField.getText());
            
            pessoaAlterar.setCep(CEPTextField.getText());
            pessoaAlterar.setRua(EnderecoTextField.getText());
            pessoaAlterar.setNumero(NumeroTextField.getText());
            
            if(tipoPessoa.equals("Selec. Tipo Pessoa")){
                return;
            }
            if(pessoaAlterar.getCpf() == null || pessoaAlterar.getCpf().equals("")){
                JOptionPane.showMessageDialog(this, "Campo CPF: É Obrigatorio!", "erro", WIDTH);
                return;
            }
            
            for(tamanhoDaLista = arrayPessoa.size(); tamanhoDaLista != 0 ; tamanhoDaLista--){
                if(arrayPessoa.get(tamanhoDaLista-1).getCpfCnpj().equals(pessoaAlterar.getCpf())){
                    JOptionPane.showMessageDialog(this, "CPF Já Existe!", "erro", WIDTH);
                    return;
                }
            }
            
            if(pessoaAlterar.getRua()== null || pessoaAlterar.getRua().equals("")){
                JOptionPane.showMessageDialog(this, "Campo Endereço: É Obrigatorio!", "erro", WIDTH);
                return;
            }
            
            if(pessoaAlterar.getCep()== null || pessoaAlterar.getCep().equals("")){
                JOptionPane.showMessageDialog(this, "Campo CEP: É Obrigatorio!", "erro", WIDTH);
                return;
            }
            
            if(pessoaAlterar.getNumero() == null || pessoaAlterar.getNumero().equals("")){
                JOptionPane.showMessageDialog(this, "Campo Numero: É Obrigatorio!", "erro", WIDTH);
                return;
            }
            
            pessoaAlterar.setIdCidade(beanEnd.pegaIdCidade(CidadeComboBox.getSelectedItem().toString()));
            
            if(pessoaAlterar.getIdCidade() == null){
                JOptionPane.showMessageDialog(this, "Selecione a cidade!", "erro", WIDTH);
                return;
            }
            
            pessoaAlterar.setIdEndereco(beanEnd.gravarEndereco(pessoaAlterar, pessoaAlterar.getIdCidade()));
            
            pessoaAlterar.setIdPessoa(bean.insert(pessoaAlterar));
            
            pessoaAlterar.setTelefone(TelefoneTextField.getText());
            
            if(pessoaAlterar.getTelefone() == null || pessoaAlterar.getTelefone().equals("")){
                JOptionPane.showMessageDialog(this, "Campo Telefone: É Obrigatorio!", "erro", WIDTH);
                return;
            }
            
            beanTel.gravarTelefone(pessoaAlterar);
            
            /*telefone.setNumero(TelefoneTextField.getText());
            telefone.setIdPessoa(pessoaGravar);*/
            
            if(pessoaAlterar.getIdPessoa() != -1){
                JOptionPane.showMessageDialog(this, "Cliente inserido com sucesso!", "", WIDTH);
                this.setVisible(false);
                frmPessoa.atualizaTabela();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao inserir o cliente!", "", WIDTH);
            }
            
        }else{
            PessoaCompletaDTO pessoaAlterar = new PessoaCompletaDTO();
            String tipoPessoa;
            
            tipoPessoa = TipoPessoaComboBox.getSelectedItem().toString();
            
            pessoaAlterar.setIdPessoa(idPessoa);
            pessoaAlterar.setNome(NomeTextField.getText());
            pessoaAlterar.setCpf(CpfTextField.getText());
            pessoaAlterar.setSenha(SenhaPasswordField.getText());
            
            switch(tipoPessoa){
                case "Vendedor":
                    pessoaAlterar.setTipoPessoa("1");
                break;

                case "Cliente":
                    pessoaAlterar.setTipoPessoa("2");
                break;

                default:
                    JOptionPane.showMessageDialog(this, "Selecione Um Tipo de Pessoa", "", WIDTH);
                break;
            }
            
            pessoaAlterar.setIdCidade(cidDao.getIdByName(CidadeComboBox.getSelectedItem().toString()));
            
            pessoaAlterar.setCep(CEPTextField.getText());
            pessoaAlterar.setRua(EnderecoTextField.getText());
            pessoaAlterar.setNumero(NumeroTextField.getText());
            pessoaAlterar.setTelefone(TelefoneTextField.getText());
            
            if(bean.alterarPessoa(pessoaAlterar) == 1){
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!", "", WIDTH);
                this.setVisible(false);
                frmPessoa.atualizaTabela();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao alterar o cliente!", "", WIDTH);
            }
        }
    }//GEN-LAST:event_BtnGravarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void PaisComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PaisComboBoxItemStateChanged
        // TODO add your handling code here:
         if(!PaisComboBox.getSelectedItem().toString().equals("Selec. Pais")){
            bean.CarregaComboBoxEstado(EstadoComboBox, PaisComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_PaisComboBoxItemStateChanged

    private void CidadeComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CidadeComboBoxMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CidadeComboBoxMousePressed

    
    private void TipoPessoaComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoPessoaComboBoxItemStateChanged
        // TODO add your handling code here:
        if(TipoPessoaComboBox.getSelectedItem().toString().equals("Vendedor")){
            SenhaPasswordField.setVisible(true);
            jLabel3.setVisible(true);
            SenhaPasswordField.setText(null);
        }else{
            SenhaPasswordField.setVisible(false);
            jLabel3.setVisible(false);
            SenhaPasswordField.setText(null);
        }
    }//GEN-LAST:event_TipoPessoaComboBoxItemStateChanged

    private void CidadeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CidadeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CidadeComboBoxActionPerformed

    private void PaisComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaisComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaisComboBoxActionPerformed

    private void EstadoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EstadoComboBoxItemStateChanged
        // TODO add your handling code here:
        if(EstadoComboBox.getSelectedItem() == null) return;
        if(!EstadoComboBox.getSelectedItem().toString().equals("Selec. Estado")){
           bean.CarregaComboBoxCidade(CidadeComboBox, EstadoComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_EstadoComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGravar;
    private javax.swing.JTextField CEPTextField;
    private javax.swing.JComboBox CidadeComboBox;
    private javax.swing.JTextField CpfTextField;
    private javax.swing.JTextField EnderecoTextField;
    private javax.swing.JComboBox EstadoComboBox;
    private javax.swing.JTextField NomeTextField;
    private javax.swing.JTextField NumeroTextField;
    private javax.swing.JComboBox PaisComboBox;
    private javax.swing.JPasswordField SenhaPasswordField;
    private javax.swing.JTextField TelefoneTextField;
    private javax.swing.JComboBox TipoPessoaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
