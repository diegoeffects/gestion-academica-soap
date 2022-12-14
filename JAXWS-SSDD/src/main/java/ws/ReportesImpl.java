package ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.*;
import javax.xml.ws.ServiceMode;

import datos.Carrera;
import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.Instancia;
import datos.Materia;
import datos.NotaComision;
import datos.Turno;
import datos.Usuario;
import dto.ComisionMateriaDTO;
import dto.ComisionesMateriaDTO;
import dto.EstudianteMateriaDTO;
import dto.EstudiantesMateriaDTO;
import dto.MateriaAprobadaDTO;
import dto.MateriaInscripcionDTO;
import dto.MateriasAprobadasDTO;
import dto.MateriasInscripcionDTO;
import negocio.CarreraABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;
import negocio.InscripcionABM;
import negocio.InstanciaABM;
import negocio.MateriaABM;
import negocio.NotaComisionABM;
import negocio.TurnoABM;
import negocio.UsuarioABM;

@ServiceMode(value = javax.xml.ws.Service.Mode.MESSAGE)
@HandlerChain(file="handler.xml")
@WebService(endpointInterface="ws.Reportes")
public class ReportesImpl implements Reportes{
	
	// REPORTE ANALITICO DE ESTUDIANTE
	@Override
	public dto.MateriasAprobadasDTO traerMateriasAprobadasPorEstudiante(int idUsuario) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		MateriasAprobadasDTO materiasAprobadasWS = new MateriasAprobadasDTO(
				"El usuario no existe o no corresponde a un usuario con rol estudiante",
				"EMPTY",
				"",
				""
		);
			
		if(usuario != null) {
			
			materiasAprobadasWS.setError("");
			materiasAprobadasWS.setEstado("SUCCESS");
			materiasAprobadasWS.setEstudiante((usuario.getApellido() + ", " + usuario.getNombre()));
			materiasAprobadasWS.setCarrera(usuario.getCarrera().getCarrera());
			
			NotaComisionABM notaComisionABM = new NotaComisionABM();
			
			List<NotaComision> historialAcademicoList = notaComisionABM.traerNotasComisionDefinitivasPorUsuario(idUsuario);
			
			List<MateriaAprobadaDTO> materiasAprobadasList =  new ArrayList<MateriaAprobadaDTO>();
			
			for (int i = 0; i < historialAcademicoList.size(); i++) {
				
				MateriaAprobadaDTO materiaAprobada = new MateriaAprobadaDTO(
						"(" + historialAcademicoList.get(i).getComision().getMateria().getIdMateria() +
						") " + historialAcademicoList.get(i).getComision().getMateria().getMateria(),
						historialAcademicoList.get(i).getComision().getUsuario().getApellido() + ", " + historialAcademicoList.get(i).getComision().getUsuario().getNombre(),
						historialAcademicoList.get(i).getNota(),
						historialAcademicoList.get(i).getFecha()
				);
				
				materiasAprobadasList.add(materiaAprobada);
				
			}
			
			materiasAprobadasWS.setMateriasAprobadas(materiasAprobadasList);
			
		}
		
