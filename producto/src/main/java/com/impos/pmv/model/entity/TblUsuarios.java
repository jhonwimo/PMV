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
@Table(name = "TBL_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuarios.findAll", query = "SELECT t FROM TblUsuarios t"),
    @NamedQuery(name = "TblUsuarios.findById", query = "SELECT t FROM TblUsuarios t WHERE t.id = :id"),
    @NamedQuery(name = "TblUsuarios.findByNombreCompleto", query = "SELECT t FROM TblUsuarios t WHERE t.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "TblUsuarios.findByNombreUsuario", query = "SELECT t FROM TblUsuarios t WHERE t.nombreUsuario = :nombreUsuario "),
    @NamedQuery(name = "TblUsuarios.findByClave", query = "SELECT t FROM TblUsuarios t WHERE t.clave = :clave"),
    @NamedQuery(name = "TblUsuarios.findByFechaCreacion", query = "SELECT t FROM TblUsuarios t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TblUsuarios.findByFechaUltimoIngreso", query = "SELECT t FROM TblUsuarios t WHERE t.fechaUltimoIngreso = :fechaUltimoIngreso"),
    @NamedQuery(name = "TblUsuarios.findByNivelAcceso", query = "SELECT t FROM TblUsuarios t WHERE t.nivelAcceso = :nivelAcceso")})
public class TblUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ultimo_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoIngreso;
  
 
    
    @Basic(optional = false)
    @JoinColumn(name = "nivel_acceso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblRoles nivelAcceso;
    
    
    
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private TblEstados idEstado;

    public TblUsuarios() {
    }

    public TblUsuarios(Long id) {
        this.id = id;
    }

    public TblUsuarios(Long id, String nombreCompleto, String nombreUsuario, String clave, Date fechaCreacion, Date fechaUltimoIngreso) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoIngreso = fechaUltimoIngreso;

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

	public TblRoles getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(TblRoles nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}
    
    
    
}
