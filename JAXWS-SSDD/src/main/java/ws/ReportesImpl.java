package ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.*;

import datos.Carrera;
import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.NotaComision;
import datos.Turno;
import datos.Usuario;
import negocio.CarreraABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;
import negocio.InscripcionABM;
import negocio.NotaComisionABM;
import negocio.TurnoABM;
import negocio.UsuarioABM;
import respuestas.EstudianteMateriaWS;
import respuestas.MateriaAprobadaWS;
import respuestas.MateriaInscripcionWS;
import respuestas.MateriasAprobadasWS;
import respuestas.EstudiantesMateriaWS;
import respuestas.MateriasInscripcionWS;

@WebService(endpointInterface="ws.Reportes")
public class ReportesImpl implements Reportes{
	
	// REPORTE ANALITICO DE ESTUDIANTE
	@Override
	public respuestas.MateriasAprobadasWS traerMateriasAprobadasPorEstudiante(int idUsuario) {
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerEstudiante(idUsuario);
		
		MateriasAprobadasWS materiasAprobadasWS = new MateriasAprobadasWS(
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
			
			List<MateriaAprobadaWS> materiasAprobadasList =  new ArrayList<MateriaAprobadaWS>();
			
			for (int i = 0; i < historialAcademicoList.size(); i++) {
				
				MateriaAprobadaWS materiaAprobada = new MateriaAprobadaWS(
						"(" + historialAcademicoList.get(i).getComision().getMateria().getIdMateria() +
						") " + historialAcademicoList.get(i).getComision().getMateria().getMateria(),
						historialAcademicoList.get(i).getComision().getUsuario().getApellido() + ", " + historialAcademicoList.get(i).getComision().getUsuario().getNombre(),
						historialAcademicoList.get(i).getNota(), historialAcademicoList.get(i).getFecha()
				);
				
				materiasAprobadasList.add(materiaAprobada);
				
			}
			
			materiasAprobadasWS.setMateriasAprobadas(materiasAprobadasList);
			
		}
		
		return materiasAprobadasWS;
		
	}
	
	// REPORTE LISTADO DE ESTUDIANTES INSCRIPTOS
	@Override
	public respuestas.EstudiantesMateriaWS traerEstudiantesInscriptosPorMateria(int idComision) {
		
		ComisionABM comisionABM = new ComisionABM();
		
		Comision comision = comisionABM.traerComision(idComision);
		
		EstudiantesMateriaWS estudiantesMateriaWS = new EstudiantesMateriaWS(
				"La comision no existe o no posee estudiantes asociados",
				"EMPTY",
				""
		);
		
		if(comision != null) {
			
			DetalleInscripcionABM detalleinscripcionABM = new DetalleInscripcionABM();
			List<DetalleInscripcion> estudiantes = detalleinscripcionABM.traerDetallesInscripcionPorComision(idComision);
			
			if(estudiantes.size() != 0) {
				
				estudiantesMateriaWS.setError("");
				estudiantesMateriaWS.setEstado("SUCCESS");
				estudiantesMateriaWS.setIdInstancia(String.valueOf(comision.getInscripcion().getInstancia().getIdInstancia()));
				
				NotaComisionABM notaComisionABM = new NotaComisionABM();
				List<EstudianteMateriaWS> estudiantesInscriptosList = new ArrayList<EstudianteMateriaWS>();
				
				for (int i = 0; i < estudiantes.size(); i++) {
					
					List<NotaComision> notas = notaComisionABM.traerNotasComisionPorComisionYUsuario(idComision, estudiantes.get(i).getUsuario().getIdUsuario());
					
					String primerParcial = "";
					String segundoParcial = "";
					String tercerParcial = "";
					String primerRecuperatorio = "";
					String segundoRecuperatorio = "";
					String tercerRecuperatorio = "";
					String tp1 = "";
					String tp2 = "";
					String tp3 = "";
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
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 3) {
							tercerParcial = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 4) {
							primerRecuperatorio = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 5) {
							segundoRecuperatorio = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 6) {
							tercerRecuperatorio = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 7) {
							tp1 = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 8) {
							tp2 = String.valueOf(notas.get(j).getNota());
						}
						else if(notas.get(j).getTipoNota().getIdTipoNota() == 9) {
							tp3 = String.valueOf(notas.get(j).getNota());
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
					
					EstudianteMateriaWS estudianteMateriaWS = new EstudianteMateriaWS(
							i+1,
							estudiantes.get(i).getUsuario().getApellido(),
							estudiantes.get(i).getUsuario().getNombre(),
							estudiantes.get(i).getUsuario().getDni(),
							primerParcial,
							segundoParcial,
							tercerParcial,
							primerRecuperatorio,
							segundoRecuperatorio,
							tercerRecuperatorio,
							tp1,
							tp2,
							tp3,
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
	public respuestas.MateriasInscripcionWS traerMateriasPorInscripcionYCarreraYTurno(int idInscripcion, int idCarrera, int idTurno){

		InscripcionABM inscripcionABM = new InscripcionABM();
		CarreraABM carreraABM = new CarreraABM();
		TurnoABM turnoABM = new TurnoABM();

		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
		Turno turno = turnoABM.traerTurno(idTurno);
	
		MateriasInscripcionWS materiasInscripcionWS = new MateriasInscripcionWS(
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
			List<MateriaInscripcionWS> materiasInscripcionList = new ArrayList<MateriaInscripcionWS>();
			
		
			for (int i = 0; i < comisiones.size(); i++) {
				
				MateriaInscripcionWS materiaInscripcion = new MateriaInscripcionWS(
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

}
