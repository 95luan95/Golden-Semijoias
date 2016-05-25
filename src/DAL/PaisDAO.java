/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import Modelo.Pais;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class PaisDAO {
    private ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<Pais> getAll(){
        
        ArrayList<Pais> ArrayPais = new ArrayList<>();
        Pais pais;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "PAIS";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                pais = new Pais();
                pais.setIdPais(rs.getInt("ID_PAIS"));
                pais.setNome(rs.getString("NOME"));
                
                ArrayPais.add(pais);
            }
            
            return ArrayPais;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayPais;
    }
    
    public int getIdByName(String nome){
        
        Pais pais = new Pais();
        
        String query =  "SELECT ID_PAIS FROM PAIS WHERE NOME = '" + nome + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                pais.setIdPais(rs.getInt("ID_PAIS"));
            }
            
            return pais.getIdPais();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return -1;
    }
    public String getNameById(int id){
        
        Pais pais = new Pais();
        
        String query =  "SELECT NOME FROM PAIS WHERE ID_PAIS = '" + id + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                pais.setNome(rs.getString("NOME"));
            }
            
            return pais.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return "Error";
    }
}
