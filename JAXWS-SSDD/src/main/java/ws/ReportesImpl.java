package ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.*;

import datos.Carrera;
import datos.Comision;
import datos.HistorialAcademico;
import datos.Inscripcion;
import datos.Usuario;
import negocio.CarreraABM;
import negocio.ComisionABM;
import negocio.HistorialAcademicoABM;
import negocio.InscripcionABM;
import negocio.UsuarioABM;
import respuestas.EstudianteCarreraWS;
import respuestas.HistorialAcademicoWS;
import respuestas.ComisionBWS;
import respuestas.PlanillaMateriasWS;

@WebService(endpointInterface="ws.Reportes")
public class ReportesImpl implements Reportes{
	
	// ANALITICO DE ESTUDIANTE
	
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
	}
	
	@Override
	public List<respuestas.ComisionBWS> traerComisionesPorInscripcionYCarrera(int idInscripcion, int idCarrera){
		
		ComisionABM comisionABM = new ComisionABM();
		
		List<Comision> comisiones =  comisionABM.traerComisionesPorInscripcionYCarrera(idInscripcion, idCarrera);
		
		List<ComisionBWS> materiasList = new ArrayList<ComisionBWS>();
		
		for (int i = 0; i < comisiones.size(); i++) {
			
			ComisionBWS comisionB = new ComisionBWS(
					comisiones.get(i).getMateria().getIdMateria(),
					comisiones.get(i).getMateria().getMateria(),
					String.valueOf(comisiones.get(i).getMateria().getIdMateria()) + "-" + String.valueOf(comisiones.get(i).getComision()),
					comisiones.get(i).getUsuario().getApellido() + ", " + comisiones.get(i).getUsuario().getNombre(),
					comisiones.get(i).getDia().getDia() + " " + comisiones.get(i).getRangoHorario()
			);
				
			materiasList.add(comisionB);
			
		}
		
		return materiasList;
	}
	
	@Override
	public respuestas.PlanillaMateriasWS traerCabeceraPlanillaMaterias(int idInscripcion, int idCarrera) {
		
		CarreraABM carreraABM = new CarreraABM();
		InscripcionABM inscripcionABM = new InscripcionABM();
		
		Carrera carrera = carreraABM.traerCarrera(idCarrera);
		Inscripcion inscripcion = inscripcionABM.traerInscripcion(idInscripcion);
		
		
		PlanillaMateriasWS planillaMateriaWS = new PlanillaMateriasWS(
				carrera.getCarrera(),
				inscripcion.getDescripcion(),
				inscripcion.getInstancia().getInstancia()
		);
		
		return planillaMateriaWS;
		
	}

}
