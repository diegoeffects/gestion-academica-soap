package ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import datos.Carrera;
import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.Usuario;
import negocio.InscripcionABM;
import negocio.CarreraABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;
import negocio.UsuarioABM;
import respuestas.MateriaInscripcionCarreraWS;
import respuestas.MateriasInscripcionCarreraWS;
import respuestas.RespuestaWS;
import respuestas.InscripcionEstudianteWS;
import respuestas.InscripcionWS;
import respuestas.InscripcionesEstudianteWS;
import respuestas.InscripcionesWS;

@WebService(endpointInterface="ws.Estudiantes")
public class EstudiantesImpl implements Estudiantes{

	// LISTADO DE INSCRIPCIONES ACTIVAS
	@Override
	public InscripcionesWS traerInscripcionesActivas() {
		
		InscripcionABM inscripcionABM = new InscripcionABM();
		
		List<Inscripcion> inscripciones =  inscripcionABM.traerInscripcionesActivas();
		
		InscripcionesWS inscripcionesWS = new InscripcionesWS(
				"No existen inscripciones activas",
				"EMPTY"			
		);
			
		if(inscripciones.size() != 0) {
			
			inscripcionesWS.setError("");
			inscripcionesWS.setEstado("SUCCESS");
			
			List<InscripcionWS> inscripcionesList = new ArrayList<InscripcionWS>();
			
			for (int i = 0; i < inscripciones.size(); i++) {
				
				InscripcionWS inscripcion = new InscripcionWS(
						String.valueOf(inscripciones.get(i).getIdInscripcion()),
						inscripciones.get(i).getDescripcion(),
						String.valueOf(inscripciones.get(i).getInstancia().getIdInstancia()),
						inscripciones.get(i).getInstancia().getInstancia()
				);		
				inscripcionesList.add(inscripcion);
				
			}
			
			inscripcionesWS.setInscripciones(inscripcionesList);
		
		}

		return inscripcionesWS;
		
	}

	// LISTADO DE INSCRIPCIONES POR ESTUDIANTE
	@Override
	public InscripcionesEstudianteWS traerInscripcionesPorEstudiante(int idUsuario) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		InscripcionesEstudianteWS inscripcionesEstudianteWS = new InscripcionesEstudianteWS(
				"El usuario no existe o no corresponde a un estudiante",
				"EMPTY"
		);
		
		if(usuario != null) {
			
			inscripcionesEstudianteWS.setError("El estudiante no posee inscripciones asociadas");
			inscripcionesEstudianteWS.setEstado("EMPTY");
			
			DetalleInscripcionABM detalleinscripcionABM = new DetalleInscripcionABM();
			List<DetalleInscripcion> inscripcionesEstudiante =  detalleinscripcionABM.traerDetallesInscripcionPorEstudiante(idUsuario);
			
			if(inscripcionesEstudiante.size() != 0) {
				
				inscripcionesEstudianteWS.setError("");
				inscripcionesEstudianteWS.setEstado("SUCCESS");
				
				List<InscripcionEstudianteWS> inscripcionesEstudianteList = new ArrayList<InscripcionEstudianteWS>();
				
				for (int i = 0; i < inscripcionesEstudiante.size(); i++) {
					
					String estado = "Activo";
					
					if(inscripcionesEstudiante.get(i).isBaja()) {
						estado = "No activo";
					}
					
					InscripcionEstudianteWS inscripcionEstudiante = new InscripcionEstudianteWS(
							String.valueOf(inscripcionesEstudiante.get(i).getIdDetalleInscripcion()),
							inscripcionesEstudiante.get(i).getComision().getMateria().getMateria(),
							inscripcionesEstudiante.get(i).getComision().getUsuario().getApellido() +
							", " + inscripcionesEstudiante.get(i).getComision().getUsuario().getNombre(),
							inscripcionesEstudiante.get(i).getInscripcion().getDescripcion(),
							inscripcionesEstudiante.get(i).getComision().getTurno().getTurno(),
							inscripcionesEstudiante.get(i).getComision().getAnio(),
							estado
					);
						
					inscripcionesEstudianteList.add(inscripcionEstudiante);
					
				}
				
				inscripcionesEstudianteWS.setInscripcionesEstudiante(inscripcionesEstudianteList);
				
			}
			
		}
			
