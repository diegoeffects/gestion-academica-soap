package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Reportes {
	
	// REPORTE ANALITICO DE ESTUDIANTE
	@WebMethod
	public respuestas.MateriasAprobadasWS traerMateriasAprobadasPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	// REPORTE LISTADO DE ALUMNOS INSCRIPTOS
	@WebMethod
	public respuestas.EstudiantesMateriaWS traerEstudiantesInscriptosPorMateria(@WebParam(name = "idComision") int idComision);
	
	// REPORTE LISTADO DE MATERIAS
	@WebMethod
	public respuestas.MateriasInscripcionWS traerMateriasPorInscripcionYCarreraYTurno(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera,
			@WebParam(name = "idTurno") int idTurno);

}