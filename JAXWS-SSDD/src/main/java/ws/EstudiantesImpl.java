package ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.Usuario;
import negocio.InscripcionABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;
import negocio.UsuarioABM;
import respuestas.ComisionWS;
import respuestas.DetalleEstudianteWS;
import respuestas.InscripcionWS;

@WebService(endpointInterface="ws.Estudiantes")
public class EstudiantesImpl implements Estudiantes{

	@Override
	public List<InscripcionWS> traerInscripciones() {
		
		InscripcionABM inscripcionABM = new InscripcionABM();
		
		List<Inscripcion> inscripciones =  inscripcionABM.traerInscripcionesActivas();
		
		List<InscripcionWS> inscripcionesList = new ArrayList<InscripcionWS>();
		
		for (int i = 0; i < inscripciones.size(); i++) {
			
			InscripcionWS inscripcion = new InscripcionWS(
					inscripciones.get(i).getIdInscripcion(),
					inscripciones.get(i).getDescripcion(),
					inscripciones.get(i).getInstancia().getInstancia()
			);		
			inscripcionesList.add(inscripcion);
			
		}
		
		return inscripcionesList;
		
	}

	@Override
	public List<DetalleEstudianteWS> traerDetallesInscripcionPorEstudiante(int idUsuario) {
		
		DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
		
		List<DetalleInscripcion> detalleInscripcionesEstudiante =  detalleInscripcionABM.traerDetallesInscripcionPorEstudiante(idUsuario);
		
		List<DetalleEstudianteWS> detallesEstudianteList = new ArrayList<DetalleEstudianteWS>();
		
		for (int i = 0; i < detalleInscripcionesEstudiante.size(); i++) {
			
			String estado = "Activo";
			
			if(detalleInscripcionesEstudiante.get(i).isBaja()) {
				estado = "No activo";
			}
			
			DetalleEstudianteWS detalleEstudiante = new DetalleEstudianteWS(
					detalleInscripcionesEstudiante.get(i).getIdDetalleInscripcion(),
					detalleInscripcionesEstudiante.get(i).getComision().getMateria().getMateria(),
					detalleInscripcionesEstudiante.get(i).getComision().getUsuario().getApellido() +
					", " + detalleInscripcionesEstudiante.get(i).getComision().getUsuario().getNombre(),
					detalleInscripcionesEstudiante.get(i).getInscripcion().getDescripcion(),
					detalleInscripcionesEstudiante.get(i).getComision().getTurno().getTurno(),
					detalleInscripcionesEstudiante.get(i).getComision().getAnio(),
					estado
			);
				
			detallesEstudianteList.add(detalleEstudiante);
			
		}
		
		return detallesEstudianteList;
	}

	@Override
	public List<ComisionWS> traerMateriasPorInscripcionPorCarrera(int idInscripcion, int idCarrera) {
		
		ComisionABM comisionABM = new ComisionABM();
		
		List<Comision> comisiones =  comisionABM.traerComisionesPorInscripcionYCarrera(idInscripcion, idCarrera);
		
		List<ComisionWS> comisionesList = new ArrayList<ComisionWS>();
		
		for (int i = 0; i < comisiones.size(); i++) {
			
			ComisionWS comision = new ComisionWS(
					comisiones.get(i).getIdComision(),
					comisiones.get(i).getMateria().getMateria(),
					comisiones.get(i).getUsuario().getApellido() +
					", " + comisiones.get(i).getUsuario().getNombre(),
					comisiones.get(i).getInscripcion().getDescripcion(),
					comisiones.get(i).getTurno().getTurno()
			);
				
			comisionesList.add(comision);
			
		}
		
		return comisionesList;
	}

	@Override
	public boolean agregarDetalleInscripcion(int idUsuario, int idInscripcion, int idComision) {
		
		boolean agregado = false;
		
		Date date = new Date(); 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String fechaActual = dateFormat.format(date);  
		
		UsuarioABM usuarioABM = new UsuarioABM();
		InscripcionABM inscripcionABM = new InscripcionABM();
		ComisionABM comisionABM = new ComisionABM();
		DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
		
		Usuario usuario = usuarioABM.traerUsuario(idUsuario);
		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Comision comision = comisionABM.traerComision(idComision);
		
		try {
			agregado = detalleInscripcionABM.agregarDetalleInscripcion(inscripcion, comision, usuario, fechaActual, false);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return agregado;
		
	}

	@Override
	public boolean bajaDetalleInscripcion(int idDetalleInscripcion) {
		
		boolean baja = false;
		
		DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
		
		DetalleInscripcion detalleInscripcion = detalleInscripcionABM.traerDetalleInscripcion(idDetalleInscripcion);
		
		try {
			baja = detalleInscripcionABM.bajaDetalleInscripcionBaja(detalleInscripcion);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return baja;
	}

	@Override
	public datos.Usuario actualizarDatosUsuario(int idUsuario, String correo, String celular) {
	
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerUsuario(idUsuario);
		
		try {
			usuario =  usuarioABM.actualizarDatosUsuario(idUsuario, correo, celular);
		}
		catch(Exception e) {
			e.getMessage();
			
		}
		
		return usuario;
		
	}

	@Override
	public datos.Usuario actualizarDatosUsuarioPorAdministrador(int idUsuario, String nombre, String apellido, String dni, String correo,
			String celular) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerUsuario(idUsuario);
		
		try {
			usuario =  usuarioABM.actualizarDatosUsuario(idUsuario, nombre, apellido, dni, correo, celular);
		}
		catch(Exception e) {
			e.getMessage();
			
		}
		
		return usuario;
		
	}

}
