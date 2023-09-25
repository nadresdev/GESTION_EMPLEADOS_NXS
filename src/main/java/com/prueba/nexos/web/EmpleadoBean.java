package com.prueba.nexos.web;



import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;



import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;
import com.prueba.nexos.servicio.DepartamentosService;
import com.prueba.nexos.servicio.EmpleadoService;

@Named("empleadoBean")
@RequestScoped
public class EmpleadoBean {
    
   Logger log = LogManager.getRootLogger();
    
    @Inject
    private EmpleadoService empleadoService;

    private Empleado empleadoSeleccionado;
    
    @Inject
    private DepartamentosService departamentosService;
    
    List<Empleado> empleados;
    
    List<Departamentos> despartamentosList;
    
    public EmpleadoBean(){
        log.debug("Iniciando el objeto 	EmpleadoBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Inciamos las variables
    	
    	
        this.empleados = empleadoService.listarEmpleados();
       
        this.despartamentosList = departamentosService.listarDepartamentos();
        log.debug("empleados recuperadas en ManagedBean:" + this.empleados);
        this.empleadoSeleccionado = new Empleado();
        
    }
    
    public void editListener(RowEditEvent event){
    	Empleado empleado = (Empleado) event.getObject();
    	empleado.setFecha_hora_modifica(String.valueOf(new Date())) ;
    	empleado.setDepartamento(departamentosService.findDepartamentoXId(empleado.getDepartamento_id().longValue()));
        empleadoService.modificarEmpleado(empleado);
    }
    
      public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void agregarEmpleado(){
    	empleadoSeleccionado.setDepartamento(departamentosService.findDepartamentoXId(empleadoSeleccionado.getDepartamento_id().longValue()));
        this.empleadoService.registrarEmpleado(empleadoSeleccionado);
        this.empleados.add(empleadoSeleccionado);
        this.empleadoSeleccionado = null;
    }
    
    public void eliminarEmpleado(){
        this.empleadoService.eliminarEmpleado(empleadoSeleccionado);
        this.empleados.remove(this.empleadoSeleccionado);
        this.empleadoSeleccionado = null;
    }
    
    public void reiniciarEmpleadoSeleccionado(){
        this.empleadoSeleccionado = new Empleado();
    }
    
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new java.util.ArrayList<SelectItem>();
        List<Departamentos> departamentos = this.despartamentosList;
        for(Departamentos departamento: departamentos){
            SelectItem selectItem = new SelectItem(departamento.getId(),
            		departamento.getNombreDepartamento());
            selectItems.add(selectItem);
            
           
            //empleadoSeleccionado.setDepartamento(departamento);
            	//empleadoSeleccionado.setDepartamento_id(departamento.getId());
            
            //}
           
            
            
        }
        
        return selectItems;
    }
}
