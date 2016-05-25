/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "tamanho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tamanho.findAll", query = "SELECT t FROM Tamanho t"),
    @NamedQuery(name = "Tamanho.findByIdTamanho", query = "SELECT t FROM Tamanho t WHERE t.idTamanho = :idTamanho"),
    @NamedQuery(name = "Tamanho.findByTamanho", query = "SELECT t FROM Tamanho t WHERE t.tamanho = :tamanho"),
    @NamedQuery(name = "Tamanho.findByAtivo", query = "SELECT t FROM Tamanho t WHERE t.ativo = :ativo")})
public class Tamanho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Tamanho")
    private Integer idTamanho;
    @Column(name = "Tamanho")
    private Integer tamanho;
    @Column(name = "Ativo")
    private Integer ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTamanho")
    private Collection<Estoque> estoqueCollection;
    @JoinColumn(name = "Id_Grade", referencedColumnName = "Id_Grade")
    @ManyToOne(optional = false)
    private Grade idGrade;

    public Tamanho() {
    }

    public Tamanho(Integer idTamanho) {
        this.idTamanho = idTamanho;
    }

    public Integer getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(Integer idTamanho) {
        this.idTamanho = idTamanho;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<Estoque> getEstoqueCollection() {
        return estoqueCollection;
    }

    public void setEstoqueCollection(Collection<Estoque> estoqueCollection) {
        this.estoqueCollection = estoqueCollection;
    }

    public Grade getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Grade idGrade) {
        this.idGrade = idGrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTamanho != null ? idTamanho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tamanho)) {
            return false;
        }
        Tamanho other = (Tamanho) object;
        if ((this.idTamanho == null && other.idTamanho != null) || (this.idTamanho != null && !this.idTamanho.equals(other.idTamanho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tamanho[ idTamanho=" + idTamanho + " ]";
    }
    
}
