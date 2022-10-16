package ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Reportes {
	
	// ANALITICO DE ESTUDIANTE
	
	@WebMethod
	public List<respuestas.HistorialAcademicoWS> traerHistorialAcademicoPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	@WebMethod
	public respuestas.EstudianteCarreraWS traerEstudianteConCarrera(@WebParam(name = "idUsuario") int idUsuario);
	
	// LISTADO DE ESTUDIANTES INCRIPTOS A LA CURSADA DE UNA MATERIA
	
	//Devolver una lista de estudiantes inscriptos a una comision de cursada -> idComision
	
	// LISTADO DE ESTUDIANTES INCRIPTOS AL FINAL DE UNA MATERIA
	
	//Devolver una lista de estudiantes inscriptos a una comision de final -> idComision
	
	// LISTADO DE MATERIAS DE UN CUATRIMESTRE POR CARRERA
	// LISTADO DE MATERIAS DE UN LLAMADO POR CARRERA
	
	public List<respuestas.ComisionBWS> traerComisionesPorInscripcionYCarrera(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera);
	
	public respuestas.PlanillaMateriasWS traerCabeceraPlanillaMaterias(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera);	

}