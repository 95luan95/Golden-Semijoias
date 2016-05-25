/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.GradeDAO;
import Modelo.Grade;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class CrudGradeMB {
    private GradeDAO gradeDAO = new GradeDAO();
    
    public void atualizaTabela(JTable jTable1) {
        ArrayList<Grade> arrayGrade;
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        arrayGrade = gradeDAO.getAll();
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"Id", "Nome"});
        
        arrayGrade.stream().forEach((c) -> {
            modeloTable.addRow(new Object[] {
                c.getIdGrade(), c.getNome()
            });
        });
    }
    
    public int insert(Grade g) {
        return gradeDAO.insert(g);
    }
    
    public int update(Grade g) {
        return gradeDAO.update(g);
    }

    public Grade getById(Integer idGrade) {
        return gradeDAO.getById(idGrade);
    }
    
    public int delete(int id) {
        return gradeDAO.delete(id);
    }
}
