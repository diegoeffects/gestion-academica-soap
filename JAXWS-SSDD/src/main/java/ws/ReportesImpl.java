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
import respuestas.EstudianteCarreraWS;
import respuestas.EstudiantePlanillaWS;
import respuestas.HistorialAcademicoWS;
import respuestas.PlanillaEstudiantesWS;
import respuestas.ComisionPlanillaWS;
import respuestas.PlanillaMateriasWS;

@WebService(endpointInterface="ws.Reportes")
public class ReportesImpl implements Reportes{
	
	@Override
	public respuestas.EstudianteCarreraWS traerEstudianteConCarrera(int idUsuario){
		
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traerUsuario(idUsuario);
		
		EstudianteCarreraWS estudianteCarreraWS = new EstudianteCarreraWS(idUsuario, (usuario.getApellido() + ", " +
				usuario.getNombre()), usuario.getCarrera().getCarrera() );
		
		return estudianteCarreraWS;
	}
	
	@Override
	public List<respuestas.HistorialAcademicoWS> traerHistorialAcademicoPorEstudiante(int idUsuario) {
		
		NotaComisionABM notaComisionABM = new NotaComisionABM();
		
		List<NotaComision> historialAcademicoList = notaComisionABM.traerNotasComisionDefinitivasPorUsuario(idUsuario);
		
		List<HistorialAcademicoWS> historialAcademicoEstudianteList = new ArrayList<HistorialAcademicoWS>();
		
		for (int i = 0; i < historialAcademicoList.size(); i++) {
			
			HistorialAcademicoWS historialAcademicoEstudiante = new HistorialAcademicoWS(
					"(" + historialAcademicoList.get(i).getComision().getMateria().getIdMateria() +
					") " + historialAcademicoList.get(i).getComision().getMateria().getMateria(),
					historialAcademicoList.get(i).getComision().getUsuario().getApellido() + ", " + historialAcademicoList.get(i).getComision().getUsuario().getNombre(),
					historialAcademicoList.get(i).getNota(), historialAcademicoList.get(i).getFecha()
			);
				
			historialAcademicoEstudianteList.add(historialAcademicoEstudiante);
			
		}
		
		return historialAcademicoEstudianteList;
	}

	/*@Override
	public List<respuestas.HistorialAcademicoWS> traerHistorialAcademicoPorEstudiante(int idUsuario) {
		
		HistorialAcademicoABM historialAcademicoABM = new HistorialAcademicoABM();
		
		List<HistorialAcademico> historialAcademicoList =  historialAcademicoABM.traerHistorialAcademicoPorEstudiante(idUsuario);
		
		List<HistorialAcademicoWS> historialAcademicoEstudianteList = new ArrayList<HistorialAcademicoWS>();
		
		for (int i = 0; i < historialAcademicoList.size(); i++) {
			
			HistorialAcademicoWS historialAcademicoEstudiante = new HistorialAcademicoWS(
					"(" + historialAcademicoList.get(i).getComision().getMateria().getIdMateria() +
					") " + historialAcademicoList.get(i).getComision().getMateria().getMateria(),
					historialAcademicoList.get(i).getComision().getUsuario().getApellido() + ", " + historialAcademicoList.get(i).getComision().getUsuario().getNombre(),
					historialAcademicoList.get(i).getNota(), historialAcademicoList.get(i).getFecha()
			);
				
			historialAcademicoEstudianteList.add(historialAcademicoEstudiante);
			
		}
		
		return historialAcademicoEstudianteList;
	}*/
	
	@Override
	public List<respuestas.ComisionPlanillaWS> traerComisionesPorInscripcionYCarreraYTurno(int idInscripcion, int idCarrera, int idTurno){
		
		ComisionABM comisionABM = new ComisionABM();
		
		List<Comision> comisiones =  comisionABM.traerComisionesPorInscripcionYCarreraYTurno(idInscripcion, idCarrera, idTurno);
		
		List<ComisionPlanillaWS> materiasList = new ArrayList<ComisionPlanillaWS>();
		
		for (int i = 0; i < comisiones.size(); i++) {
			
			ComisionPlanillaWS comisionPlanilla = new ComisionPlanillaWS(
					comisiones.get(i).getMateria().getIdMateria(),
					comisiones.get(i).getMateria().getMateria(),
					String.valueOf(comisiones.get(i).getMateria().getIdMateria()) + "-" + String.valueOf(comisiones.get(i).getComision()),
					comisiones.get(i).getUsuario().getApellido() + ", " + comisiones.get(i).getUsuario().getNombre(),
					comisiones.get(i).getDia().getDia() + " " + comisiones.get(i).getRangoHorario(),
					comisiones.get(i).getFecha() + " " + comisiones.get(i).getRangoHorario(),
					comisiones.get(i).getMateria().getAnioCarrera()
			);
				
			materiasList.add(comisionPlanilla);
			
		}
		
		return materiasList;
	}
	
	@Override
	public respuestas.PlanillaMateriasWS traerCabeceraPlanillaMaterias(int idInscripcion, int idCarrera, int idTurno) {
		
		CarreraABM carreraABM = new CarreraABM();
		InscripcionABM inscripcionABM = new InscripcionABM();
		TurnoABM turnoABM = new TurnoABM();
		
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		Turno turno = turnoABM.traerTurno(idTurno);
		
		PlanillaMateriasWS planillaMateriasWS = new PlanillaMateriasWS(
				carrera.getCarrera(),
				inscripcion.getDescripcion(),
				inscripcion.getInstancia().getIdInstancia(),
				inscripcion.getInstancia().getInstancia(),
				turno.getTurno()
		);
		
		return planillaMateriasWS;
		
	}
	
	@Override
	public List<respuestas.EstudiantePlanillaWS> traerInscripcionesPorComision(int idComision) {
		
		DetalleInscripcionABM detalleinscripcionABM = new DetalleInscripcionABM();
		NotaComisionABM notaComisionABM = new NotaComisionABM();
		
		List<DetalleInscripcion> estudiantes = detalleinscripcionABM.traerDetallesInscripcionPorComision(idComision);
		
		List<EstudiantePlanillaWS> estudiantesList = new ArrayList<EstudiantePlanillaWS>();
		
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
			
			EstudiantePlanillaWS estudiantePlanillaWS = new EstudiantePlanillaWS(
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
				
			estudiantesList.add(estudiantePlanillaWS);
			
		}
		
		return estudiantesList;
		
	}
	
	@Override
	public respuestas.PlanillaEstudiantesWS traerCabeceraPlanillaEstudiantes(int idComision) {
		
		ComisionABM comisionABM = new ComisionABM();
		
		Comision comision = comisionABM.traerComision(idComision);
		
		PlanillaEstudiantesWS planillaEstudiantesWS = new PlanillaEstudiantesWS(
				comision.getInscripcion().getInstancia().getIdInstancia()
		);
		
		return planillaEstudiantesWS;
		
	}

}
