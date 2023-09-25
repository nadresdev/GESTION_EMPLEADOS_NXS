package com.prueba.nexos.datos;

import java.util.List;

import com.prueba.nexos.domain.Departamentos;



public interface DepartamentosDao {
    public List<Departamentos> findAllDepartamentos();
    
    public Departamentos findDepartamentosById(Departamentos departamentos);
    
    public void insertDepartamentos(Departamentos departamentos);
    
    public void updateDepartamentos(Departamentos departamentos );
    
    public void deleteDepartamentos(Departamentos departamentos);
    
    public Departamentos findDepartamentoXId(Long idDepartamento);
    
    public List<Departamentos> getDepartamentos();
    
}
