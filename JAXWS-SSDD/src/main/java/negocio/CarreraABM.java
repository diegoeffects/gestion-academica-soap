package negocio;

import dao.CarreraDao;
import datos.Carrera;

public class CarreraABM {
	
	CarreraDao dao = new CarreraDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER CARRERA
	public Carrera traerCarrera(int idCarrera) {	
		return dao.traerCarrera(idCarrera);
	}
	
}