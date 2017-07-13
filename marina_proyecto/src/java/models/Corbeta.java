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
@Table(name = "corbeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corbeta.findAll", query = "SELECT c FROM Corbeta c"),
    @NamedQuery(name = "Corbeta.findByIdCorbeta", query = "SELECT c FROM Corbeta c WHERE c.idCorbeta = :idCorbeta"),
    @NamedQuery(name = "Corbeta.findByPotencia", query = "SELECT c FROM Corbeta c WHERE c.potencia = :potencia")})
public class Corbeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_corbeta")
    private Integer idCorbeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "potencia")
    private String potencia;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Corbeta() {
    }

    public Corbeta(Integer idCorbeta) {
        this.idCorbeta = idCorbeta;
    }

    public Corbeta(Integer idCorbeta, String potencia) {
        this.idCorbeta = idCorbeta;
        this.potencia = potencia;
    }

    public Integer getIdCorbeta() {
        return idCorbeta;
    }

    public void setIdCorbeta(Integer idCorbeta) {
        this.idCorbeta = idCorbeta;
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
        hash += (idCorbeta != null ? idCorbeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corbeta)) {
            return false;
        }
        Corbeta other = (Corbeta) object;
        if ((this.idCorbeta == null && other.idCorbeta != null) || (this.idCorbeta != null && !this.idCorbeta.equals(other.idCorbeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Corbeta[ idCorbeta=" + idCorbeta + " ]";
    }
    
}