		return inscripcionesEstudianteWS;
	}

	// LISTADO DE MATERIAS POR INSCRIPCION Y CARRERA
	@Override
	public MateriasInscripcionCarreraWS traerMateriasPorInscripcionPorCarrera(int idInscripcion, int idCarrera) {
		
		InscripcionABM inscripcionABM = new InscripcionABM();
		CarreraABM carreraABM = new CarreraABM();

		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
	
		MateriasInscripcionCarreraWS materiasInscripcionCarreraWS = new MateriasInscripcionCarreraWS(
				"No existen materias asociadas para los parametros especificados",
				"EMPTY"
		);
		
		if( (inscripcion != null) && (carrera != null) ) {
			
			ComisionABM comisionABM = new ComisionABM();
			
			List<Comision> materias =  comisionABM.traerComisionesPorInscripcionYCarrera(idInscripcion, idCarrera);
			
			if(materias.size() != 0) {
				
				materiasInscripcionCarreraWS.setError("");
				materiasInscripcionCarreraWS.setEstado("SUCCESS");
			
				List<MateriaInscripcionCarreraWS> materiasList = new ArrayList<MateriaInscripcionCarreraWS>();
				
				for (int i = 0; i < materias.size(); i++) {
					
					MateriaInscripcionCarreraWS materiaInscripcionCarrera = new MateriaInscripcionCarreraWS(
							String.valueOf(materias.get(i).getIdComision()),
							materias.get(i).getMateria().getMateria(),
							materias.get(i).getUsuario().getApellido() +
							", " + materias.get(i).getUsuario().getNombre(),
							materias.get(i).getInscripcion().getDescripcion(),
							materias.get(i).getTurno().getTurno()
					);
						
					materiasList.add(materiaInscripcionCarrera);
					
				}
				
				materiasInscripcionCarreraWS.setMateriasIncripcionCarrera(materiasList);
				
			}
			
		}
		
		return materiasInscripcionCarreraWS;
	}

	// ALTA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@Override
	public RespuestaWS altaInscripcionEstudiante(int idUsuario, int idInscripcion, int idComision) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		InscripcionABM inscripcionABM = new InscripcionABM();
		ComisionABM comisionABM = new ComisionABM();

		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Comision comision = comisionABM.traerComision(idComision);
		
		RespuestaWS respuestaWS = new RespuestaWS(
				"Algunos de los parametros no son correctos",
				"EMPTY"
		);
		
		if( (usuario != null) && (inscripcion != null) && (comision != null) ) {
			
			boolean agregado = false;
			
			DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
			
			Date date = new Date(); 
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    String fechaActual = dateFormat.format(date);
			
			try {
				agregado = detalleInscripcionABM.agregarDetalleInscripcion(inscripcion, comision, usuario, fechaActual, false);
			}
			catch(Exception e) {
				e.getMessage();
			}
			
			if(agregado) {
				respuestaWS.setError("");
				respuestaWS.setEstado("SUCCESS");
			}
			else {
				respuestaWS.setError("No se realizo el alta del estudiante");
				respuestaWS.setEstado("FAIL");
			}
			
		}

		return respuestaWS;
		
	}

	// BAJA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@Override
	public RespuestaWS bajaInscripcionEstudiante(int idDetalleInscripcion) {
		
		DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
		
		DetalleInscripcion detalleInscripcion = detalleInscripcionABM.traerDetalleInscripcion(idDetalleInscripcion);
		
		RespuestaWS respuestaWS = new RespuestaWS(
				"No existe una inscripcion con el identificador especificado",
				"EMPTY"
		);
		
		if(detalleInscripcion != null){
			
			boolean baja = false;
			
			try {
				baja = detalleInscripcionABM.bajaDetalleInscripcionBaja(detalleInscripcion);
			}
			catch(Exception e) {
				e.getMessage();
			}
			
			if(baja){
				respuestaWS.setError("");
				respuestaWS.setEstado("SUCCESS");
			}
			else {
				respuestaWS.setError("No se realizo la baja del estudiante");
				respuestaWS.setEstado("FAIL");
			}
				
		}

		return respuestaWS;
	}
	
	// ACTUALIZACION DATOS DE ESTUDIANTE
	@Override
	public RespuestaWS actualizarDatosUsuario(int idUsuario, String correo, String celular) {
	
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		RespuestaWS respuestaWS = new RespuestaWS(
				"El usuario no existe o no corresponde a un estudiante",
				"EMPTY"
		);
		
		if(usuario != null) {
			
			respuestaWS.setError("Falta especificar algunos de los parametros");
			respuestaWS.setEstado("EMPTY");
			
			if( (correo != "") && (celular != "") ){
				
				respuestaWS.setError("");
				respuestaWS.setEstado("SUCCESS");
				
				try {
					usuario =  usuarioABM.actualizarDatosUsuario(idUsuario, correo, celular);
				}
				catch(Exception e) {
					e.getMessage();
				}
				
			}
			
		}
		
		return respuestaWS;
		
	}

	// ACTUALIZACION DATOS DE ESTUDIANTE POR ADMINISTADOR
	@Override
	public RespuestaWS actualizarDatosUsuarioPorAdministrador(int idUsuario, String nombre, String apellido, String dni, String correo,
			String celular) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		RespuestaWS respuestaWS = new RespuestaWS(
				"El usuario no existe o no corresponde a un estudiante",
				"EMPTY"
		);
		
		if(usuario != null) {
			
			respuestaWS.setError("Falta especificar algunos de los parametros");
			respuestaWS.setEstado("EMPTY");
		
			if( (nombre != "") && (apellido != "") && (dni != "") && (correo != "") && (celular != "") ){
				
				respuestaWS.setError("");
				respuestaWS.setEstado("SUCCESS");
			
				try {
					usuario =  usuarioABM.actualizarDatosUsuario(idUsuario, nombre, apellido, dni, correo, celular);
				}
				catch(Exception e) {
					e.getMessage();
					
				}
				
			}
			
		}
		
		return respuestaWS;
		
	}

}
