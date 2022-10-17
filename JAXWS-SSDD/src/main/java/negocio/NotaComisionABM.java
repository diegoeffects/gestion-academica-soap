package negocio;

import java.util.List;

import dao.NotaComisionDao;
import datos.NotaComision;

public class NotaComisionABM {
	
	NotaComisionDao dao = new NotaComisionDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER COMISION
	public NotaComision traerNotaComision(int idComision) {	
		return dao.traerNotaComision(idComision);
	}
	
	// METODO TRAER NOTAS COMISION POR COMISION
	public List<NotaComision> traerNotasComisionPorComision(int idComision) {
		return dao.traerNotasComisionPorComision(idComision);
	}
	
	// METODO TRAER NOTAS COMISION POR COMISION Y USUARIO
	public List<NotaComision> traerNotasComisionPorComisionYUsuario(int idComision, int idUsuario) {
		return dao.traerNotasComisionPorComisionYUsuario(idComision, idUsuario);
	}
	
	// METODO TRAER NOTAS COMISION DEFINITIVAS POR USUARIO
	public List<NotaComision> traerNotasComisionDefinitivasPorUsuario(int idUsuario) {
		return dao.traerNotasComisionDefinitivasPorUsuario(idUsuario);
	}

}