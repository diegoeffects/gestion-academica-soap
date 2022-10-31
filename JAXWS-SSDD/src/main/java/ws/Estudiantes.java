package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dto.InscripcionesEstudianteDTO;
import dto.InscripcionesDTO;
import dto.MateriasInscripcionCarreraDTO;
import dto.RespuestaDTO;

@WebService
public interface Estudiantes {
	
	// LISTADO DE INSCRIPCIONES ACTIVAS
	@WebMethod
	public InscripcionesDTO traerInscripcionesActivas();
	
	// LISTADO DE INSCRIPCIONES POR ESTUDIANTE
	@WebMethod
	public InscripcionesEstudianteDTO traerInscripcionesPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	// LISTADO DE MATERIAS POR INSCRIPCION Y CARRERA
	@WebMethod
	public MateriasInscripcionCarreraDTO traerMateriasPorInscripcionPorCarrera(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera);
	
	// ALTA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@WebMethod
	public RespuestaDTO altaInscripcionEstudiante(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idInscripcion") int idInscripcion,
			@WebParam(name = "idComision") int idComision);
	
	// BAJA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@WebMethod
	public RespuestaDTO bajaInscripcionEstudiante(@WebParam(name = "idDetalleInscripcion") int idDetalleInscripcion);
	
	// ACTUALIZACION DATOS DE ESTUDIANTE
	@WebMethod
	public RespuestaDTO actualizarDatosUsuario(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "correo") String correo,
			@WebParam(name = "celular") String celular, @WebParam(name = "clave") String clave);
	
}
