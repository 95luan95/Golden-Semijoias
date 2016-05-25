/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan
 */
public class ConexaoMySQL {
    public ConexaoMySQL() {
    
    }
    
    public static Connection con = null;
 
    public Connection Conectar() {        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/goldensemijoias_db","root","admin");
            
            return con;
        } catch (ClassNotFoundException ex){
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
            
        }
        return null;
    }
}