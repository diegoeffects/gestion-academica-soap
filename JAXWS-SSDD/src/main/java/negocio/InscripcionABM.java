package negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.InscripcionDao;
import datos.Inscripcion;

public class InscripcionABM {
	
	InscripcionDao dao = new InscripcionDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER INSCRIPCION
	public Inscripcion traerInscripcion(int idInscripcion) {	
		Inscripcion objeto = dao.traerInscripcion(idInscripcion);
		return objeto;
	}
	
	// METODO TRAER INSCRIPCIONES
	public List<Inscripcion> traerInscripciones() {
		return dao.traerInscripciones();
	}
	
	// METODO TRAER INSCRIPCIONES ACTIVAS
	public List<Inscripcion> traerInscripcionesActivas() {
		
		Date date = new Date(); 
		Date desde = new Date();  
		Date hasta = new Date();
	    
		List<Inscripcion> lista = dao.traerInscripciones();
		List<Inscripcion> listaActivas = new ArrayList<Inscripcion>();
		
		for (int i=0; i<lista.size(); i++) {
			
			try {
				desde = new SimpleDateFormat("yyyy-MM-dd").parse(lista.get(i).getDesde());
				hasta = new SimpleDateFormat("yyyy-MM-dd").parse(lista.get(i).getHasta());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			
			if( (date.after(desde)) && (date.before(hasta)) ) {
				listaActivas.add(lista.get(i));
			}

		}
		
		return listaActivas;
	}

}