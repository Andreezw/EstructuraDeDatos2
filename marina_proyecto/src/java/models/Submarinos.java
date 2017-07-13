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
@Table(name = "submarinos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submarinos.findAll", query = "SELECT s FROM Submarinos s"),
    @NamedQuery(name = "Submarinos.findByIdSubmarinos", query = "SELECT s FROM Submarinos s WHERE s.idSubmarinos = :idSubmarinos"),
    @NamedQuery(name = "Submarinos.findByPropulsion", query = "SELECT s FROM Submarinos s WHERE s.propulsion = :propulsion"),
    @NamedQuery(name = "Submarinos.findByInmersion", query = "SELECT s FROM Submarinos s WHERE s.inmersion = :inmersion")})
public class Submarinos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_submarinos")
    private Integer idSubmarinos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "propulsion")
    private String propulsion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "inmersion")
    private String inmersion;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Submarinos() {
    }

    public Submarinos(Integer idSubmarinos) {
        this.idSubmarinos = idSubmarinos;
    }

    public Submarinos(Integer idSubmarinos, String propulsion, String inmersion) {
        this.idSubmarinos = idSubmarinos;
        this.propulsion = propulsion;
        this.inmersion = inmersion;
    }

    public Integer getIdSubmarinos() {
        return idSubmarinos;
    }

    public void setIdSubmarinos(Integer idSubmarinos) {
        this.idSubmarinos = idSubmarinos;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public String getInmersion() {
        return inmersion;
    }

    public void setInmersion(String inmersion) {
        this.inmersion = inmersion;
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
        hash += (idSubmarinos != null ? idSubmarinos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submarinos)) {
            return false;
        }
        Submarinos other = (Submarinos) object;
        if ((this.idSubmarinos == null && other.idSubmarinos != null) || (this.idSubmarinos != null && !this.idSubmarinos.equals(other.idSubmarinos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Submarinos[ idSubmarinos=" + idSubmarinos + " ]";
    }
    
}
