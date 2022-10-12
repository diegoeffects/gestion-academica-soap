package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Comision;

public class ComisionDao {
	private static Session session;
	private Transaction tx;
	
	// METODOS OBLIGATORIOS
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	// METODO TRAER COMISION
	public Comision traerComision(int idComision) throws HibernateException {
		Comision objeto = null;
		try {
			iniciaOperacion();
			objeto = (Comision) session.get(Comision.class, idComision);
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	// METODO TRAER COMISIONES
	@SuppressWarnings("unchecked")
	public List<Comision> traerComisiones() throws HibernateException{
		List<Comision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Comision").list();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return lista;
	}
	
	// METODO TRAER COMISIONES POR INSCRIPCION Y CARRERA
	@SuppressWarnings("unchecked")
	public List<Comision> traerComisionesPorInscripcionYCarrera(int idInscripcion, int idCarrera){
		List<Comision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Comision c where c.inscripcion=" + idInscripcion + "and c.materia in (from Materia m where m.carrera=" + idCarrera + ")").list();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return lista;
	}
	
}