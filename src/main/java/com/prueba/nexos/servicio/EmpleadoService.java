package com.prueba.nexos.servicio;



import java.util.List;
import jakarta.ejb.Local;

import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;

@Local
public interface EmpleadoService {
      public List<Empleado> listarEmpleados();
    
    public Empleado encontrarEmpleadoPorId(Empleado empleado);
    
    public Empleado encontrarEmpleadoPorEmail(Empleado empleado);
    
    public void registrarEmpleado(Empleado empleado);
    
    public void modificarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Empleado empleado);
    
    public  List<Departamentos> findAllDepartamentos();
    
}

