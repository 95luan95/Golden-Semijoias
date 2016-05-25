/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.PessoaCompletaDTO;
import Modelo.Cidade;
import Modelo.Endereco;
import Modelo.Estado;
import Modelo.Pais;
import Modelo.Pessoa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luan
 */
public class EnderecoDAO {
    private ConexaoMySQL conexao = new ConexaoMySQL();
    
    public int gravaEndereco(PessoaCompletaDTO end, int idCidade) {
        
        String query =  "INSERT INTO ENDERECO (RUA, CEP, ID_CIDADE, NUMERO) VALUES ( ?, ?, ?, ?);";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setString (1, end.getRua());
            preparedStmt.setString(2, end.getCep());
            preparedStmt.setInt(3, idCidade);
            preparedStmt.setString(4, end.getNumero());

            preparedStmt.execute();
            st.close();
            
            return retornaUltimo();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public int retornaUltimo(){
        String query =  "Select * from ENDERECO order by ID_ENDERECO desc LIMIT 1;";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_ENDERECO");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public Integer estadoByName(String estadoNome) {
        Estado estado = new Estado();
        
        String query =  "select id_Estado from estado where estado.nome like('"+estadoNome+"');";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                estado.setIdEstado(rs.getInt("id_Estado"));
            }

            preparedStmt.execute();
            st.close();
            
            return estado.getIdEstado();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public Integer paisByName(String paisNome) {
        Pais pais = new Pais();
        
        String query =  "select id_Pais from pais where pais.nome like('"+paisNome+"');";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                pais.setIdPais(rs.getInt("id_Pais"));
            }

            preparedStmt.execute();
            st.close();
            
            return pais.getIdPais();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public Integer cidadeByName(String cidadeNome) {
        Cidade cidade = new Cidade();
        
        String query =  "select id_Cidade from cidade where cidade.nome like('"+cidadeNome+"');";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                cidade.setIdCidade(rs.getInt("id_Cidade"));
            }

            preparedStmt.execute();
            st.close();
            
            return cidade.getIdCidade();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
    public String cidadeById(int cidadeId) {
        Cidade cidade = new Cidade();
        
        String query =  "select nome from cidade where cidade.id_Cidade like('"+cidadeId+"');";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                cidade.setIdCidade(rs.getInt("nome"));
            }

            preparedStmt.execute();
            st.close();
            
            return cidade.getNome();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return "Error";
        }
    }

    public Integer estadoByIdCidade(Integer idCidade) {
        Estado estado = new Estado();
        
        String query =  "select Id_Estado from cidade where Id_Cidade = "+idCidade+";";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                estado.setIdEstado(rs.getInt("Id_Estado"));
            }

            preparedStmt.execute();
            st.close();
            
            return estado.getIdEstado();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public Integer paisByIdEstado(Integer idEstado) {
        Pais pais = new Pais();
        
        String query =  "select Id_Pais from estado where Id_Estado = "+idEstado+";";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                pais.setIdPais(rs.getInt("Id_Pais"));
            }

            preparedStmt.execute();
            st.close();
            
            return pais.getIdPais();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
