package com.prueba.nexos.servicio;



import com.prueba.nexos.datos.DepartamentosDao;
import com.prueba.nexos.domain.Departamentos;
import com.prueba.nexos.domain.Empleado;

import java.util.List;
	import jakarta.ejb.Stateless;
	import jakarta.inject.Inject;
	import jakarta.annotation.Resource;
	import jakarta.ejb.SessionContext;
	

	@Stateless
	public class DepartamentoServiceImpl implements DepartamentosService{

		
		 @Inject
		    private DepartamentosDao departamentosDao;
		 
		 @Resource
		    private SessionContext contexto;
		 
		@Override
		public List<Departamentos> listarDepartamentos() {
			 return departamentosDao.findAllDepartamentos();
			
		}

		@Override
		public Departamentos encontrarDepartamentoPorId(Departamentos departamento) {
			// TODO Auto-generated method stub
			return departamentosDao.findDepartamentosById(departamento);
		}

		@Override
		public void registrarDepartamentos(Departamentos departamento) {
			departamentosDao.insertDepartamentos(departamento);
			
		}

		
		  @Override
		    public void modificarDepartamentos(Departamentos departamentos) {
		        try {
		            departamentosDao.updateDepartamentos(departamentos);
		        } catch (Throwable t) {
		            contexto.setRollbackOnly();
		            t.printStackTrace(System.out);
		        }
		    }
		  
		    public Departamentos findDepartamentoXId(Long idDepartamento) {
		    	
		    	return departamentosDao.findDepartamentoXId(idDepartamento);
		    }

		@Override
		public void eliminarDepartamentos(Departamentos departamento) {
			departamentosDao.deleteDepartamentos(departamento);
			
		}
		
		public List<Departamentos> getDepartamentos() {
			 return departamentosDao.getDepartamentos();
			
		}
}