/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import Modelo.Grade;
import Modelo.Produto;
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
public class GradeDAO {
    
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<Grade> getAll(){
        
        ArrayList<Grade> ArrayGrade = new ArrayList<>();
        Grade grade;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "GRADE WHERE ATIVO = 1";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                grade = new Grade();
                grade.setIdGrade(rs.getInt("ID_GRADE"));
                grade.setNome(rs.getString("NOME"));
                grade.setAtivo(rs.getInt("ATIVO"));
                
                ArrayGrade.add(grade);
            }
            
            return ArrayGrade;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public Grade getById(int id) {
        String query =  "select * from grade where id_grade = "+id+";";
        
        Grade g = new Grade();
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            rs.next();
            
            g.setIdGrade(rs.getInt("ID_GRADE"));
            g.setNome(rs.getString("NOME"));
            g.setAtivo(rs.getInt("ATIVO"));
            
            return g;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    

    public int insert(Grade grade) {
        String query =  "INSERT INTO GRADE (NOME, ATIVO) VALUES ( ? , 1);";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, grade.getNome());
                
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

    public int update(Grade g) {
        String query = "UPDATE GRADE "
                        + "SET Nome = ? "
                        + "WHERE Id_Grade = "+g.getIdGrade()+";";
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setString(1, g.getNome());
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
        String query =  "UPDATE GRADE SET ATIVO = 0 WHERE Id_grade = "+ id +";";
        
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
    
    public String getNameById(int id) {
        Grade grade = new Grade();
        
        String query =  "select nome from GRADE where ID_GRADE = "+id+";";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                grade.setNome(rs.getString("nome"));
            }

            preparedStmt.execute();
            st.close();
            
            return grade.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return "-1";
        }
    }
    
    public Integer getIdByName(String gradeNome) {
        Grade grade = new Grade();
        
        String query =  "select ID_GRADE from GRADE where GRADE.nome like('"+gradeNome+"');";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                grade.setIdGrade(rs.getInt("id_Grade"));
            }

            preparedStmt.execute();
            st.close();
            
            return grade.getIdGrade();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int retornaUltimo(){
        String query =  "Select * from GRADE order by ID_GRADE desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_GRADE");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
