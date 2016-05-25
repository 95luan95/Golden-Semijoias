/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import Modelo.Estado;
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
public class EstadoDAO {
    private ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<Estado> getAll(){
        
        ArrayList<Estado> ArrayEstado = new ArrayList<>();
        Estado estado;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "ESTADO";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                estado = new Estado();
                estado.setIdEstado(rs.getInt("ID_ESTADO"));
                estado.setNome(rs.getString("NOME"));
                
                Pais pais = new Pais();
                
                pais.setIdPais(rs.getInt("ID_PAIS"));
                estado.setIdPais(pais);
                
                ArrayEstado.add(estado);
            }
            
            return ArrayEstado;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayEstado;
    }
    
    public ArrayList<Estado> getAllById(int id){
        
        ArrayList<Estado> ArrayEstado = new ArrayList<>();
        Estado estado;
        
        String query =  "SELECT * FROM ESTADO WHERE ID_PAIS = "+id+";";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                estado = new Estado();
                estado.setIdEstado(rs.getInt("ID_ESTADO"));
                estado.setNome(rs.getString("NOME"));
                
                Pais pais = new Pais();
                
                pais.setIdPais(rs.getInt("ID_PAIS"));
                estado.setIdPais(pais);
                
                ArrayEstado.add(estado);
            }
            
            return ArrayEstado;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayEstado;
    }
    
    public int getIdByName(String nome){
        
        Estado estado = new Estado();
        
        String query =  "SELECT ID_ESTADO FROM ESTADO WHERE NOME = '" + nome + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                estado.setIdEstado(rs.getInt("ID_ESTADO"));
            }
            
            return estado.getIdEstado();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return -1;
    }
    public String getNameById(int id){
        
        Estado estado = new Estado();
        
        String query =  "SELECT NOME FROM ESTADO WHERE ID_ESTADO = '" + id + "';";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                estado.setNome(rs.getString("NOME"));
            }
            
            return estado.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return "Error";
    }
}
