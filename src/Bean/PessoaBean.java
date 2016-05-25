/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAL.CidadeDAO;
import DAL.EstadoDAO;
import DAL.PaisDAO;
import DAL.PessoaDAO;
import DTO.PessoaCompletaDTO;
import Modelo.Cidade;
import Modelo.Estado;
import Modelo.Pais;
import Modelo.Pessoa;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class PessoaBean{
    
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void atualizaTabela(JTable jTable1) {
        ArrayList<Pessoa> arrayPessoa;
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        arrayPessoa = pessoaDAO.getAllAtivo();
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"ID", "Nome", "CPF/CNPJ"});
        
        arrayPessoa.stream().forEach((c) -> {
            modeloTable.addRow(new Object[] {
                c.getIdPessoa(), c.getNome(), c.getCpfCnpj()
            });
        });
    }

    public int insert(PessoaCompletaDTO p) {
        return pessoaDAO.insert(p);
    }

    public int delete(int id) {
        return pessoaDAO.delete(id);
    }

    public PessoaCompletaDTO alteraPessoa(int id) {
        return pessoaDAO.getById(id, 1);
    }

    public int alterarPessoa(PessoaCompletaDTO pessoaAlterar) {
        return pessoaDAO.update(pessoaAlterar);
    }
    public ArrayList<Pessoa> getAllAtivo() {
        return pessoaDAO.getAllAtivo();
    }
    
    
    public void CarregaComboBoxPais(JComboBox PaisComboBox) {
        PaisDAO pDao = new PaisDAO();
        
        ArrayList<Pais> arrayPais;
        
        PaisComboBox.removeAllItems();
        
        arrayPais = pDao.getAll();
        
        PaisComboBox.addItem("Selec. Pais");
        
        arrayPais.stream().forEach((p) -> {
            PaisComboBox.addItem(p.getNome());
        });
    }
    
    public void CarregaComboBoxEstado(JComboBox EstadoComboBox, String nome) {
        EstadoDAO eDao = new EstadoDAO();
        PaisDAO pDao = new PaisDAO();
        
        ArrayList<Estado> arrayEstado;
        
        EstadoComboBox.removeAllItems();
        
        arrayEstado = eDao.getAllById(pDao.getIdByName(nome));
        
        EstadoComboBox.addItem("Selec. Estado");
        
        arrayEstado.stream().forEach((e) -> {
            EstadoComboBox.addItem(e.getNome());
        });
    }

    public void CarregaComboBoxCidade(JComboBox CidadeComboBox, String nome) {
        CidadeDAO cDao = new CidadeDAO();
        EstadoDAO eDao = new EstadoDAO();
        
        ArrayList<Cidade> arrayCidade;
        
        CidadeComboBox.removeAllItems();
        
        arrayCidade = cDao.getAllById(eDao.getIdByName(nome));
        
        CidadeComboBox.addItem("Selec. Cidade");
        
        arrayCidade.stream().forEach((e) -> {
            CidadeComboBox.addItem(e.getNome());
        });
    }
}
