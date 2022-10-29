package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import respuestas.ComisionesMateriaWS;
import respuestas.EstudiantesMateriaWS;
import respuestas.MateriasAprobadasWS;
import respuestas.MateriasInscripcionWS;

@WebService
public interface Reportes {
	
	// REPORTE ANALITICO DE ESTUDIANTE
	@WebMethod
	public MateriasAprobadasWS traerMateriasAprobadasPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	// REPORTE LISTADO DE ESTUDIANTES INSCRIPTOS
	@WebMethod
	public EstudiantesMateriaWS traerEstudiantesInscriptosPorMateria(@WebParam(name = "idComision") int idComision);
	
	// REPORTE LISTADO DE MATERIAS POR INSCRIPCION, CARRERA Y TURNO
	@WebMethod
	public MateriasInscripcionWS traerMateriasPorInscripcionYCarreraYTurno(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera,
			@WebParam(name = "idTurno") int idTurno);
	
	// LISTADO DE COMISIONES POR INSTANCIA Y MATERIA
	@WebMethod
	public ComisionesMateriaWS traerComisionesPorInstanciaYMateria(@WebParam(name = "idInstancia") int idInstancia, @WebParam(name = "idMateria") int idMateria);

}