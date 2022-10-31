package negocio;

import dao.TipoNotaDao;
import datos.TipoNota;

public class TipoNotaABM {
	
	TipoNotaDao dao = new TipoNotaDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER TIPO NOTA
	public TipoNota traerTipoNota(int idTipoNota) {
		return dao.traerTipoNota(idTipoNota);
	}

}