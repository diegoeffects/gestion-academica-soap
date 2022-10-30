package negocio;

import dao.MateriaDao;
import datos.Materia;

public class MateriaABM {
	
	MateriaDao dao = new MateriaDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER MATERIA
	public Materia traerMateria(int idMateria) {
		return dao.traerMateria(idMateria);
	}

}