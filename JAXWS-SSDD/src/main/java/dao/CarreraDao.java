package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Carrera;

public class CarreraDao {
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
	
	// METODO TRAER CARRERA
	public Carrera traerCarrera(int idCarrera) throws HibernateException {
		Carrera objeto = null;
		try {
			iniciaOperacion();
			objeto = (Carrera) session.get(Carrera.class, idCarrera);
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
	
}