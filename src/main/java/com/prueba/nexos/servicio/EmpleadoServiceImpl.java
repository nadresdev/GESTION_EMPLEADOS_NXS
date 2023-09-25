package com.prueba.nexos.servicio;



import java.util.List;

import com.prueba.nexos.datos.EmpleadoDao;
import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;

import jakarta.annotation.Resource;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService {

    @Inject
    private EmpleadoDao empleadoDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoDao.findAllEmpleados();
    }

    @Override
    public Empleado encontrarEmpleadoPorId(Empleado empleado) {
        return empleadoDao.findEmpleadoById(empleado);
    }

    @Override
    public Empleado encontrarEmpleadoPorEmail(Empleado empleado) {
        return empleadoDao.findEmpleadoByEmail(empleado);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        empleadoDao.insertEmpleado(empleado);
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoDao.updateEmpleado(empleado);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoDao.deleteEmpleado(empleado);
    }
    
    public List<Departamentos> findAllDepartamentos() {
        return empleadoDao.findAllDepartamentos();
    }
    

}


