package ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.ServiceMode;

import datos.Carrera;
import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.NotaComision;
import datos.Usuario;
import dto.InscripcionEstudianteDTO;
import dto.InscripcionDTO;
import dto.InscripcionesEstudianteDTO;
import dto.InscripcionesDTO;
import dto.MateriaInscripcionCarreraDTO;
import dto.MateriasInscripcionCarreraDTO;
import dto.RespuestaDTO;
import negocio.InscripcionABM;
import negocio.NotaComisionABM;
import negocio.CarreraABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;
import negocio.UsuarioABM;

@ServiceMode(value = javax.xml.ws.Service.Mode.MESSAGE)
@HandlerChain(file="handler.xml")
@WebService(endpointInterface="ws.Estudiantes")
public class EstudiantesImpl implements Estudiantes{

	// LISTADO DE INSCRIPCIONES ACTIVAS
	@Override
	public InscripcionesDTO traerInscripcionesActivas() {
		
		InscripcionABM inscripcionABM = new InscripcionABM();
		
		List<Inscripcion> inscripcionesActivas =  inscripcionABM.traerInscripcionesActivas();
		
		InscripcionesDTO inscripciones = new InscripcionesDTO(
				"No existen inscripciones activas",
				"EMPTY"			
		);
		
		if(inscripcionesActivas.size() != 0) {
			
			inscripciones.setError("");
			inscripciones.setEstado("SUCCESS");
			
			List<InscripcionDTO> inscripcionesList = new ArrayList<InscripcionDTO>();
			
			for (int i = 0; i < inscripcionesActivas.size(); i++) {
				
				InscripcionDTO inscripcion = new InscripcionDTO(
						String.valueOf(inscripcionesActivas.get(i).getIdInscripcion()),
						inscripcionesActivas.get(i).getDescripcion(),
						String.valueOf(inscripcionesActivas.get(i).getInstancia().getIdInstancia()),
						inscripcionesActivas.get(i).getInstancia().getInstancia()
				);		
				inscripcionesList.add(inscripcion);
				
			}
			
			inscripciones.setInscripciones(inscripcionesList);
		
		}

		return inscripciones;
		
	}

	// LISTADO DE INSCRIPCIONES POR ESTUDIANTE
	@Override
	public InscripcionesEstudianteDTO traerInscripcionesPorEstudiante(int idUsuario) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		InscripcionesEstudianteDTO inscripcionesEstudianteDTO = new InscripcionesEstudianteDTO(
				"El usuario no existe o no corresponde a un estudiante",
				"EMPTY"
		);
		
		if(usuario != null) {
			
			inscripcionesEstudianteDTO.setError("El estudiante no posee inscripciones asociadas");
			inscripcionesEstudianteDTO.setEstado("EMPTY");
			
			DetalleInscripcionABM detalleinscripcionABM = new DetalleInscripcionABM();
			List<DetalleInscripcion> inscripcionesEstudiante =  detalleinscripcionABM.traerDetallesInscripcionPorEstudiante(idUsuario);
			
			if(inscripcionesEstudiante.size() != 0) {
				
				inscripcionesEstudianteDTO.setError("");
				inscripcionesEstudianteDTO.setEstado("SUCCESS");
				
				List<InscripcionEstudianteDTO> inscripcionesEstudianteList = new ArrayList<InscripcionEstudianteDTO>();
				
				for (int i = 0; i < inscripcionesEstudiante.size(); i++) {
					
					String estado = "Activo";
					
					if(inscripcionesEstudiante.get(i).isBaja()) {
						estado = "No activo";
					}
					
					InscripcionEstudianteDTO inscripcionEstudiante = new InscripcionEstudianteDTO(
							String.valueOf(inscripcionesEstudiante.get(i).getIdDetalleInscripcion()),
							inscripcionesEstudiante.get(i).getComision().getMateria().getMateria(),
							inscripcionesEstudiante.get(i).getComision().getUsuario().getApellido() +
							", " + inscripcionesEstudiante.get(i).getComision().getUsuario().getNombre(),
							String.valueOf(inscripcionesEstudiante.get(i).getInscripcion().getIdInscripcion()),
							inscripcionesEstudiante.get(i).getComision().getTurno().getTurno(),
							String.valueOf(inscripcionesEstudiante.get(i).getComision().getDia().getIdDia()),
							inscripcionesEstudiante.get(i).getComision().getDia().getDia() + " " + inscripcionesEstudiante.get(i).getComision().getRangoHorario(),
							inscripcionesEstudiante.get(i).getComision().getAnio(),
							estado
					);
						
					inscripcionesEstudianteList.add(inscripcionEstudiante);
					
				}
				
				inscripcionesEstudianteDTO.setInscripcionesEstudiante(inscripcionesEstudianteList);
				
			}
			
		}
			
