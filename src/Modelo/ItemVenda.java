/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "item_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByIdItemVenda", query = "SELECT i FROM ItemVenda i WHERE i.idItemVenda = :idItemVenda"),
    @NamedQuery(name = "ItemVenda.findByQTDProduto", query = "SELECT i FROM ItemVenda i WHERE i.qTDProduto = :qTDProduto")})
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Item_Venda")
    private Integer idItemVenda;
    @Column(name = "QTD_Produto")
    private Integer qTDProduto;
    @JoinColumn(name = "Id_Estoque", referencedColumnName = "Id_Estoque")
    @ManyToOne(optional = false)
    private Estoque idEstoque;
    @JoinColumn(name = "Id_Venda", referencedColumnName = "Id_Venda")
    @ManyToOne(optional = false)
    private Venda idVenda;

    public ItemVenda() {
    }

    public ItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Integer getQTDProduto() {
        return qTDProduto;
    }

    public void setQTDProduto(Integer qTDProduto) {
        this.qTDProduto = qTDProduto;
    }

    public Estoque getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Estoque idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Venda getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemVenda != null ? idItemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.idItemVenda == null && other.idItemVenda != null) || (this.idItemVenda != null && !this.idItemVenda.equals(other.idItemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ItemVenda[ idItemVenda=" + idItemVenda + " ]";
    }
    
}
