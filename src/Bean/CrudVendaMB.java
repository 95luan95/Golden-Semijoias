/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.EstoqueDAO;
import DAL.VendaDAO;
import DTO.ItemVendaDTO;
import DTO.VendaDTO;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan
 */
public class CrudVendaMB {
    private VendaDAO vendaDAO = new VendaDAO();
    private EstoqueDAO estoqueDAO = new EstoqueDAO();
    
    public void atualizaTabela(JTable jTable1) {
        ArrayList<VendaDTO> arrayVenda;
        jTable1.setDefaultEditor(Object.class, null);
        DefaultTableModel modeloTable = (DefaultTableModel) jTable1.getModel();
        
        arrayVenda = vendaDAO.getAll();
        
        while (modeloTable.getRowCount() > 0) {
            modeloTable.removeRow(0);
        }
        
        modeloTable.setColumnIdentifiers(new String [] {"ID", "Data da Compra"});
        
        arrayVenda.stream().forEach((v) -> {
            modeloTable.addRow(new Object[] {
                v.getIdVenda(), v.getDataCompra()
            });
        });
    }

    public int insert(VendaDTO vendaDTO) {
        return vendaDAO.insert(vendaDTO);
    }

    public int insertItemVenda(ItemVendaDTO aiv) {
        return vendaDAO.insertItemVenda(aiv);
    }
    
    public VendaDTO getVendaById(Integer id) {
        return vendaDAO.getById(id);
    }
    
    public ArrayList<ItemVendaDTO> getListaItemByIdVenda(Integer id) {
        return vendaDAO.getListaItemByIdVenda(id);
    } 

    public int updateItemQTDVenda(int resultado, Integer idEstoque) {
        return estoqueDAO.updateItemQTDVenda(resultado, idEstoque);
    }

    public int getQTDVenda(Integer idEstoque) {
        return estoqueDAO.getQTDVenda(idEstoque);
    }

    public int getIdProdutoByIdEstoque(Integer idEstoque) {
        return estoqueDAO.getIdProdutoByIdEstoque(idEstoque);
    }

    public int getIdTamanhoByIdEstoque(Integer idEstoque) {
        return estoqueDAO.getIdTamanhoByIdEstoque(idEstoque);
    }

    public String getNameProdutoById(int idProduto) {
        return estoqueDAO.getNameProdutoById(idProduto);
    }

    public int getTamanhoById(int idTamanho) {
        return estoqueDAO.getTamanhoById(idTamanho);
    }
    
    public int controlarEstoqueAdd(int idEstoque, int qtd){
        CrudEstoqueMB bean = new CrudEstoqueMB();
        int id_Produto = getIdProdutoByIdEstoque(idEstoque);
        int id_tamanho = getIdTamanhoByIdEstoque(idEstoque);
        
        int atualQTD = bean.getQTD(id_Produto, id_tamanho);

        int resultado;

        resultado = atualQTD + qtd;

        if(bean.tamanhoExiste(id_tamanho, id_Produto) == -1){
            if(bean.insert(resultado, id_Produto, id_tamanho) != -1){
                return 0;
            }else{
                return -1;
            }
        }else{
            if(bean.updateItemQTD(resultado, id_Produto, id_tamanho) != -1){
                return 0;
            }else{
                return -1;
            }
        }
    }
}