		return inscripcionesEstudianteDTO;
	}

	// LISTADO DE MATERIAS POR INSCRIPCION Y CARRERA
	@Override
	public MateriasInscripcionCarreraDTO traerMateriasPorInscripcionPorCarrera(int idInscripcion, int idCarrera) {
		
		InscripcionABM inscripcionABM = new InscripcionABM();
		CarreraABM carreraABM = new CarreraABM();

		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
	
		MateriasInscripcionCarreraDTO materiasInscripcionCarreraDTO = new MateriasInscripcionCarreraDTO(
				"No existen materias asociadas para los parametros especificados",
				"EMPTY"
		);
		
		if( (inscripcion != null) && (carrera != null) ) {
			
			ComisionABM comisionABM = new ComisionABM();
			
			List<Comision> materias =  comisionABM.traerComisionesPorInscripcionYCarrera(idInscripcion, idCarrera);
			
			if(materias.size() != 0) {
				
				materiasInscripcionCarreraDTO.setError("");
				materiasInscripcionCarreraDTO.setEstado("SUCCESS");
			
				List<MateriaInscripcionCarreraDTO> materiasList = new ArrayList<MateriaInscripcionCarreraDTO>();
				
				for (int i = 0; i < materias.size(); i++) {
					
					String diaHorario = materias.get(i).getDia().getDia() + " " + materias.get(i).getRangoHorario();
					
					if(inscripcion.getInstancia().getIdInstancia() == 2) {
						diaHorario = materias.get(i).getFecha() + " " + materias.get(i).getRangoHorario();
					}
					
					MateriaInscripcionCarreraDTO materiaInscripcionCarrera = new MateriaInscripcionCarreraDTO(
							String.valueOf(materias.get(i).getIdComision()),
							materias.get(i).getMateria().getMateria(),
							materias.get(i).getUsuario().getApellido() +
							", " + materias.get(i).getUsuario().getNombre(),
							materias.get(i).getTurno().getTurno(),
							String.valueOf(materias.get(i).getDia().getIdDia()),
							diaHorario
					);
						
					materiasList.add(materiaInscripcionCarrera);
					
				}
				
				materiasInscripcionCarreraDTO.setMateriasIncripcionCarrera(materiasList);
				
			}
			
		}
		
		return materiasInscripcionCarreraDTO;
	}

	// ALTA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@Override
	public RespuestaDTO altaInscripcionEstudiante(int idUsuario, int idInscripcion, int idComision) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		InscripcionABM inscripcionABM = new InscripcionABM();
		ComisionABM comisionABM = new ComisionABM();

		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		Inscripcion inscripcion = null;
		Comision comision = comisionABM.traerComision(idComision);
		
		List<Inscripcion> inscripcionesVigentes = inscripcionABM.traerInscripcionesActivas();
		
		RespuestaDTO respuesta = new RespuestaDTO(
				"Algunos de los parametros no son correctos",
				"EMPTY"
		);
		
		String fechaActual = "";
		
		for (int i = 0; i < inscripcionesVigentes.size(); i++) {
			
			if (idInscripcion == inscripcionesVigentes.get(i).getIdInscripcion()) {
				
				if(comision.getInscripcion().getIdInscripcion() == inscripcionesVigentes.get(i).getIdInscripcion()) {
					
					inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
					
				}
			}
			
		}
		
		if( (usuario != null) && (inscripcion != null) && (comision != null) ) {
			
			boolean agregado = false;
			boolean realizarInscripcion = false;
			int notaCursada = 0;
			String fechaNotaCursada = "";
			
			DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
			
			Date date = new Date(); 
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    fechaActual = dateFormat.format(date);
		    
		    if (comision.getInscripcion().getInstancia().getIdInstancia() == 1) {
		    	realizarInscripcion = true;
		    }
		    else if (comision.getInscripcion().getInstancia().getIdInstancia() == 2) {
		    	
		    	int idMateria = comision.getMateria().getIdMateria();
		    	
		    	NotaComisionABM notaComisionABM = new NotaComisionABM();
		    	
		    	List<NotaComision> notas = notaComisionABM.traerNotasComisionCursadaPorUsuario(usuario.getIdUsuario());
		    	
				for (int i = 0; i < notas.size(); i++) {
					
					if (idMateria == notas.get(i).getComision().getMateria().getIdMateria()) {
						
						if( (notas.get(i).getNota() >= 4) ) {
							
							notaCursada = notas.get(i).getNota();
							fechaNotaCursada = notas.get(i).getFecha();
							realizarInscripcion = true;
							
						}
						
					}
					
				}
				
		    }
		    
			if (realizarInscripcion) {
				try {
					agregado = detalleInscripcionABM.agregarDetalleInscripcion(inscripcion, comision, usuario, fechaActual, false);
				}
				catch(Exception e) {
					e.getMessage();
				}
			}
			
			if(agregado) {
				respuesta.setError("");
				respuesta.setEstado("SUCCESS");
				if(comision.getInscripcion().getInstancia().getIdInstancia() == 2) {
					NotaComisionABM notaComisionABM = new NotaComisionABM();
					notaComisionABM.agregarNota(comision, usuario, 10, notaCursada, fechaNotaCursada);
				}
			}
			else {
				respuesta.setError("No se realizo el alta de inscripcion del estudiante");
				respuesta.setEstado("FAIL");
			}
			
		}

		return respuesta;
		
	}

	// BAJA DE UN ESTUDIANTE EN UNA MATERIA DE UNA INSCRIPCION
	@Override
	public RespuestaDTO bajaInscripcionEstudiante(int idDetalleInscripcion) {
		
		DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
		
		DetalleInscripcion detalleInscripcion = detalleInscripcionABM.traerDetalleInscripcion(idDetalleInscripcion);
		
		RespuestaDTO respuesta = new RespuestaDTO(
				"No existe una inscripcion con el identificador especificado",
				"EMPTY"
		);
		
		if(detalleInscripcion != null){
			
			boolean baja = false;
			
			try {
				baja = detalleInscripcionABM.bajaDetalleInscripcion(detalleInscripcion);
			}
			catch(Exception e) {
				e.getMessage();
			}
			
			if(baja){
				respuesta.setError("");
				respuesta.setEstado("SUCCESS");
			}
			else {
				respuesta.setError("No se realizo la baja del estudiante");
				respuesta.setEstado("FAIL");
			}
				
		}

		return respuesta;
	}
	
	// ACTUALIZACION DATOS DE ESTUDIANTE
	@Override
	public RespuestaDTO actualizarDatosUsuario(int idUsuario, String correo, String celular, String clave) {
	
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		RespuestaDTO respuesta = new RespuestaDTO(
				"El usuario no existe o no corresponde a un estudiante",
				"EMPTY"
		);
		
		if(usuario != null) {
			
			respuesta.setError("Falta especificar algunos de los parametros");
			respuesta.setEstado("EMPTY");
			
			if( (correo != "") && (celular != "") && (clave != "") ){
				
				respuesta.setError("");
				respuesta.setEstado("SUCCESS");
				
				try {
					usuario =  usuarioABM.actualizarDatosUsuario(idUsuario, correo, celular, clave);
				}
				catch(Exception e) {
					e.getMessage();
				}
				
			}
			
		}
		
		return respuesta;
		
	}
	
}
