package negocio;

import dao.TurnoDao;
import datos.Turno;

public class TurnoABM {
	
	TurnoDao dao = new TurnoDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER TURNO
	public Turno traerTurno(int idTurno) {
		return dao.traerTurno(idTurno);
	}

}