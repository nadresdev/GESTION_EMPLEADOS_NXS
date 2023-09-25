package com.prueba.nexos.domain;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;



@NamedQueries({
	 @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIdDepartamento", query = "SELECT d FROM Departamentos d WHERE d.id =:id"),
    @NamedQuery(name = "Departamentos.findByNombreDepartamento", query = "SELECT d FROM Departamentos d WHERE d.nombreDepartamento = :nombreDepartamento"),
         })
@Entity
@Table(name = "departamentos")
public class Departamentos implements Serializable {



	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id_departamento",unique = true)
     private Integer id;


    private String departamento_codigo;
    
    
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    
    private String fecha_hora_crea;
    
    private String fecha_hora_modifica;
    
    
    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleadosList;
    
	
	
	public Departamentos() {
	    }
 public Departamentos(Integer id, String departamento_codigo,
			 String nombreDepartamento, String fecha_hora_crea, String fecha_hora_modifica,List<Empleado> empleados
			) {

		this.id = id;
		this.departamento_codigo = departamento_codigo;
		this.nombreDepartamento = nombreDepartamento;
		this.fecha_hora_crea = fecha_hora_crea;
		this.fecha_hora_modifica = fecha_hora_modifica;
		this.empleadosList = empleados;
		
	}

	public Departamentos(Integer id) {
     this.id = id;
 }

	@PrePersist
	public void prePersist() {
		this.fecha_hora_crea= String.valueOf(new Date()) ;
		
		
		
	}
	 public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
   
    
  

    public String getNombreDepartamento() {
    	return nombreDepartamento ;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
       this.nombreDepartamento = nombreDepartamento;
    	
    }

    
    public String getDepartamento_codigo() {
 		return departamento_codigo;
 	}

 	public void setDepartamento_codigo(String despartamento_codigo) {
 		this.departamento_codigo = despartamento_codigo;
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




  
    
  

   
   

    @Override
    public String toString() {
        return "departamento{" + "id=" + this.id + ", nombreDepartamento=" + nombreDepartamento + ", fecha_hora_crea=" + fecha_hora_crea + ", fecha_hora_modifica=" + fecha_hora_modifica + '}';
    }

}
