/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.GradeDAO;
import DAL.ProdutoDAO;
import DTO.ProdutoDTO;
import Modelo.Grade;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class CrudProdutoMB {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private GradeDAO gradeDAO = new GradeDAO();
    
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
    
    public void CarregaComboBoxGrade(JComboBox GradeComboBox) {
        GradeDAO gDAO = new GradeDAO();
        
        ArrayList<Grade> arrayPais;
        
        GradeComboBox.removeAllItems();
        
        arrayPais = gDAO.getAll();
        
        GradeComboBox.addItem("Selec. Grade");
        
        arrayPais.stream().forEach((p) -> {
            GradeComboBox.addItem(p.getNome());
        });
    }
    
    public int insert(ProdutoDTO p) {
        return produtoDAO.insert(p);
    }
    
    public int update(ProdutoDTO p) {
        return produtoDAO.update(p);
    }

    public ProdutoDTO getById(Integer idProduto) {
        return produtoDAO.getById(idProduto);
    }

    public int delete(int id) {
        return produtoDAO.delete(id);
    }
    
    public String getNameById(int id){
        return gradeDAO.getNameById(id);
    }
    
    public int getIdByName(String nome){
        return gradeDAO.getIdByName(nome);
    }
}
