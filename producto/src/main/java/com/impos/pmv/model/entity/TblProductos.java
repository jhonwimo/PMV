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
@Table(name = "TBL_PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductos.findAll", query = "SELECT t FROM TblProductos t"),
    @NamedQuery(name = "TblProductos.findById", query = "SELECT t FROM TblProductos t WHERE t.id = :id"),
    @NamedQuery(name = "TblProductos.findByNombre", query = "SELECT t FROM TblProductos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblProductos.findByIdCategoria", query = "SELECT t FROM TblProductos t WHERE t.idCategoria = :idCategoria"),
    @NamedQuery(name = "TblProductos.findByCosto", query = "SELECT t FROM TblProductos t WHERE t.costo = :costo"),
    @NamedQuery(name = "TblProductos.findByPrecio", query = "SELECT t FROM TblProductos t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblProductos.findByListatag", query = "SELECT t FROM TblProductos t WHERE t.listatag = :listatag"),
    @NamedQuery(name = "TblProductos.findByFechaCreacion", query = "SELECT t FROM TblProductos t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblProductos.findByFechaActualizacion", query = "SELECT t FROM TblProductos t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TblProductos.findByIdEstado", query = "SELECT t FROM TblProductos t WHERE t.idEstado = :idEstado")})
public class TblProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIA")
    private long idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private long precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LISTATAG")
    private String listatag;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO")
    private Character idEstado;

    public TblProductos() {
    }

    public TblProductos(Long id) {
        this.id = id;
    }

    public TblProductos(Long id, String nombre, long idCategoria, long costo, long precio, String listatag, Date fechaCreacion, Date fechaActualizacion, Character idEstado) {
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.costo = costo;
        this.precio = precio;
        this.listatag = listatag;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.idEstado = idEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getListatag() {
        return listatag;
    }

    public void setListatag(String listatag) {
        this.listatag = listatag;
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

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductos)) {
            return false;
        }
        TblProductos other = (TblProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.impos.pmv.model.entity.TblProductos[ id=" + id + " ]";
    }
    
}
