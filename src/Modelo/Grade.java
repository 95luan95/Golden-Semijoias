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
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findByIdGrade", query = "SELECT g FROM Grade g WHERE g.idGrade = :idGrade"),
    @NamedQuery(name = "Grade.findByNome", query = "SELECT g FROM Grade g WHERE g.nome = :nome"),
    @NamedQuery(name = "Grade.findByAtivo", query = "SELECT g FROM Grade g WHERE g.ativo = :ativo")})
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Grade")
    private Integer idGrade;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Ativo")
    private Integer ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrade")
    private Collection<Tamanho> tamanhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrade")
    private Collection<Produto> produtoCollection;

    public Grade() {
    }

    public Grade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<Tamanho> getTamanhoCollection() {
        return tamanhoCollection;
    }

    public void setTamanhoCollection(Collection<Tamanho> tamanhoCollection) {
        this.tamanhoCollection = tamanhoCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrade != null ? idGrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.idGrade == null && other.idGrade != null) || (this.idGrade != null && !this.idGrade.equals(other.idGrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Grade[ idGrade=" + idGrade + " ]";
    }
    
}
