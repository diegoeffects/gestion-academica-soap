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
	
	// METODO TRAER INSCRIPCIONES
	public List<DetalleInscripcion> traerDetallesInscripcion() {
		return dao.traerDetallesInscripcion();
	}
	
	// METODO TRAER DETALLES INSCRIPCION POR ESTUDIANTE
	public List<DetalleInscripcion> traerDetallesInscripcionPorEstudiante(int idUsuario){
		return dao.traerDetallesInscripcionPorEstudiante(idUsuario);
	}
	
	// METODO TRAER DETALLES INSCRIPCION POR COMISION
	public List<DetalleInscripcion> traerDetallesInscripcionPorComision(int idComision){
		return dao.traerDetallesInscripcionPorComision(idComision);
	}
	
	// METODO AGREGAR DETALLE INSCRIPCION
	public boolean agregarDetalleInscripcion(Inscripcion inscripcion, Comision comision, Usuario usuario, String fechaInscripcion, boolean baja) throws Exception {
		
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
			
		}
			
		if( ((superponeDia == true) && (superponeTurno == true)) ) {
			if(mismaInscripcion) {
				resultado = false;
			}
			else {
				DetalleInscripcion detalleInscripcion = new DetalleInscripcion(inscripcion, comision, usuario, fechaInscripcion, false);
				dao.agregarDetalleInscripcion(detalleInscripcion);
				resultado = true;
			}
		}
		else {
			DetalleInscripcion detalleInscripcion = new DetalleInscripcion(inscripcion, comision, usuario, fechaInscripcion, false);
			dao.agregarDetalleInscripcion(detalleInscripcion);
			resultado = true;
		}
		
		return resultado;
		
	}
	
	// METODO BAJA DETALLE INSCRIPCION
	public boolean bajaDetalleInscripcionBaja(DetalleInscripcion objeto){
		
		boolean baja = false;
		
		objeto.setBaja(true);
		
		if(dao.bajaDetalleInscripcionBaja(objeto)) {
			baja = true;
		}
		
		return baja;
		
	}

}