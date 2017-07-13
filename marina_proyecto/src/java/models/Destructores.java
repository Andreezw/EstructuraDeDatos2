/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JDevp
 */
@Entity
@Table(name = "destructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destructores.findAll", query = "SELECT d FROM Destructores d"),
    @NamedQuery(name = "Destructores.findByIdDestructores", query = "SELECT d FROM Destructores d WHERE d.idDestructores = :idDestructores"),
    @NamedQuery(name = "Destructores.findByPotencia", query = "SELECT d FROM Destructores d WHERE d.potencia = :potencia")})
public class Destructores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_destructores")
    private Integer idDestructores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "potencia")
    private String potencia;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Destructores() {
    }

    public Destructores(Integer idDestructores) {
        this.idDestructores = idDestructores;
    }

    public Destructores(Integer idDestructores, String potencia) {
        this.idDestructores = idDestructores;
        this.potencia = potencia;
    }

    public Integer getIdDestructores() {
        return idDestructores;
    }

    public void setIdDestructores(Integer idDestructores) {
        this.idDestructores = idDestructores;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public Barco getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(Barco idBarco) {
        this.idBarco = idBarco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestructores != null ? idDestructores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destructores)) {
            return false;
        }
        Destructores other = (Destructores) object;
        if ((this.idDestructores == null && other.idDestructores != null) || (this.idDestructores != null && !this.idDestructores.equals(other.idDestructores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Destructores[ idDestructores=" + idDestructores + " ]";
    }
    
}
