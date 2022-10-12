package negocio;

import java.util.List;

import dao.ComisionDao;
import datos.Comision;

public class ComisionABM {
	
	ComisionDao dao = new ComisionDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER COMISION
	public Comision traerComision(int idComision) {	
		return dao.traerComision(idComision);
	}
	
	// METODO TRAER COMISIONES
	public List<Comision> traerInscripciones() {
		return dao.traerComisiones();
	}
	
	// METODO TRAER COMISIONES POR INSCRIPCION Y CARRERA
	public List<Comision> traerComisionesPorInscripcionYCarrera(int idInscripcion, int idCarrera) {
		return dao.traerComisionesPorInscripcionYCarrera(idInscripcion, idCarrera);
	}

}