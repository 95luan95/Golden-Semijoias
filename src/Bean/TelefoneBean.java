/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.TelefoneDAO;
import DTO.PessoaCompletaDTO;
import Modelo.Pessoa;
import Modelo.Telefone;

/**
 *
 * @author Luan
 */
public class TelefoneBean {
    private TelefoneDAO telDAO = new TelefoneDAO();

    public int gravarTelefone(PessoaCompletaDTO pessoaGravar) {
        return telDAO.gravarTelefone(pessoaGravar);
    }
    
}
