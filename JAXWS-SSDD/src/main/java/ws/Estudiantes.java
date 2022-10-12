package ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Estudiantes {
	
	// INSCRIPCION DE UN ESTUDIANTE
	
	@WebMethod
	public List<respuestas.InscripcionWS> traerInscripciones();
	
	@WebMethod
	public List<respuestas.DetalleEstudianteWS> traerDetallesInscripcionPorEstudiante(@WebParam(name = "idUsuario") int idUsuario);
	
	@WebMethod
	public List<respuestas.ComisionWS> traerMateriasPorInscripcionPorCarrera(@WebParam(name = "idInscripcion") int idInscripcion, @WebParam(name = "idCarrera") int idCarrera);
	
	@WebMethod
	public boolean agregarDetalleInscripcion(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idInscripcion") int idInscripcion,
			@WebParam(name = "idComision") int idComision);
	
	@WebMethod
	public boolean bajaDetalleInscripcion(@WebParam(name = "idDetalleInscripcion") int idDetalleInscripcion);
	
	// MODIFICACION DATOS USUARIO
	
	@WebMethod
	public datos.Usuario actualizarDatosUsuario(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "correo") String correo,
			@WebParam(name = "celular") String celular);
	
	@WebMethod
	public datos.Usuario actualizarDatosUsuarioPorAdministrador(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "nombre") String nombre,
			@WebParam(name = "apellido") String apellido, @WebParam(name = "dni") String dni,
			@WebParam(name = "correo") String correo, @WebParam(name = "celular") String celular);
	
}
