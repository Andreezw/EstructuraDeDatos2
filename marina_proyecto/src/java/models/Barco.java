/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrezw
 */
@Entity
@Table(name = "barco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barco.findAll", query = "SELECT b FROM Barco b"),
    @NamedQuery(name = "Barco.findByIdBarco", query = "SELECT b FROM Barco b WHERE b.idBarco = :idBarco"),
    @NamedQuery(name = "Barco.findByNombre", query = "SELECT b FROM Barco b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Barco.findByTipo", query = "SELECT b FROM Barco b WHERE b.tipo = :tipo"),
    @NamedQuery(name = "Barco.findByAnio", query = "SELECT b FROM Barco b WHERE b.anio = :anio"),
    @NamedQuery(name = "Barco.findByDesplazamiento", query = "SELECT b FROM Barco b WHERE b.desplazamiento = :desplazamiento"),
    @NamedQuery(name = "Barco.findByAlcance", query = "SELECT b FROM Barco b WHERE b.alcance = :alcance"),
    @NamedQuery(name = "Barco.findByCalibre", query = "SELECT b FROM Barco b WHERE b.calibre = :calibre"),
    @NamedQuery(name = "Barco.findByTareaMisil", query = "SELECT b FROM Barco b WHERE b.tareaMisil = :tareaMisil"),
    @NamedQuery(name = "Barco.findByArmamento", query = "SELECT b FROM Barco b WHERE b.armamento = :armamento"),
    @NamedQuery(name = "Barco.findBySensores", query = "SELECT b FROM Barco b WHERE b.sensores = :sensores")})
public class Barco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_barco")
    private Integer idBarco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "anio")
    private String anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desplazamiento")
    private double desplazamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alcance")
    private String alcance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibre")
    private double calibre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tarea_misil")
    private String tareaMisil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "armamento")
    private String armamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sensores")
    private String sensores;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Corbeta> corbetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Disponibilidad> disponibilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Destructores> destructoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Fragata> fragataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Submarinos> submarinosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarco")
    private Collection<Rutas> rutasCollection;

    public Barco() {
    }

    public Barco(Integer idBarco) {
        this.idBarco = idBarco;
    }

    public Barco(Integer idBarco, String nombre, String tipo, String anio, double desplazamiento, String alcance, double calibre, String tareaMisil, String armamento, String sensores) {
        this.idBarco = idBarco;
        this.nombre = nombre;
        this.tipo = tipo;
        this.anio = anio;
        this.desplazamiento = desplazamiento;
        this.alcance = alcance;
        this.calibre = calibre;
        this.tareaMisil = tareaMisil;
        this.armamento = armamento;
        this.sensores = sensores;
    }

    public Integer getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(Integer idBarco) {
        this.idBarco = idBarco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(double desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    public String getTareaMisil() {
        return tareaMisil;
    }

    public void setTareaMisil(String tareaMisil) {
        this.tareaMisil = tareaMisil;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    public String getSensores() {
        return sensores;
    }

    public void setSensores(String sensores) {
        this.sensores = sensores;
    }

    @XmlTransient
    public Collection<Corbeta> getCorbetaCollection() {
        return corbetaCollection;
    }

    public void setCorbetaCollection(Collection<Corbeta> corbetaCollection) {
        this.corbetaCollection = corbetaCollection;
    }

    @XmlTransient
    public Collection<Disponibilidad> getDisponibilidadCollection() {
        return disponibilidadCollection;
    }

    public void setDisponibilidadCollection(Collection<Disponibilidad> disponibilidadCollection) {
        this.disponibilidadCollection = disponibilidadCollection;
    }

    @XmlTransient
    public Collection<Destructores> getDestructoresCollection() {
        return destructoresCollection;
    }

    public void setDestructoresCollection(Collection<Destructores> destructoresCollection) {
        this.destructoresCollection = destructoresCollection;
    }

    @XmlTransient
    public Collection<Fragata> getFragataCollection() {
        return fragataCollection;
    }

    public void setFragataCollection(Collection<Fragata> fragataCollection) {
        this.fragataCollection = fragataCollection;
    }

    @XmlTransient
    public Collection<Submarinos> getSubmarinosCollection() {
        return submarinosCollection;
    }

    public void setSubmarinosCollection(Collection<Submarinos> submarinosCollection) {
        this.submarinosCollection = submarinosCollection;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection() {
        return rutasCollection;
    }

    public void setRutasCollection(Collection<Rutas> rutasCollection) {
        this.rutasCollection = rutasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarco != null ? idBarco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barco)) {
            return false;
        }
        Barco other = (Barco) object;
        if ((this.idBarco == null && other.idBarco != null) || (this.idBarco != null && !this.idBarco.equals(other.idBarco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Barco[ idBarco=" + idBarco + " ]";
    }
    
}
