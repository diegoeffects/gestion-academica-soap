package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Instancia;

public class InstanciaDao {
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
	
	// METODO TRAER INSTANCIA
	public Instancia traerInstancia(int idInstancia) throws HibernateException {
		Instancia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Instancia) session.get(Instancia.class, idInstancia);
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