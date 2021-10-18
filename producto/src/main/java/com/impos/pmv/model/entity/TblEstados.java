package com.impos.pmv.model.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author jhonw
 */


@Entity
@Table(name = "TBL_ESTADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstados.findAll", query = "SELECT t FROM TblEstados t"),
    @NamedQuery(name = "TblEstados.findByIdEstado", query = "SELECT t FROM TblEstados t WHERE t.idEstado = :idEstado"),
    @NamedQuery(name = "TblEstados.findByEstado", query = "SELECT t FROM TblEstados t WHERE t.estado = :estado"),
    @NamedQuery(name = "TblEstados.findByDescripcion", query = "SELECT t FROM TblEstados t WHERE t.descripcion = :descripcion")})
public class TblEstados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Long idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<TblUsuarios> tblUsuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<TblProductos> tblProductosCollection;

    public TblEstados() {
    }

    public TblEstados(Long idEstado) {
        this.idEstado = idEstado;
    }

    public TblEstados(Long idEstado, String estado, String descripcion) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonIgnore 
    public Collection<TblUsuarios> getTblUsuariosCollection() {
        return tblUsuariosCollection;
    }

    public void setTblUsuariosCollection(Collection<TblUsuarios> tblUsuariosCollection) {
        this.tblUsuariosCollection = tblUsuariosCollection;
    }

    @XmlTransient
    @JsonIgnore 
    public Collection<TblProductos> getTblProductosCollection() {
        return tblProductosCollection;
    }

    public void setTblProductosCollection(Collection<TblProductos> tblProductosCollection) {
        this.tblProductosCollection = tblProductosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstados)) {
            return false;
        }
        TblEstados other = (TblEstados) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.impos.pmv.model.entity.TblEstados[ idEstado=" + idEstado + " ]";
    }
    
}
