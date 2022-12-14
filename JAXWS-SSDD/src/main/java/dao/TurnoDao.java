package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;

public class TurnoDao {
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
	
	// METODO TRAER TURNO
	public Turno traerTurno(int idTurno) throws HibernateException {
		Turno objeto = null;
		try {
			iniciaOperacion();
			objeto = (Turno) session.get(Turno.class, idTurno);
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