/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConexaoBanco.ConexaoMySQL;
import DTO.PessoaCompletaDTO;
import Modelo.Cidade;
import Modelo.Pessoa;
import Modelo.Telefone;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luan
 */
public class TelefoneDAO {
    private ConexaoMySQL conexao = new ConexaoMySQL();

    public int gravarTelefone(PessoaCompletaDTO pessoaGravar) {
        
        String query =  "INSERT INTO TELEFONE (NUMERO, ID_PESSOA) VALUES (?, ?);";
        
        try (Connection con = conexao.Conectar()) {
            Statement st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
            preparedStmt.setString (1, pessoaGravar.getTelefone());
            preparedStmt.setInt(2, pessoaGravar.getIdPessoa());

            preparedStmt.execute();
            st.close();
            
            return 1;
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return -1;
        }
    }
    
}
