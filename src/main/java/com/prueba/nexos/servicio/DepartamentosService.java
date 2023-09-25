package com.prueba.nexos.servicio;



	import java.util.List;
	import jakarta.ejb.Local;

import com.prueba.nexos.domain.Departamentos;


	@Local
	public interface DepartamentosService {
	      public List<Departamentos> listarDepartamentos();
	    
	    public Departamentos encontrarDepartamentoPorId(Departamentos departamento);
	    
	    public void registrarDepartamentos(Departamentos departamento);
	    
	    public void modificarDepartamentos(Departamentos departamento);
	    
	    public void eliminarDepartamentos(Departamentos departamento);
	    
	    public Departamentos findDepartamentoXId(Long idDepartamento);
	    
	    public List<Departamentos> getDepartamentos();
	    
	}