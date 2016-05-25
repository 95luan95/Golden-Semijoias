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
public class ItemVendaDTO {
    private Integer idItemVenda;
    private Integer qtdProduto;
    private Integer idVenda;
    private Integer idEstoque;

    /**
     * @return the idItemVenda
     */
    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    /**
     * @param idItemVenda the idItemVenda to set
     */
    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    /**
     * @return the qtdProduto
     */
    public Integer getQtdProduto() {
        return qtdProduto;
    }

    /**
     * @param qtdProduto the qtdProduto to set
     */
    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    /**
     * @return the idVenda
     */
    public Integer getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idEstoque
     */
    public Integer getIdEstoque() {
        return idEstoque;
    }

    /**
     * @param idEstoque the idEstoque to set
     */
    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

}
