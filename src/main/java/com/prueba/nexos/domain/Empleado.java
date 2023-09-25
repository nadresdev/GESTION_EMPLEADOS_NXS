package com.prueba.nexos.domain;

import java.io.Serializable;
import java.util.Date;

import com.prueba.nexos.servicio.DepartamentosService;

import jakarta.persistence.*;


@Entity
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT p FROM Empleado p"),
    @NamedQuery(name = "Empleado.findByIdPersona", query = "SELECT p FROM Empleado p WHERE p.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT p FROM Empleado p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT p FROM Empleado p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByEmail", query = "SELECT p FROM Empleado p WHERE p.email = :email"),
    @NamedQuery(name = "Empleado.findAllDepartamentos", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT p FROM Empleado p WHERE p.telefono = :telefono")})

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "documento_tipo")
    private String documentoTipo;
    
    @Column(name = "documento_numero")
    private String documentoNumero;
    
  
    private String nombres;

    private String apellidos;
   @Column(insertable = false, updatable = false)
    private Integer departamento_id;
    
 
    private String ciudad; 
    
   
    private String direccion;
    
   
    private String email;
  
    private String telefono;
    
    private String fecha_hora_crea;
    
    private String fecha_hora_modifica;
    
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Departamentos departamento;
    
    
    public Empleado() {
    }

   
    
    public Empleado(Integer idEmpleado, String documentoTipo, String documentoNumero,  String nombres,
			 String apellidos, Integer departamento_id, String ciudad, String direccion, String email,
			 String telefono, String fecha_hora_crea, String fecha_hora_modifica,
			Departamentos departamento) {
		
		this.idEmpleado = idEmpleado;
		this.documentoTipo = documentoTipo;
		this.documentoNumero = documentoNumero;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.departamento_id = departamento_id;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fecha_hora_crea = fecha_hora_crea;
		this.fecha_hora_modifica = fecha_hora_modifica;
		this.departamento = departamento;
	}



	public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

	
	@PrePersist
	public void prePersist() {
		fecha_hora_crea= String.valueOf(new Date()) ;
		
		
	}
   

    
    
    


	public Integer getIdEmpleado() {
		return idEmpleado;
	}



	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}



	public String getDocumentoTipo() {
		return documentoTipo;
	}



	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}



	public String getDocumentoNumero() {
		return documentoNumero;
	}



	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public Integer getDepartamento_id() {
		//departamento_id = getDepartamento().getIdDepartamento();
		return  departamento_id;
	}



	public void setDepartamento_id(Integer departamento_id) {
		this.departamento_id = departamento_id;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getFecha_hora_crea() {
		return fecha_hora_crea;
	}



	public void setFecha_hora_crea(String fecha_hora_crea) {
		this.fecha_hora_crea = fecha_hora_crea;
	}



	public String getFecha_hora_modifica() {
		return fecha_hora_modifica;
	}



	public void setFecha_hora_modifica(String fecha_hora_modifica) {
		this.fecha_hora_modifica = fecha_hora_modifica;
	}



	public Departamentos getDepartamento() {
		
		
		
		return departamento;
	}



	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}
	
	
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + '}';
    }


}
