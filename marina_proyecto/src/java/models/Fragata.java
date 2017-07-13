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
@Table(name = "fragata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fragata.findAll", query = "SELECT f FROM Fragata f"),
    @NamedQuery(name = "Fragata.findByIdFragata", query = "SELECT f FROM Fragata f WHERE f.idFragata = :idFragata"),
    @NamedQuery(name = "Fragata.findByGuerraElectronica", query = "SELECT f FROM Fragata f WHERE f.guerraElectronica = :guerraElectronica")})
public class Fragata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fragata")
    private Integer idFragata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "guerra_electronica")
    private String guerraElectronica;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Fragata() {
    }

    public Fragata(Integer idFragata) {
        this.idFragata = idFragata;
    }

    public Fragata(Integer idFragata, String guerraElectronica) {
        this.idFragata = idFragata;
        this.guerraElectronica = guerraElectronica;
    }

    public Integer getIdFragata() {
        return idFragata;
    }

    public void setIdFragata(Integer idFragata) {
        this.idFragata = idFragata;
    }

    public String getGuerraElectronica() {
        return guerraElectronica;
    }

    public void setGuerraElectronica(String guerraElectronica) {
        this.guerraElectronica = guerraElectronica;
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
        hash += (idFragata != null ? idFragata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fragata)) {
            return false;
        }
        Fragata other = (Fragata) object;
        if ((this.idFragata == null && other.idFragata != null) || (this.idFragata != null && !this.idFragata.equals(other.idFragata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Fragata[ idFragata=" + idFragata + " ]";
    }
    
}
