package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import respuestas.RespuestaWS;
import respuestas.InscripcionesEstudianteWS;
import respuestas.InscripcionesWS;
import respuestas.MateriasInscripcionCarreraWS;

@WebService
public interface Estudiantes {
	
	// LISTADO DE INSCRIPCIONES ACTIVAS
	@WebMethod
	public InscripcionesWS traerInscripcionesActivas();
	
	// LISTADO DE INSCRIPCIONES POR ESTUDIANTE
	@WebMethod
	public InscripcionesEstudianteWS traerInscripcionesPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	// LISTADO DE MATERIAS POR INSCRIPCION Y CARRERA
	@WebMethod
	public MateriasInscripcionCarreraWS traerMateriasPorInscripcionPorCarrera(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera);
	
	// ALTA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@WebMethod
	public RespuestaWS altaInscripcionEstudiante(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idInscripcion") int idInscripcion,
			@WebParam(name = "idComision") int idComision);
	
	// BAJA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@WebMethod
	public RespuestaWS bajaInscripcionEstudiante(@WebParam(name = "idDetalleInscripcion") int idDetalleInscripcion);
	
	// ACTUALIZACION DATOS DE ESTUDIANTE
	@WebMethod
	public RespuestaWS actualizarDatosUsuario(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "correo") String correo,
			@WebParam(name = "celular") String celular, @WebParam(name = "clave") String clave);
	
}
