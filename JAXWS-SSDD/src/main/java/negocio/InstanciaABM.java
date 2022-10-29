package negocio;

import dao.InstanciaDao;
import datos.Instancia;

public class InstanciaABM {
	
	InstanciaDao dao = new InstanciaDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER INSTANCIA
	public Instancia traerInstancia(int idInstancia) {
		
		Instancia objeto = dao.traerInstancia(idInstancia);
		return objeto;
		
	}

}