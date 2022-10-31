package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dto.ComisionesMateriaDTO;
import dto.EstudiantesMateriaDTO;
import dto.MateriasAprobadasDTO;
import dto.MateriasInscripcionDTO;

@WebService
public interface Reportes {
	
	// REPORTE ANALITICO DE ESTUDIANTE
	@WebMethod
	public MateriasAprobadasDTO traerMateriasAprobadasPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	// REPORTE LISTADO DE ESTUDIANTES INSCRIPTOS
	@WebMethod
	public EstudiantesMateriaDTO traerEstudiantesInscriptosPorMateria(@WebParam(name = "idComision") int idComision);
	
	// REPORTE LISTADO DE MATERIAS POR INSCRIPCION, CARRERA Y TURNO
	@WebMethod
	public MateriasInscripcionDTO traerMateriasPorInscripcionYCarreraYTurno(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera,
			@WebParam(name = "idTurno") int idTurno);
	
	// LISTADO DE COMISIONES POR INSTANCIA Y MATERIA
	@WebMethod
	public ComisionesMateriaDTO traerComisionesPorInstanciaYMateria(@WebParam(name = "idInstancia") int idInstancia, @WebParam(name = "idMateria") int idMateria);

}