/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.EstoqueDAO;
import DAL.ProdutoDAO;
import DAL.TamanhoDAO;
import DTO.ProdutoDTO;
import DTO.TamanhoDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class CrudEstoqueMB {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private TamanhoDAO tamanhoDAO = new TamanhoDAO();
    private EstoqueDAO estoqueDAO = new EstoqueDAO();
    
    public void atualizaTabela(JTable jTable1) {
        ArrayList<ProdutoDTO> arrayProduto;
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        arrayProduto = produtoDAO.getAll();
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"ID", "Nome"});
        
        arrayProduto.stream().forEach((p) -> {
            modeloTable.addRow(new Object[] {
                p.getIdProduto(), p.getNome()
            });
        });
    }
    
    public void atualizaTabelaQTD(JTable jTable1, int idProduto) {
        ArrayList<TamanhoDTO> arrayTamanho;
        int idGrade = 0;
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        idGrade = produtoDAO.getById(idProduto).getIdGrade();
        arrayTamanho = tamanhoDAO.getAllTamanhoByIdGrade(idGrade);
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"ID", "Tamanho", "QTD"});
        
        arrayTamanho.stream().forEach((p) -> {
            estoqueDAO.getQTD(idProduto, p.getIdTamanho());
            modeloTable.addRow(new Object[] {
                p.getIdTamanho(), p.getTamanho(), estoqueDAO.getQTD(idProduto, p.getIdTamanho())
            });
        });
    }
    
    public int getQTD(int idProduto, int idTamanho){
        return estoqueDAO.getQTD(idProduto, idTamanho);
    }
    
    public int updateItemQTD(int qtd, int idProduto, int idTamanho){
        return estoqueDAO.updateItemQTD(qtd, idProduto, idTamanho);
    }
    
    public int insert(int qtd, int idProduto, int idTamanho){
        return estoqueDAO.insert(qtd, idProduto, idTamanho);
    }
    public int tamanhoExiste(int idTamanho, int idProduto){
        return estoqueDAO.tamanhoExiste(idTamanho, idProduto);
    }

    public int retornaIdEstoque(int id_Produto, int id_tamanho) {
        return estoqueDAO.retornaIdEstoque(id_Produto, id_tamanho);
    }
    
    
}
