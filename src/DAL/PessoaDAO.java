/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.PessoaCompletaDTO;
import Modelo.Endereco;
import Modelo.Pessoa;
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
public class PessoaDAO {
    private final ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ArrayList<Pessoa> getAll(){
        
        ArrayList<Pessoa> ArrayPessoa = new ArrayList<>();
        Pessoa pessoas;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "PESSOA WHERE ATIVO = '1'";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                pessoas = new Pessoa();
                pessoas.setIdPessoa(rs.getInt("ID_PESSOA"));
                pessoas.setNome(rs.getString("NOME"));
                pessoas.setCpfCnpj(rs.getString("CPF_CNPJ"));
                pessoas.setComissao(rs.getFloat("COMISSAO"));
                pessoas.setTipoPessoa(rs.getString("TIPO_PESSOA"));
                
                ArrayPessoa.add(pessoas);
            }
            
            return ArrayPessoa;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayPessoa;
    }
    
    public ArrayList<Pessoa> getAllAtivo(){
        
        ArrayList<Pessoa> ArrayPessoa = new ArrayList<>();
        Pessoa pessoas;
        
        String query =  "SELECT "
                            + "*"
                        + "FROM "
                            + "PESSOA WHERE ATIVO = '1'";
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                pessoas = new Pessoa();
                pessoas.setIdPessoa(rs.getInt("ID_PESSOA"));
                pessoas.setNome(rs.getString("NOME"));
                pessoas.setCpfCnpj(rs.getString("CPF_CNPJ"));
                pessoas.setComissao(rs.getFloat("COMISSAO"));
                pessoas.setTipoPessoa(rs.getString("TIPO_PESSOA"));
                
                ArrayPessoa.add(pessoas);
            }
            
            return ArrayPessoa;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ArrayPessoa;
    }
    
    public PessoaCompletaDTO getById(int id, int ativo) {
        String query =  "SELECT\n" +
                        "    pessoa.Id_Pessoa as ID,\n" +
                        "    pessoa.Nome as NOME, \n" +
                        "    pessoa.Senha as SENHA, \n" +
                        "    pessoa.CPF_CNPJ as CPF, \n" +
                        "    pessoa.Tipo_Pessoa as TIPO_PESSOA, \n" +
                        "    pais.Id_Pais as PAIS, \n" +
                        "    estado.Id_Estado as ESTADO, \n" +
                        "    cidade.Id_Cidade as CIDADE, \n" +
                        "    endereco.CEP as CEP, \n" +
                        "    endereco.rua as RUA, \n" +
                        "    endereco.numero as NUMERO_RUA, \n" +
                        "    telefone.numero as TELEFONE\n" +
                        "FROM \n" +
                        "    PESSOA, CIDADE, ESTADO, ENDERECO, TELEFONE, PAIS\n" +
                        "WHERE \n" +
                        "    pessoa.Id_Pessoa = " + id + "\n" +
                        "    and pais.Id_Pais = estado.Id_Pais\n" +
                        "    and estado.Id_Estado = cidade.Id_Estado\n" +
                        "    and cidade.Id_Cidade = endereco.Id_Cidade\n" +
                        "    and endereco.Id_Endereco = pessoa.Id_Endereco\n" +
                        "    and pessoa.Id_Pessoa = telefone.Id_Pessoa\n" +
                        "    AND ATIVO = 1;"
                ;
        PessoaCompletaDTO pessoaDadosAlterar = new PessoaCompletaDTO();
        
        try{
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                
                pessoaDadosAlterar.setNome(rs.getString("NOME"));
                pessoaDadosAlterar.setCpf(rs.getString("CPF"));
                pessoaDadosAlterar.setSenha(rs.getString("SENHA"));
                pessoaDadosAlterar.setTipoPessoa(rs.getString("TIPO_PESSOA"));
                
                pessoaDadosAlterar.setIdPais(rs.getInt("PAIS"));
                pessoaDadosAlterar.setIdEstado(rs.getInt("ESTADO"));
                pessoaDadosAlterar.setIdCidade(rs.getInt("CIDADE"));
                
                pessoaDadosAlterar.setCep(rs.getString("CEP"));
                pessoaDadosAlterar.setRua(rs.getString("RUA"));
                
                pessoaDadosAlterar.setNumero(rs.getString("NUMERO_RUA"));
                
                pessoaDadosAlterar.setTelefone(rs.getString("TELEFONE"));
                
            }
            
            return pessoaDadosAlterar;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    

    public int insert(PessoaCompletaDTO p) {
        String query =  "INSERT INTO PESSOA (NOME, CPF_CNPJ, ATIVO, SENHA, TIPO_PESSOA, Id_Endereco) VALUES (?, ?, 1, ?, ?, ?);";
        Endereco e = new Endereco();
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, p.getNome());
                preparedStmt.setString (2, p.getCpf());
                preparedStmt.setString (3, p.getSenha());
                preparedStmt.setString (4, p.getTipoPessoa());
                preparedStmt.setInt (5, p.getIdEndereco());
                
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

    public int update(PessoaCompletaDTO pessoaAlterar) {
        String query =  "UPDATE \n" +
                        "    pessoa, telefone,endereco, cidade, estado\n" +
                        "SET \n" +
                        "    pessoa.Nome= ?, \n" +
                        "    pessoa.CPF_CNPJ= ?, \n" +
                        "    pessoa.Senha= ?,\n" +
                        "    pessoa.Tipo_Pessoa= ?,"+
                        "    telefone.Numero = ?,\n" +
                        "    endereco.Numero = ?,\n" +
                        "    endereco.CEP = ?,\n" +
                        "    endereco.Rua = ?,\n" +
                        "    endereco.Id_Cidade = ?\n" +
                        "WHERE \n" +
                        "    pessoa.Id_Pessoa = "+ pessoaAlterar.getIdPessoa() +"\n" +   
                            "    and pessoa.Id_Pessoa = telefone.Id_Pessoa\n" +
                            "    and pessoa.Id_Endereco = endereco.Id_Endereco\n" +
                            "    and endereco.Id_Cidade = cidade.Id_Cidade\n" +
                            "    and cidade.Id_Estado = estado.Id_Estado";
        
        
        
        try{
            try (Connection con = conexao.Conectar(); Statement st = con.createStatement()) {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, pessoaAlterar.getNome());
                preparedStmt.setString (2, pessoaAlterar.getCpf());
                preparedStmt.setString (3, pessoaAlterar.getSenha());
                preparedStmt.setString (4, pessoaAlterar.getTipoPessoa());
                preparedStmt.setString (5, pessoaAlterar.getTelefone());
                preparedStmt.setString (6, pessoaAlterar.getNumero());
                preparedStmt.setString (7, pessoaAlterar.getCep());
                preparedStmt.setString (8, pessoaAlterar.getRua());
                preparedStmt.setInt (9, pessoaAlterar.getIdCidade());
                
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
        String query =  "UPDATE PESSOA SET ATIVO = 0 WHERE Id_Pessoa = "+ id +";";
        
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
        String query =  "Select * from PESSOA order by ID_PESSOA desc LIMIT 1";
        
        try{
            int ultimoID = 0;
            Connection con = conexao.Conectar();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                ultimoID = rs.getInt("ID_PESSOA");
            }
            
            return ultimoID;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
}
