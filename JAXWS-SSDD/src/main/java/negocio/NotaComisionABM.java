package negocio;

import java.util.List;

import dao.NotaComisionDao;
import datos.Comision;
import datos.NotaComision;
import datos.TipoNota;
import datos.Usuario;

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
	
	// METODO TRAER NOTAS COMISION POR USUARIO
	public List<NotaComision> traerNotasComisionCursadaPorUsuario(int idUsuario) {
		return dao.traerNotasComisionCursadaPorUsuario(idUsuario);
	}
	
	// METODO TRAER NOTAS COMISION DEFINITIVAS POR USUARIO
	public List<NotaComision> traerNotasComisionDefinitivasPorUsuario(int idUsuario) {
		return dao.traerNotasComisionDefinitivasPorUsuario(idUsuario);
	}
	
	// AGREGAR NOTA COMISION
	public int agregarNota(Comision comision, Usuario usuario, int idTipoNota, int nota, String fecha) {
		
		TipoNotaABM tipoNotaABM = new TipoNotaABM();
		TipoNota tipoNota = tipoNotaABM.traerTipoNota(idTipoNota);
		
		NotaComision notaComision = new NotaComision(comision, usuario, tipoNota, nota, fecha);
		
		return dao.agregarNota(notaComision);
	}
	

}