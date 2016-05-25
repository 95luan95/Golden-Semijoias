/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.TamanhoDTO;
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
public class TamanhoDAO {
    
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<TamanhoDTO> getAll(){
        
        ArrayList<TamanhoDTO> ArrayTamanho = new ArrayList<>();
        TamanhoDTO t;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "TAMANHO WHERE ATIVO = 1";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                t = new TamanhoDTO();
                t.setIdTamanho(rs.getInt("ID_TAMANHO"));
                t.setTamanho(rs.getInt("TAMANHO"));
                t.setIdGrade(rs.getInt("ID_GRADE"));
                t.setAtivo(rs.getInt("ATIVO"));
                
                ArrayTamanho.add(t);
            }
            
            return ArrayTamanho;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<TamanhoDTO> getAllTamanhoByIdGrade(int id){
        
        ArrayList<TamanhoDTO> ArrayTamanho = new ArrayList<>();
        TamanhoDTO t;
        
        String query =  "select \n" +
            "	tamanho.Id_Tamanho ,tamanho.tamanho \n" +
            "from \n" +
            "	tamanho \n" +
            "where \n" +
            "	tamanho.Id_Grade = "+id+" and ATIVO = 1";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                t = new TamanhoDTO();
                
                t.setIdTamanho(rs.getInt("ID_TAMANHO"));
                t.setTamanho(rs.getInt("TAMANHO"));
                
                ArrayTamanho.add(t);
            }
            
            return ArrayTamanho;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public TamanhoDTO getById(int id) {
        String query =  "select * from tamanho where id_tamanho = "+id+";";
        
        TamanhoDTO t = new TamanhoDTO();
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            t.setIdTamanho(rs.getInt("ID_TAMANHO"));
            t.setTamanho(rs.getInt("TAMANHO"));
            t.setIdGrade(rs.getInt("ID_GRADE"));
            t.setAtivo(rs.getInt("ATIVO"));
            
            return t;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    

    public int insert(TamanhoDTO t) {
        String query =  "INSERT INTO TAMANHO (TAMANHO, ID_GRADE, ATIVO) VALUES ( ? , ?, 1);";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, t.getTamanho());
                preparedStmt.setInt(2, t.getIdGrade());
                
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

    public int update(TamanhoDTO t) {
        String query = "UPDATE TAMANHO "
                        + "SET TAMANHO = ? "
                        + "WHERE ID_TAMANHO = "+t.getIdTamanho()+";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setInt(1, t.getTamanho());
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
        String query =  "UPDATE TAMANHO SET ATIVO = 0 WHERE ID_TAMANHO = "+ id +";";
        
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
        String query =  "Select * from TAMANHO order by ID_TAMANHO desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_TAMANHO");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public ArrayList<TamanhoDTO> getAllTamanhoById(int id) {
        ArrayList<TamanhoDTO> ArrayTamanho = new ArrayList<>();
        TamanhoDTO t;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "TAMANHO WHERE ID_Grade = "+id+" "
                            + "AND ATIVO = 1;";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                t = new TamanhoDTO();
                t.setIdTamanho(rs.getInt("ID_TAMANHO"));
                t.setTamanho(rs.getInt("TAMANHO"));
                t.setIdGrade(rs.getInt("ID_GRADE"));
                t.setAtivo(rs.getInt("ATIVO"));
                
                ArrayTamanho.add(t);
            }
            
            return ArrayTamanho;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
