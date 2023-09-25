package com.prueba.nexos.datos;



import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;

@Stateless 
public class EmpleadoDaoImpl implements EmpleadoDao{
    
    @PersistenceContext(unitName="test")
    EntityManager em;

    @Override
    public List<Empleado> findAllEmpleados() {
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Override
    public Empleado findEmpleadoById(Empleado empleado) {
        return em.find(Empleado.class, empleado.getIdEmpleado());
    }

    @Override
    public Empleado findEmpleadoByEmail(Empleado empleado) {
        Query query = em.createQuery("from Empleado p where p.email =: email");
        query.setParameter("email", empleado.getEmail());
        return (Empleado) query.getSingleResult();
    }

    @Override
    public void insertEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        em.remove(em.merge(empleado));
    }

	@Override
	public List<Departamentos> findAllDepartamentos() {
		em.createNamedQuery("Empleado.findAllDepartamentos").getFirstResult();
		return null;
	}
    
    
    
}
