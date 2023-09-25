package com.prueba.nexos.datos;



import java.util.List;
import com.prueba.nexos.domain.Empleado;
import com.prueba.nexos.domain.Departamentos;

public interface EmpleadoDao {
    public List<Empleado> findAllEmpleados();
    
    public Empleado findEmpleadoById(Empleado empleado);
    
    public Empleado findEmpleadoByEmail(Empleado empleado);
    
    public void insertEmpleado(Empleado empleado);
    
    public void updateEmpleado(Empleado empleado);
    
    public void deleteEmpleado(Empleado empleado);
    
    public  List<Departamentos> findAllDepartamentos();
    
}
