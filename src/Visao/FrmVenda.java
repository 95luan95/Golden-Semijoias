/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Bean.CrudEstoqueMB;
import Bean.CrudVendaMB;
import DTO.ItemVendaDTO;
import DTO.VendaDTO;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class FrmVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCadastroPessoa
     */
    private CrudVendaMB bean = new CrudVendaMB();
    private CrudVenda crudVenda = new CrudVenda();
    private ItemVendaDTO itemVendaDTO = new ItemVendaDTO();
    private ArrayList<ItemVendaDTO> arrayItemVendaDTO = new ArrayList<>();
    private VendaDTO vendaDTO = new VendaDTO();
    private int idVenda = 0;
    JDesktopPane pai = new JDesktopPane();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private boolean teste = true;
    private Integer idProduto;
    
    public FrmVenda() {
        initComponents();
        atualizaTabela();
    }
    
    void addItemArrayItemVendaDTO(ItemVendaDTO itemVendaDTO){
        if(arrayItemVendaDTO.isEmpty()){
            arrayItemVendaDTO.add(itemVendaDTO);
        }else{
            System.out.println("arrayItemVendaDTO " + arrayItemVendaDTO.size());
            int tamanhoLista;
            
            for(tamanhoLista = arrayItemVendaDTO.size(); tamanhoLista != 0; tamanhoLista--){
                if(arrayItemVendaDTO.get(tamanhoLista-1).getIdEstoque().equals(itemVendaDTO.getIdEstoque())){
                    System.out.println("É igual");
                    arrayItemVendaDTO.get(tamanhoLista-1).setQtdProduto(arrayItemVendaDTO.get(tamanhoLista-1).getQtdProduto()+itemVendaDTO.getQtdProduto());
                    teste = false;
                    return;
                }else{
                    System.out.println("É diferente");
                    teste = true;
                }
            }
            
            if(teste = true){
                arrayItemVendaDTO.add(itemVendaDTO);
            }
        }
    }
    
    public void atualizaTabela() {
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"ID Estoque", "Nome do Produto","Tamanho do Produto", "QTD"});
        
        if(!arrayItemVendaDTO.isEmpty())
        arrayItemVendaDTO.stream().forEach((aiv) -> {
            //System.out.println("aiv." + aiv.getIdEstoque());
            String nomeProduto = bean.getNameProdutoById(bean.getIdProdutoByIdEstoque(aiv.getIdEstoque()));
            
            int tamanhoProduto = bean.getTamanhoById(bean.getIdTamanhoByIdEstoque(aiv.getIdEstoque()));
            
            
            modeloTable.addRow(new Object[] {
                aiv.getIdEstoque(),nomeProduto, tamanhoProduto, aiv.getQtdProduto()
            });
        });
    }
    
    void setPagina(JDesktopPane areaTrabalho, CrudVenda formPai) {
        pai = areaTrabalho;
        crudVenda = formPai;
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
        idClienteTextField = new javax.swing.JTextField();
        BtnGravar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TipoPagamentoComboBox = new javax.swing.JComboBox();
        dataCompraDateChooser = new com.toedter.calendar.JDateChooser();
        vencimentoDateChooser = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Realizar venda");

        jLabel6.setText("Cod Cliente:");

        idClienteTextField.setColumns(15);
        idClienteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteTextFieldActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Tipo de Pagamento:");

        jLabel3.setText("Data da Compra:");

        jLabel4.setText("Data de Vencimento:");

        jLabel5.setText("Itens da Venda:");

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

        jButton1.setText("Buscar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+ Itens");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TipoPagamentoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "À vista", "Cartão" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGravar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton2)
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addComponent(TipoPagamentoComboBox, 0, 126, Short.MAX_VALUE)
                                    .addComponent(dataCompraDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vencimentoDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TipoPagamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dataCompraDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(vencimentoDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnGravar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGravarActionPerformed
        // TODO add your handling code here:
        if(idClienteTextField.getText().equals("") || idClienteTextField.getText() == null){
            JOptionPane.showMessageDialog(this, "Campo Cod Cliente: É Obrigatorio!", "erro", WIDTH);
            return;
        }
        
        if(dataCompraDateChooser.getDate() == null){
            JOptionPane.showMessageDialog(this, "Campo Data da Compra: É Obrigatorio!", "erro", WIDTH);
            return;
        }
        
        if(vencimentoDateChooser.getDate() == null){
            JOptionPane.showMessageDialog(this, "Campo Vencimento: É Obrigatorio!", "erro", WIDTH);
            return;
        }
        if(arrayItemVendaDTO.isEmpty()){
            JOptionPane.showMessageDialog(this, "Adicione um item!", "erro", WIDTH);
            return;
        }
        
        vendaDTO.setIdPessoa(Integer.parseInt(idClienteTextField.getText()));
        vendaDTO.setTipoPagamento(TipoPagamentoComboBox.getSelectedItem().toString());
        vendaDTO.setDataCompra(dataCompraDateChooser.getDate());
        vendaDTO.setVencimento(vencimentoDateChooser.getDate());
        
        idVenda = bean.insert(vendaDTO);
        
        if(idVenda == -1){
            JOptionPane.showMessageDialog(this, "erro ao realizar pedido", "", WIDTH);
            
            arrayItemVendaDTO.stream().forEach((aiv) -> {
                //System.out.println("idVenda " + idVenda);
                if(bean.controlarEstoqueAdd(aiv.getIdEstoque(), aiv.getQtdProduto()) == -1){
                    //System.out.println("Deu Errado");
                }else{
                    //System.out.println("Deu Certo");
                }
            });
            return;
        }
        arrayItemVendaDTO.stream().forEach((aiv) -> {
            //System.out.println("idVenda " + idVenda);
            
            aiv.setIdVenda(idVenda);
            
            //System.out.println("aiv.setIdVenda(idVenda); " + aiv.getIdVenda());
            
            if(bean.insertItemVenda(aiv) == -1){
                JOptionPane.showMessageDialog(this, "Falha ao inserir item da venda", "", WIDTH);
            }
            
            crudVenda.atualizaTabela();
            this.setVisible(false);
        });
    }//GEN-LAST:event_BtnGravarActionPerformed

    void alterar(Integer id) {
        idVenda = id;
        VendaDTO vendaDTO = new VendaDTO();
        
        vendaDTO = bean.getVendaById(id);
        
        idClienteTextField.setText(vendaDTO.getIdPessoa().toString());
        idClienteTextField.enable(false);
        jButton1.setVisible(false);
        
        TipoPagamentoComboBox.setSelectedItem(vendaDTO.getTipoPagamento());
        TipoPagamentoComboBox.setEnabled(false);
        
        dataCompraDateChooser.setDate(vendaDTO.getDataCompra());
        dataCompraDateChooser.disable();
        
        vencimentoDateChooser.setDate(vendaDTO.getVencimento());
        vencimentoDateChooser.disable();
        
        arrayItemVendaDTO = bean.getListaItemByIdVenda(id);
        
        atualizaTabela();
        jTable1.enable(false);
        
        jButton2.setVisible(false);
        BtnGravar.setVisible(false);
        BtnCancelar.setText("Sair");
    }
    
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        arrayItemVendaDTO.stream().forEach((aiv) -> {
            //System.out.println("idVenda " + idVenda);
            if(bean.controlarEstoqueAdd(aiv.getIdEstoque(), aiv.getQtdProduto()) == -1){
                //System.out.println("Deu Errado");
            }else{
                //System.out.println("Deu Certo");
            }
        });
        
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrmSelecionarPessoa frmSelecionarPessoa = new FrmSelecionarPessoa(idClienteTextField);
        pai.add(frmSelecionarPessoa);
        frmSelecionarPessoa.setPagina(pai);
        frmSelecionarPessoa.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CrudEstoque crudEstoque = new CrudEstoque();
        CrudEstoqueMB bean = new CrudEstoqueMB();
        pai.add(crudEstoque);
        
        crudEstoque.setPagina(pai, bean, "V");
        crudEstoque.passaClass(this);
        crudEstoque.setTitle("Selecione o Produto");
        crudEstoque.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idClienteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGravar;
    private javax.swing.JComboBox TipoPagamentoComboBox;
    private com.toedter.calendar.JDateChooser dataCompraDateChooser;
    private javax.swing.JTextField idClienteTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser vencimentoDateChooser;
    // End of variables declaration//GEN-END:variables

}
