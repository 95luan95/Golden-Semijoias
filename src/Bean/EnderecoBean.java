/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAL.CidadeDAO;
import DAL.EnderecoDAO;
import DAL.EstadoDAO;
import DAL.PaisDAO;
import DTO.PessoaCompletaDTO;
import Modelo.Cidade;
import Modelo.Estado;
import Modelo.Pais;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Luan
 */
public class EnderecoBean {
    
    private EnderecoDAO endDAO = new EnderecoDAO();
    
    public void CarregaComboBoxPais(JComboBox PaisComboBox) {
        PaisDAO pDao = new PaisDAO();
        
        ArrayList<Pais> arrayPais;
        
        PaisComboBox.removeAllItems();
        
        arrayPais = pDao.getAll();
        
        PaisComboBox.addItem("Selec. Pais");
        
        arrayPais.stream().forEach((p) -> {
            PaisComboBox.addItem(p.getNome());
        });
    }
    
    public void CarregaComboBoxEstado(JComboBox EstadoComboBox, String nome) {
        EstadoDAO eDao = new EstadoDAO();
        PaisDAO pDao = new PaisDAO();
        
        ArrayList<Estado> arrayEstado;
        
        EstadoComboBox.removeAllItems();
        
        arrayEstado = eDao.getAllById(pDao.getIdByName(nome));
        
        EstadoComboBox.addItem("Selec. Estado");
        
        arrayEstado.stream().forEach((e) -> {
            EstadoComboBox.addItem(e.getNome());
        });
    }

    public void CarregaComboBoxCidade(JComboBox CidadeComboBox, String nome) {
        CidadeDAO cDao = new CidadeDAO();
        EstadoDAO eDao = new EstadoDAO();
        
        ArrayList<Cidade> arrayCidade;
        
        CidadeComboBox.removeAllItems();
        
        arrayCidade = cDao.getAllById(eDao.getIdByName(nome));
        
        CidadeComboBox.addItem("Selec. Cidade");
        
        arrayCidade.stream().forEach((e) -> {
            CidadeComboBox.addItem(e.getNome());
        });
    }

    public int gravarEndereco(PessoaCompletaDTO pessoaAlterar, int idCidade) {
        return endDAO.gravaEndereco(pessoaAlterar, idCidade);
    }
    
    public Integer pegaIdPais(String pais) {
        return endDAO.paisByName(pais);
    }

    public Integer pegaIdEstado(String nomeEstado) {
        return endDAO.estadoByName(nomeEstado);
    }
    public Integer pegaIdCidade(String nomeCidade) {
        return endDAO.cidadeByName(nomeCidade);
    }
    public String pegaNomeCidade(int nomeCidade) {
        return endDAO.cidadeById(nomeCidade);
    }

    public Integer estadoByIdCidade(Integer idCidade) {
        return endDAO.estadoByIdCidade(idCidade);
    }

    public Integer paisByIdEstado(Integer idEstado) {
        return endDAO.paisByIdEstado(idEstado);
    }
}
