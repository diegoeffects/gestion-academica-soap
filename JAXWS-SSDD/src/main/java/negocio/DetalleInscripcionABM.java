package negocio;

import java.util.List;

import dao.DetalleInscripcionDao;
import datos.Comision;
import datos.DetalleInscripcion;
import datos.Inscripcion;
import datos.Usuario;

public class DetalleInscripcionABM {
	
	DetalleInscripcionDao dao = new DetalleInscripcionDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER DETALLE INSCRIPCION
	public DetalleInscripcion traerDetalleInscripcion(int idDetalleInscripcion) {	
		DetalleInscripcion objeto = dao.traerDetalleInscripcion(idDetalleInscripcion);
		return objeto;
	}
	
	// METODO TRAER DETALLES INSCRIPCION POR ESTUDIANTE
	public List<DetalleInscripcion> traerDetallesInscripcionPorEstudiante(int idUsuario){
		return dao.traerDetallesInscripcionPorEstudiante(idUsuario);
	}
	
	// METODO TRAER DETALLES INSCRIPCION ACTIVAS POR COMISION
	public List<DetalleInscripcion> traerDetallesInscripcionActivasPorComision(int idComision){
		return dao.traerDetallesInscripcionActivasPorComision(idComision);
	}
	
	// METODO AGREGAR DETALLE INSCRIPCION
	public boolean agregarDetalleInscripcion(Inscripcion inscripcion, Comision comision, Usuario usuario, String fechaInscripcion, boolean baja) throws Exception {
		
		boolean noExisteSuperposicion = true;
		boolean mismaInscripcion = false;
		boolean superponeDia = false;
		boolean superponeTurno = false;
		boolean resultado = false;
		
		List<DetalleInscripcion> inscripcionesEstudiante = dao.traerDetallesInscripcionActivasPorEstudiante(usuario.getIdUsuario());
		
		for (int i=0; i<inscripcionesEstudiante.size(); i++) {
			
			if(inscripcionesEstudiante.get(i).getComision().getInscripcion().getIdInscripcion() == comision.getInscripcion().getIdInscripcion()) {
				mismaInscripcion = true;
			}
			if(inscripcionesEstudiante.get(i).getComision().getTurno().getIdTurno() == comision.getTurno().getIdTurno()) {
				superponeTurno = true;
			}
			if(inscripcionesEstudiante.get(i).getComision().getDia().getIdDia() == comision.getDia().getIdDia()) {
				superponeDia = true;
			}
			
			if( (mismaInscripcion) && (superponeTurno) && (superponeDia) ) {
				noExisteSuperposicion = false;
			}
			
			mismaInscripcion = false;
			superponeDia = false;
			superponeTurno = false;
			
		}
		
		if(noExisteSuperposicion) {
			DetalleInscripcion detalleInscripcion = new DetalleInscripcion(inscripcion, comision, usuario, fechaInscripcion, false);
			dao.agregarDetalleInscripcion(detalleInscripcion);
			resultado = true;
		}
		
		return resultado;
		
	}
	
	// METODO BAJA DETALLE INSCRIPCION
	public boolean bajaDetalleInscripcion(DetalleInscripcion objeto){
		
		boolean baja = false;
		
		objeto.setBaja(true);
		
		if(dao.bajaDetalleInscripcion(objeto)) {
			baja = true;
		}
		
		return baja;
		
	}

}