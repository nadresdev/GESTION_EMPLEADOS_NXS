package com.prueba.nexos.web;


	import java.util.ArrayList;
import java.util.Date;
import java.util.List;
	import jakarta.annotation.PostConstruct;
	import jakarta.enterprise.context.RequestScoped;
	import jakarta.inject.Inject;
	import jakarta.inject.Named;

	import org.apache.logging.log4j.*;
	import org.primefaces.event.RowEditEvent;

import com.prueba.nexos.domain.Departamentos;

import com.prueba.nexos.servicio.DepartamentosService;


	@Named("departamentosBean")
	@RequestScoped
	public class DepartamentosBean {
	    
	   Logger log = LogManager.getRootLogger();
	    
	    @Inject
	    private DepartamentosService departamentosService;

	    private Departamentos departamentoSeleccionado;
	    
	    List<Departamentos> departamentos;
	    
	    public DepartamentosBean(){
	        log.debug("Iniciando el objeto 	Departamentos");
	    }
	    
	    @PostConstruct
	    public void inicializar(){
	        //Inciamos las variables
	        this.departamentos = departamentosService.listarDepartamentos();
	        log.debug("departamentos recuperadas en ManagedBean:" + this.departamentos);
	        this.departamentoSeleccionado = new Departamentos();
	    }
	    
	    public void editListener(RowEditEvent event){
	    	Departamentos departamentos = (Departamentos) event.getObject();
	    	departamentos.setFecha_hora_modifica(String.valueOf(new Date())) ;
	        departamentosService.modificarDepartamentos(departamentos);
	    }
	    
	      public Departamentos getDepartamentoSeleccionado() {
	        return departamentoSeleccionado;
	    }

	    public void setDepartamentoSeleccionado(Departamentos departamentoSeleccionado) {
	        this.departamentoSeleccionado = departamentoSeleccionado;
	    }

	    public List<Departamentos> getDepartamentos() {
	        return departamentos;
	    }

	    public void setDepartamentos(List<Departamentos> departamentos) {
	        this.departamentos = departamentos;
	    }
	    
	    public void agregarDepartamento(){
	        this.departamentosService.registrarDepartamentos(departamentoSeleccionado);
	        this.departamentos.add(departamentoSeleccionado);
	       
	        this.departamentoSeleccionado = null;
	    }
	    
	    public void eliminarDepartamento(){
	            this.departamentosService.eliminarDepartamentos(departamentoSeleccionado);
		        this.departamentos.remove(departamentoSeleccionado);
		        this.departamentoSeleccionado = null;
	       
	    }
	    
	    public void reiniciarDepartamentoSeleccionado(){
	        this.departamentoSeleccionado = new Departamentos();
	    }
	}

