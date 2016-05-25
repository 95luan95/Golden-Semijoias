/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
/**
 *
 * @author Luan
 */
public class TamanhoDTO {
    
    private Integer idTamanho = 0;
    private Integer tamanho = 0;
    private Integer idGrade = 0 ;
    private Integer Ativo = 0;

    /**
     * @return the idTamanho
     */
    public Integer getIdTamanho() {
        return idTamanho;
    }

    /**
     * @param idTamanho the idTamanho to set
     */
    public void setIdTamanho(Integer idTamanho) {
        this.idTamanho = idTamanho;
    }

    /**
     * @return the tamanho
     */
    public Integer getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the idGrade
     */
    public Integer getIdGrade() {
        return idGrade;
    }

    /**
     * @param idGrade the idGrade to set
     */
    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    /**
     * @return the Ativo
     */
    public Integer getAtivo() {
        return Ativo;
    }

    /**
     * @param Ativo the Ativo to set
     */
    public void setAtivo(Integer Ativo) {
        this.Ativo = Ativo;
    }
    
}
