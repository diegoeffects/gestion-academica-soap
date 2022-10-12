package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.HistorialAcademicoDao;
import datos.HistorialAcademico;

public class HistorialAcademicoABM {
	
	HistorialAcademicoDao dao = new HistorialAcademicoDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER HISTORIAL ACADEMICO
	public HistorialAcademico traerHistorialAcademico(int idHistorialAcademico) {
		HistorialAcademico objeto = dao.traerHistorialAcacademico(idHistorialAcademico);
		return objeto;
	}
	
	// TRAER HISTORIAL ACADEMICO POR ESTUDIANTE
	public List<HistorialAcademico> traerHistorialAcademicoPorEstudiante(int idUsuario) throws HibernateException {
		return dao.traerHistorialAcademicoPorEstudiante(idUsuario);
	}

}