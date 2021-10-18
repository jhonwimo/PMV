
package com.impos.pmv.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "TBL_CATEGORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategorias.findAll", query = "SELECT t FROM TblCategorias t"),
    @NamedQuery(name = "TblCategorias.findByIdCategoria", query = "SELECT t FROM TblCategorias t WHERE t.idCategoria = :idCategoria"),
    @NamedQuery(name = "TblCategorias.findByNombre", query = "SELECT t FROM TblCategorias t WHERE t.nombre = :nombre"),
   
    @NamedQuery(name = "TblCategorias.findByFechaCreacion", query = "SELECT t FROM TblCategorias t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblCategorias.findByFechaActualizacion", query = "SELECT t FROM TblCategorias t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TblCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private TblEstados idEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<TblProductos> tblProductosCollection;

    public TblCategorias() {
    }

    public TblCategorias(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TblCategorias(Long idCategoria, String nombre, String estado, Date fechaCreacion, Date fechaActualizacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    
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
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }
    
    
    public TblEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstados idEstado) {
        this.idEstado = idEstado;
    }
   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategorias)) {
            return false;
        }
        TblCategorias other = (TblCategorias) object;
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
