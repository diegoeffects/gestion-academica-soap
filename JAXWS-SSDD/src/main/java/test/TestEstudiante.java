package test;

//import java.util.ArrayList;
//import java.util.List;

//import datos.Docente;

import negocio.InscripcionABM;
import negocio.HistorialAcademicoABM;
import negocio.ComisionABM;
import negocio.DetalleInscripcionABM;

import java.util.List;

import datos.HistorialAcademico;
import datos.Inscripcion;
import datos.Comision;
import datos.DetalleInscripcion;

public class TestEstudiante {	
	public static void main(String[] args) {	
		try{
			
			InscripcionABM inscripcionABM = new InscripcionABM();
			//ComisionABM comisionABM = new ComisionABM();
			//EstudianteABM estudianteABM = new EstudianteABM();
			//DetalleInscripcionABM detalleInscripcionABM = new DetalleInscripcionABM();
			
			//Inscripcion inscripcion = inscripcionABM.traerInscripcion(5);
			
			//Comision comision = comisionABM.traerComision(15);
			
			//System.out.println(comision.getTurno().getIdTurno());
			
			//System.out.println(comision);
			
			//Estudiante estudiante = estudianteABM.traerEstudiante(4);
			
			//System.out.println("Resultado inscripcion: " + detalleInscripcionABM.agregarDetalleInscripcion(inscripcion, comision, estudiante, false));
			
			//InscripcionABM inscripcionABM = new InscripcionABM();
			//ComisionABM comisionABM = new ComisionABM();
			//
			//estudianteABM.actualizarDatosEstudiante(2, "mariagomez@gmail.com", "1147896524");
			
			//System.out.println(estudianteABM.traerEstudiantes());
			
			//DetalleInscripcion detalleInscripcion
			
			System.out.println(inscripcionABM.traerInscripcionesActivas());
			//System.out.println(comisionABM.traerComisionesPorInscripcionYCarrera(5,2));
			
			/*DetalleInscripcion detalleInscripcion = detalleInscripcionABM.traerDetalleInscripcion(5);
			
			System.out.println(detalleInscripcion);
			
			detalleInscripcion.setBaja(true);
			
			detalleInscripcionABM.eliminarDetalleInscripcionBaja(detalleInscripcion);
			
			System.out.println(detalleInscripcion);*/
			
			//HistorialAcademicoABM historialAcademicoABM = new HistorialAcademicoABM();
			//HistorialAcademico historialAcademico = new HistorialAcademico();
			
			/*List<HistorialAcademico> historialAcademicoList =  historialAcademicoABM.traerHistorialAcademicoPorEstudiante(2);
			
			for (int i = 0; i < historialAcademicoList.size(); i++) {
				
				System.out.println("Materia: " + historialAcademicoList.get(i).getComision().getMateria().getMateria() + " | Docente: "
				+ historialAcademicoList.get(i).getComision().getDocente().getApellido() + ", " + historialAcademicoList.get(i).getComision().getDocente().getNombre()
				+ " | Nota: " + historialAcademicoList.get(i).getNota() + " | Fecha: " + historialAcademicoList.get(i).getFecha());
				
			}*/
			
			//Estudiante estudiante = new Estudiante();
			
			//List<Docente> docentes;
			
			//docenteABM.agregar("Roberto", "Garcia", "444444444", "rgarcia", "DNI444444444", false);
			
			//estudiante = estudianteABM.traerEstudiante(5);
			
			//docentes = ;
			
			//System.out.println(estudiante.getCorreo());
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());							
		}
	}
}