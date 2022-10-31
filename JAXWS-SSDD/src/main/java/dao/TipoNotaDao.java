package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoNota;

public class TipoNotaDao {
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
	
	// METODO TRAER TIPO NOTA
	public TipoNota traerTipoNota(int idTipoNota) throws HibernateException {
		TipoNota objeto = null;
		try {
			iniciaOperacion();
			objeto = (TipoNota) session.get(TipoNota.class, idTipoNota);
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