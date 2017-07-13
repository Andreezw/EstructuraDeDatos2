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
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findByIdRutas", query = "SELECT r FROM Rutas r WHERE r.idRutas = :idRutas"),
    @NamedQuery(name = "Rutas.findByDiaSalida", query = "SELECT r FROM Rutas r WHERE r.diaSalida = :diaSalida"),
    @NamedQuery(name = "Rutas.findByDiaLlegada", query = "SELECT r FROM Rutas r WHERE r.diaLlegada = :diaLlegada")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rutas")
    private Integer idRutas;
    @Size(max = 255)
    @Column(name = "dia_salida")
    private String diaSalida;
    @Size(max = 255)
    @Column(name = "dia_llegada")
    private String diaLlegada;
    @JoinColumn(name = "id_barco", referencedColumnName = "id_barco")
    @ManyToOne(optional = false)
    private Barco idBarco;

    public Rutas() {
    }

    public Rutas(Integer idRutas) {
        this.idRutas = idRutas;
    }

    public Integer getIdRutas() {
        return idRutas;
    }

    public void setIdRutas(Integer idRutas) {
        this.idRutas = idRutas;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public String getDiaLlegada() {
        return diaLlegada;
    }

    public void setDiaLlegada(String diaLlegada) {
        this.diaLlegada = diaLlegada;
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
        hash += (idRutas != null ? idRutas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.idRutas == null && other.idRutas != null) || (this.idRutas != null && !this.idRutas.equals(other.idRutas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Rutas[ idRutas=" + idRutas + " ]";
    }
    
}
