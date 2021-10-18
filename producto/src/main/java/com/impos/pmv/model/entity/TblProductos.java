package com.impos.pmv.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhonw
 */


@Entity
@Table(name = "TBL_PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductos.findAll", query = "SELECT t FROM TblProductos t"),
    @NamedQuery(name = "TblProductos.findById", query = "SELECT t FROM TblProductos t WHERE t.id = :id"),
    @NamedQuery(name = "TblProductos.findByNombre", query = "SELECT t FROM TblProductos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblProductos.findByCosto", query = "SELECT t FROM TblProductos t WHERE t.costo = :costo"),
    @NamedQuery(name = "TblProductos.findByPrecio", query = "SELECT t FROM TblProductos t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblProductos.findByListaTag", query = "SELECT t FROM TblProductos t WHERE t.tag = :tag"),
    @NamedQuery(name = "TblProductos.findByFechaCreacion", query = "SELECT t FROM TblProductos t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblProductos.findByFechaActualizacion", query = "SELECT t FROM TblProductos t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TblProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tag")
    private String tag;
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
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private TblCategorias idCategoria;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private TblEstados idEstado;

    public TblProductos() {
    }

    public TblProductos(Integer id) {
        this.id = id;
    }

    public TblProductos(Integer id, String nombre, long costo, long precio, String listaTag, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.precio = precio;
        this.tag = listaTag;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

   

   

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

 

 

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

    public TblCategorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(TblCategorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TblEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstados idEstado) {
        this.idEstado = idEstado;
    }
   

    

    @Override
    public String toString() {
        return "com.impos.pmv.model.entity.TblProductos[ id=" + id + " ]";
    }
    
}