		return materiasAprobadasWS;
		
	}
	
	// REPORTE LISTADO DE ESTUDIANTES INSCRIPTOS
	@Override
	public dto.EstudiantesMateriaDTO traerEstudiantesInscriptosPorMateria(int idComision) {
		
		ComisionABM comisionABM = new ComisionABM();
		
		Comision comision = comisionABM.traerComision(idComision);
		
		EstudiantesMateriaDTO estudiantesMateriaWS = new EstudiantesMateriaDTO(
				"La comision no existe o no posee estudiantes asociados",
				"EMPTY",
				""
		);
		
		if(comision != null) {
			
			DetalleInscripcionABM detalleinscripcionABM = new DetalleInscripcionABM();
			List<DetalleInscripcion> estudiantes = detalleinscripcionABM.traerDetallesInscripcionActivasPorComision(idComision);
			
			if(estudiantes.size() != 0) {
				
				estudiantesMateriaWS.setError("");
				estudiantesMateriaWS.setEstado("SUCCESS");
				estudiantesMateriaWS.setIdInstancia(String.valueOf(comision.getInscripcion().getInstancia().getIdInstancia()));
				
				NotaComisionABM notaComisionABM = new NotaComisionABM();
				List<EstudianteMateriaDTO> estudiantesInscriptosList = new ArrayList<EstudianteMateriaDTO>();
				
				for (int i = 0; i < estudiantes.size(); i++) {
					
					List<NotaComision> notas = notaComisionABM.traerNotasComisionPorComisionYUsuario(idComision, estudiantes.get(i).getUsuario().getIdUsuario());
					
					String primerParcial = "";
					String segundoParcial = "";
					String notaCursada = "";
					String notaFinal = "";
					String notaDefinitiva = "";
					
					
					for (int j = 0; j < notas.size(); j++) {
						
						if(notas.get(j).getTipoNota().getIdTipoNota() == 1) {
							primerParcial = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 2) {
							segundoParcial = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 10) {
							notaCursada = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 11) {
							notaFinal = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 12) {
							notaDefinitiva = String.valueOf(notas.get(j).getNota());
						}
						
					}
					
					EstudianteMateriaDTO estudianteMateriaWS = new EstudianteMateriaDTO(
							i+1,
							estudiantes.get(i).getUsuario().getApellido(),
							estudiantes.get(i).getUsuario().getNombre(),
							estudiantes.get(i).getUsuario().getDni(),
							primerParcial,
							segundoParcial,
							notaCursada,
							notaFinal,
							notaDefinitiva
					);
						
					estudiantesInscriptosList.add(estudianteMateriaWS);
				
				}
				
				estudiantesMateriaWS.setEstudiantesInscriptos(estudiantesInscriptosList);
			
			}
			
		}
		
		return estudiantesMateriaWS;
		
	}
	
	// REPORTE LISTADO DE MATERIAS POR INSCRIPCION, CARRERA Y TURNO
	@Override
	public dto.MateriasInscripcionDTO traerMateriasPorInscripcionYCarreraYTurno(int idInscripcion, int idCarrera, int idTurno){

		InscripcionABM inscripcionABM = new InscripcionABM();
		CarreraABM carreraABM = new CarreraABM();
		TurnoABM turnoABM = new TurnoABM();

		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
		Turno turno = turnoABM.traerTurno(idTurno);
	
		MateriasInscripcionDTO materiasInscripcionWS = new MateriasInscripcionDTO(
				"No existen materias asociadas para los parametros especificados",
				"EMPTY",
				"",
				"",
				"",
				"",
				""
		);
		
		if( (inscripcion != null) && (carrera != null) && (turno != null)) {
			
			materiasInscripcionWS.setError("");
			materiasInscripcionWS.setEstado("SUCCESS");
			materiasInscripcionWS.setCarrera(carrera.getCarrera());
			materiasInscripcionWS.setDescripcion(inscripcion.getDescripcion());
			materiasInscripcionWS.setIdInstancia(String.valueOf(inscripcion.getInstancia().getIdInstancia()));	
			materiasInscripcionWS.setInstancia(inscripcion.getInstancia().getInstancia());
			materiasInscripcionWS.setTurno(turno.getTurno());
			
			ComisionABM comisionABM = new ComisionABM();
			List<Comision> comisiones =  comisionABM.traerComisionesPorInscripcionYCarreraYTurno(idInscripcion, idCarrera, idTurno);
			List<MateriaInscripcionDTO> materiasInscripcionList = new ArrayList<MateriaInscripcionDTO>();
			
		
			for (int i = 0; i < comisiones.size(); i++) {
				
				MateriaInscripcionDTO materiaInscripcion = new MateriaInscripcionDTO(
						comisiones.get(i).getMateria().getIdMateria(),
						comisiones.get(i).getMateria().getMateria(),
						String.valueOf(comisiones.get(i).getMateria().getIdMateria()) + "-" + String.valueOf(comisiones.get(i).getComision()),
						comisiones.get(i).getUsuario().getApellido() + ", " + comisiones.get(i).getUsuario().getNombre(),
						comisiones.get(i).getDia().getDia() + " " + comisiones.get(i).getRangoHorario(),
						comisiones.get(i).getFecha() + " " + comisiones.get(i).getRangoHorario(),
						comisiones.get(i).getMateria().getAnioCarrera()
				);
					
				materiasInscripcionList.add(materiaInscripcion);
				
			}
			
			materiasInscripcionWS.setMateriasInscripcion(materiasInscripcionList);
			
		}
		
		return materiasInscripcionWS;
		
	}
	
	
	// REPORTE LISTADO DE MATERIAS POR INSTANCIA Y MATERIA
	@Override
	public ComisionesMateriaDTO traerComisionesPorInstanciaYMateria(int idInstancia, int idMateria){
		
		InstanciaABM instanciaABM = new InstanciaABM();
		MateriaABM materiaABM = new MateriaABM();
		
		Instancia instancia = instanciaABM.traerInstancia(idInstancia);
		Materia materia = materiaABM.traerMateria(idMateria);
		
		ComisionesMateriaDTO comisionesMateriaWS = new ComisionesMateriaDTO(
				"La materia no existe o no posee comisiones asociadas",
				"EMPTY"
		);
		
		if ( (materia != null) && (instancia != null) ) {
			
			comisionesMateriaWS.setError("");
			comisionesMateriaWS.setEstado("SUCCESS");
		
			ComisionABM comisionABM = new ComisionABM();
		
			List<Comision> comisiones = comisionABM.traerComisionesPorInstanciaYMateria(idInstancia, idMateria);
			List<ComisionMateriaDTO> comisionesMateriaList = new ArrayList<ComisionMateriaDTO>();
			
			
			for (int i = 0; i < comisiones.size(); i++) {
				
				ComisionMateriaDTO comisionMateriaWS = new ComisionMateriaDTO(
						String.valueOf(comisiones.get(i).getIdComision()),
						String.valueOf(comisiones.get(i).getMateria().getIdMateria()) + "-" + String.valueOf(comisiones.get(i).getComision())
				);
					
				comisionesMateriaList.add(comisionMateriaWS);
				
			}
			
			comisionesMateriaWS.setComisiones(comisionesMateriaList);
		
		}
		
		return comisionesMateriaWS;
	
	}

}
