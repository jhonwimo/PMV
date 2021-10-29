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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author jwmoreno
 */
@Entity
@Table(name = "TBL_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuarios.findAll", query = "SELECT t FROM TblUsuarios t"),
    @NamedQuery(name = "TblUsuarios.findById", query = "SELECT t FROM TblUsuarios t WHERE t.id = :id"),
    @NamedQuery(name = "TblUsuarios.findByNombreCompleto", query = "SELECT t FROM TblUsuarios t WHERE t.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "TblUsuarios.findByNombreUsuarioAndClave", query = "SELECT t FROM TblUsuarios t WHERE t.nombreUsuario = :nombreUsuario and t.clave= :clave "),
    @NamedQuery(name = "TblUsuarios.findByClave", query = "SELECT t FROM TblUsuarios t WHERE t.clave = :clave"),
    @NamedQuery(name = "TblUsuarios.findByFechaCreacion", query = "SELECT t FROM TblUsuarios t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblUsuarios.findByFechaUltimoIngreso", query = "SELECT t FROM TblUsuarios t WHERE t.fechaUltimoIngreso = :fechaUltimoIngreso"),
    @NamedQuery(name = "TblUsuarios.findByNivelAcceso", query = "SELECT t FROM TblUsuarios t WHERE t.nivelAcceso = :nivelAcceso")})
public class TblUsuarios implements Serializable {

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
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ULTIMO_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NIVEL_ACCESO")
    private String nivelAcceso;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
  @JsonIgnore
    private TblEstados idEstado;

    public TblUsuarios() {
    }

    public TblUsuarios(Long id) {
        this.id = id;
    }

    public TblUsuarios(Long id, String nombreCompleto, String nombreUsuario, String clave, Date fechaCreacion, Date fechaUltimoIngreso, String nivelAcceso) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoIngreso = fechaUltimoIngreso;
        this.nivelAcceso = nivelAcceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(Date fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public TblEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstados idEstado) {
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
        if (!(object instanceof TblUsuarios)) {
            return false;
        }
        TblUsuarios other = (TblUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.impos.pmv.model.entity.TblUsuarios[ id=" + id + " ]";
    }
    
}
