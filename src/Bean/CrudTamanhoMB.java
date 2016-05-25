/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.TamanhoDAO;
import DTO.TamanhoDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class CrudTamanhoMB {
    private TamanhoDAO tamanhoDAO = new TamanhoDAO();
    
    public void atualizaTabela(JTable jTable1, int id) {
        ArrayList<TamanhoDTO> arrayTamanho;
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        arrayTamanho = tamanhoDAO.getAllTamanhoById(id);
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"Id", "Tamanho"});
        
        arrayTamanho.stream().forEach((t) -> {
            modeloTable.addRow(new Object[] {
                t.getIdTamanho(), t.getTamanho()
            });
        });
    }
    
    public int insert(TamanhoDTO t) {
        return tamanhoDAO.insert(t);
    }
    
    public int update(TamanhoDTO t) {
        return tamanhoDAO.update(t);
    }

    public TamanhoDTO getById(Integer idTamanho) {
        return tamanhoDAO.getById(idTamanho);
    }
    
    public int delete(int id) {
        return tamanhoDAO.delete(id);
    }
}
