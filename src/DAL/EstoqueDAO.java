/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.ProdutoDTO;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class EstoqueDAO {
    
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public int getQTD(int id_produto, int id_tamanho) {
        String query =  "select \n" +
                        "	estoque.QTD_Produto\n" +
                        "from \n" +
                        "	estoque\n" +
                        "where\n" +
                        "	Id_Produto = "+id_produto+"\n" +
                        "    and Id_Tamanho = "+id_tamanho+";";
        
        int t = 0;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t = rs.getInt("QTD_Produto");
            
            return t;
        }
        catch (SQLException ex){
            return 0;
        }
    }
    
    public int updateItemQTD(int qtd, int idProduto, int idTamanho) {
        String query = "UPDATE ESTOQUE "
                        + "SET QTD_Produto = ? "
                        + "WHERE id_produto = "+idProduto+" and Id_Tamanho = "+idTamanho+";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setInt(1, qtd);
                
                preparedStmt.execute();
            }
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int insert(int qtd, int idProduto, int idTamanho) {
        String query = "INSERT INTO estoque (Id_Produto, Id_Tamanho, QTD_Produto) VALUES (?, ?, ?);";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setInt(1, idProduto);
                preparedStmt.setInt(2, idTamanho);
                preparedStmt.setInt(3, qtd);
                
                preparedStmt.execute();
            }
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int tamanhoExiste(int idTamanho, int idProduto) {
        String query = "select Id_Tamanho from estoque where Id_Tamanho = "+idTamanho+" and id_Produto = "+idProduto+";";
        
        int id;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            id = rs.getInt("Id_Tamanho");
            
            return idTamanho;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public int retornaIdEstoque(int id_Produto, int id_tamanho) {
        String query =    "Select * "
                        + "from estoque "
                        + "where id_produto = "+id_Produto+" "
                        + "and id_tamanho = "+id_tamanho+";";
        
        try{
            int id = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                id = rs.getInt("id_estoque");
            }
            
            return id;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int retornaUltimo(){
        String query =  "Select * from estoque order by id_estoque desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("id_estoque");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int updateItemQTDVenda(int resultado, Integer idEstoque) {
        String query = "UPDATE ESTOQUE "
                        + "SET QTD_Produto = ? "
                        + "WHERE id_estoque = "+idEstoque+";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setInt(1, resultado);
                
                preparedStmt.execute();
            }
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public int getQTDVenda(Integer idEstoque) {
        String query =  "select \n" +
                        "	estoque.QTD_Produto\n" +
                        "from \n" +
                        "	estoque\n" +
                        "where\n" +
                        "	Id_Estoque = "+idEstoque+";";
        
        int t = 0;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t = rs.getInt("QTD_Produto");
            
            return t;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    public int getIdProdutoByIdEstoque(Integer idEstoque) {
        String query =  "select \n" +
                        "	estoque.id_produto\n" +
                        "from \n" +
                        "	estoque\n" +
                        "where\n" +
                        "	Id_Estoque = "+idEstoque+";";
        
        int t = 0;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t = rs.getInt("id_produto");
            
            return t;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int getIdTamanhoByIdEstoque(Integer idEstoque) {
        String query =  "select \n" +
                        "	estoque.id_Tamanho\n" +
                        "from \n" +
                        "	estoque\n" +
                        "where\n" +
                        "	Id_Estoque = "+idEstoque+";";
        
        int t = 0;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t = rs.getInt("id_Tamanho");
            
            return t;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    public String getNameProdutoById(int idProduto) {
        String query =  "select \n" +
                        "	produto.nome\n" +
                        "from \n" +
                        "	produto\n" +
                        "where\n" +
                        "	Id_Produto = "+idProduto+";";
        
        String n = "";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            n = rs.getString("nome");
            
            return n;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return "-1";
        }
    }

    public int getTamanhoById(int idTamanho) {
        String query =  "select \n" +
                        "	Tamanho.tamanho\n" +
                        "from \n" +
                        "	Tamanho\n" +
                        "where\n" +
                        "	Id_Tamanho = "+idTamanho+";";
        
        int t = 0;
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t = rs.getInt("tamanho");
            
            return t;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
