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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JDevp
 */
@Entity
@Table(name = "disponibilidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilidad.findAll", query = "SELECT d FROM Disponibilidad d"),
    @NamedQuery(name = "Disponibilidad.findByIdDisponibilidad", query = "SELECT d FROM Disponibilidad d WHERE d.idDisponibilidad = :idDisponibilidad"),
    @NamedQuery(name = "Disponibilidad.findByEstado", query = "SELECT d FROM Disponibilidad d WHERE d.estado = :estado")})
public class Disponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disponibilidad")
    private Integer idDisponibilidad;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Disponibilidad() {
    }

    public Disponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public Integer getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Integer idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idDisponibilidad != null ? idDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilidad)) {
            return false;
        }
        Disponibilidad other = (Disponibilidad) object;
        if ((this.idDisponibilidad == null && other.idDisponibilidad != null) || (this.idDisponibilidad != null && !this.idDisponibilidad.equals(other.idDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Disponibilidad[ idDisponibilidad=" + idDisponibilidad + " ]";
    }
    
}
