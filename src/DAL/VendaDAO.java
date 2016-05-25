/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.ItemVendaDTO;
import DTO.VendaDTO;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class VendaDAO {
    
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<VendaDTO> getAll(){
        
        ArrayList<VendaDTO> ArrayVenda = new ArrayList<>();
        VendaDTO venda;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "VENDA;";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                venda = new VendaDTO();
                
                venda.setIdVenda(rs.getInt("ID_Venda"));
                venda.setVencimento(rs.getDate("Vencimento"));
                venda.setTipoPagamento(rs.getString("Tipo_Pagamento"));
                venda.setDataCompra(rs.getDate("Data_Compra"));
                venda.setIdPessoa(rs.getInt("Id_Pessoa"));
                
                ArrayVenda.add(venda);
            }
            
            return ArrayVenda;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public VendaDTO getById(int id) {
        String query =  "select * from venda where id_venda = "+id+";";
        
        VendaDTO venda = new VendaDTO();
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            venda.setIdVenda(rs.getInt("ID_Venda"));
            venda.setVencimento(rs.getDate("Vencimento"));
            venda.setTipoPagamento(rs.getString("Tipo_Pagamento"));
            venda.setDataCompra(rs.getDate("Data_Compra"));
            venda.setIdPessoa(rs.getInt("Id_Pessoa"));
            
            return venda;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    

    public int insert(VendaDTO venda) {
        String query =  "INSERT INTO "
                + "venda (Vencimento, Tipo_Pagamento, Data_Compra, Id_Pessoa) "
                + "VALUES ( ? , ? , ? , ?);";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                java.sql.Date sqlVencimento;
                java.sql.Date sqlDataCompra;
                
                sqlVencimento = new java.sql.Date(venda.getVencimento().getTime());
                sqlDataCompra = new java.sql.Date(venda.getDataCompra().getTime());
                
                System.out.println("sqlVencimento " + sqlVencimento);
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setDate(1, sqlVencimento);
                preparedStmt.setString (2, venda.getTipoPagamento());
                preparedStmt.setDate(3, sqlDataCompra);
                preparedStmt.setInt(4, venda.getIdPessoa());
                
                preparedStmt.execute();
            }
            return retornaUltimo();
        }
        catch (SQLException ex){
            return -1;
        }
    }
    
    public int insertItemVenda(ItemVendaDTO itemVendaDTO) {
        String query =  "INSERT INTO "
                + "item_venda (qtd_produto, id_venda, id_estoque) "
                + "VALUES ( ? , ? , ? );";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt (1, itemVendaDTO.getQtdProduto());
                preparedStmt.setInt (2, itemVendaDTO.getIdVenda());
                preparedStmt.setInt (3, itemVendaDTO.getIdEstoque());
                
                preparedStmt.execute();
            }
            System.out.println();
            return retornaUltimo();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public ArrayList<ItemVendaDTO> getListaItemByIdVenda(Integer id) {
        
        ItemVendaDTO itemVendaDTO;
        ArrayList<ItemVendaDTO> arrayItemVenda = new ArrayList<>();
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "item_venda WHERE Id_Venda = "+id+";";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                itemVendaDTO = new ItemVendaDTO();
                
                itemVendaDTO.setIdVenda(rs.getInt("ID_VENDA"));
                itemVendaDTO.setQtdProduto(rs.getInt("QTD_Produto"));
                itemVendaDTO.setIdItemVenda(rs.getInt("Id_Item_Venda"));
                itemVendaDTO.setIdEstoque(rs.getInt("Id_Estoque"));
                
                arrayItemVenda.add(itemVendaDTO);
            }
            
            return arrayItemVenda;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int retornaUltimo(){
        String query =  "Select * from venda order by ID_venda desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_venda");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
