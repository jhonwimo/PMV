/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impos.pmv.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jwmoreno
 */
@Entity
@Table(name = "TBL_CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategoria.findAll", query = "SELECT t FROM TblCategoria t"),
    @NamedQuery(name = "TblCategoria.findByIdCategoria", query = "SELECT t FROM TblCategoria t WHERE t.idCategoria = :idCategoria"),
    @NamedQuery(name = "TblCategoria.findByNombre", query = "SELECT t FROM TblCategoria t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblCategoria.findByEstado", query = "SELECT t FROM TblCategoria t WHERE t.estado = :estado"),
    @NamedQuery(name = "TblCategoria.findByFechaCreacion", query = "SELECT t FROM TblCategoria t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblCategoria.findByFechaActualizacion", query = "SELECT t FROM TblCategoria t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TblCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
      @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;

    public TblCategoria() {
    }

    public TblCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TblCategoria(Long idCategoria, String nombre, String estado, Date fechaCreacion, Date fechaActualizacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategoria)) {
            return false;
        }
        TblCategoria other = (TblCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.impos.pmv.model.entity.TblCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
