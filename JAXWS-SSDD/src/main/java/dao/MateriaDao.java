package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Materia;

public class MateriaDao {
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
	
	// METODO TRAER MATERIA
	public Materia traerMateria(int idMateria) throws HibernateException {
		Materia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Materia) session.get(Materia.class, idMateria);
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