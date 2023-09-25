package com.prueba.nexos.datos;



import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;

@Stateless 
public class DepartamentosDaoImpl implements DepartamentosDao{
    
	@PersistenceContext(unitName="test")
    EntityManager emd;

    @Override
    public List<Departamentos> findAllDepartamentos() {
    	
        return emd.createNamedQuery("Departamentos.findAll").getResultList();
        
    }
    
    
    public List<Departamentos> getDepartamentos() {
		

		
			Query query1 = emd.createQuery("from Departamentos p ");
			 query1.getResultList();
		


		return  query1.getResultList();
	}

    @Override
    public Departamentos findDepartamentosById(Departamentos departamento) {
        return emd.find(Departamentos.class, departamento.getId());
    }

     
    
    @Override
    public Departamentos findDepartamentoXId(Long idDepartamento) {
        Query query = emd.createQuery("from Departamentos d where d.id =: id");
        query.setParameter("id", idDepartamento.intValue());
        return (Departamentos) query.getSingleResult();
    }

    @Override
    public void insertDepartamentos(Departamentos departamento) {
    	
    	emd.persist(departamento);
    	emd.flush();
    }

    @Override
    public void updateDepartamentos(Departamentos departamento) {
    	emd.merge(departamento);
    	emd.flush();
    }

    @Override
    public void deleteDepartamentos(Departamentos departamento) {
    	emd.remove(emd.merge(departamento));
    	emd.flush();
    }

}
