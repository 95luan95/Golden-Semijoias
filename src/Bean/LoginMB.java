/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.PessoaDAO;
import DTO.PessoaCompletaDTO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Luan
 */
public class LoginMB {

    public PessoaCompletaDTO login(JTextField IDTextField, JPasswordField SenhaPasswordField) {
        PessoaDAO dao = new PessoaDAO();
        PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
        
        pessoaCompletaDTO = dao.getById(Integer.parseInt(IDTextField.getText()), 1);
        
        String senha = pessoaCompletaDTO.getSenha();
        
        String senhaDigitada = String.valueOf(SenhaPasswordField.getPassword());
        
        if(senhaDigitada.equals(senha)){
            return pessoaCompletaDTO;
        }else{
            return null;
        }
    }
}
