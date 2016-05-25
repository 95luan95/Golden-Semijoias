/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import Modelo.Cidade;
import Modelo.Estado;
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
public class CidadeDAO {
    private ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<Cidade> getAllById(int id){
        
        ArrayList<Cidade> ArrayCidade = new ArrayList<>();
        Cidade cidade;
        
        String query =  "SELECT * FROM CIDADE WHERE ID_ESTADO = "+id+";";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("ID_CIDADE"));
                cidade.setNome(rs.getString("NOME"));
                
                ArrayCidade.add(cidade);
            }
            
            return ArrayCidade;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayCidade;
    }
    
    public Cidade gravaCidade(Cidade cid) {
        Estado estado = new Estado();
        String query =  "INSERT INTO CIDADE (NOME, ID_ESTADO) VALUES ( ? , ?);"
                + "SELECT ID_CIDADE from CIDADE WHERE ID_CIDADE = LAST_INSERT_ID();";
        estado.setIdEstado(cid.getIdEstado().getIdEstado());
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, cid.getNome());
            preparedStmt.setInt(2, estado.getIdEstado());
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                cid.setIdCidade(rs.getInt("ID_CIDADE"));
            }

            preparedStmt.execute();
            st.close();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return cid;
    }
    
    public String getNameById(int id){
        
        Cidade cidade = new Cidade();
        
        String query =  "SELECT NOME FROM CIDADE WHERE ID_CIDADE = '" + id + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                cidade.setNome(rs.getString("NOME"));
            }
            
            return cidade.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return "Error";
    }
    public int getIdByName(String name){
        
        Cidade cidade = new Cidade();
        
        String query =  "SELECT ID_CIDADE FROM CIDADE WHERE NOME = '" + name + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                cidade.setIdCidade(rs.getInt("ID_CIDADE"));
            }
            
            return cidade.getIdCidade();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return -1;
    }
}
