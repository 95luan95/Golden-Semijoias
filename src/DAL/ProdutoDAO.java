/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.ProdutoDTO;
import Modelo.Grade;
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
public class ProdutoDAO {
    
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<ProdutoDTO> getAll(){
        
        ArrayList<ProdutoDTO> ArrayProduto = new ArrayList<>();
        ProdutoDTO produto;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "PRODUTO WHERE ATIVO = 1";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                produto = new ProdutoDTO();
                
                produto.setIdProduto(rs.getInt("ID_PRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO_PRODUTO"));
                produto.setAtivo(rs.getInt("ATIVO"));
                
                ArrayProduto.add(produto);
            }
            
            return ArrayProduto;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public ProdutoDTO getById(int id) {
        String query =  "select * from produto where id_produto = "+id+";";
        
        ProdutoDTO p = new ProdutoDTO();
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            p.setIdProduto(rs.getInt("ID_PRODUTO"));
            p.setNome(rs.getString("NOME"));
            p.setDescricao(rs.getString("DESCRICAO_PRODUTO"));
            p.setIdGrade(rs.getInt("ID_GRADE"));
            p.setAtivo(rs.getInt("ATIVO"));
            
            return p;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public String getNameById(int id){
        
        Grade grade = new Grade();
        
        String query =  "SELECT NOME FROM GRADE WHERE ID_GRADE = '" + id + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                grade.setNome(rs.getString("NOME"));
            }
            
            return grade.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return "Error";
    }

    public int insert(ProdutoDTO produto) {
        String query =  "INSERT INTO PRODUTO (NOME, DESCRICAO_PRODUTO, ATIVO, ID_GRADE) VALUES ( ? , ? , 1, ?);";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, produto.getNome());
                preparedStmt.setString (2, produto.getDescricao());
                preparedStmt.setInt(3, produto.getIdGrade());
                
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

    public int update(ProdutoDTO p) {
        String query = "UPDATE PRODUTO "
                        + "SET Nome = ?, Descricao_Produto = ?"
                        + "WHERE Id_Produto = "+p.getIdProduto()+";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setString(1, p.getNome());
                preparedStmt.setString(2, p.getDescricao());
                
                preparedStmt.execute();
            }
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int delete(int id) {
        String query =  "UPDATE PRODUTO SET ATIVO = 0 WHERE Id_produto = "+ id +";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.execute();
            }
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int retornaUltimo(){
        String query =  "Select * from PRODUTO order by ID_PRODUTO desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_PRODUTO");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
