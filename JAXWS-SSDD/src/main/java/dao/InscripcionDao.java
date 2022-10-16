package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Inscripcion;

public class InscripcionDao {
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
	
	// METODO TRAER INSCRIPCION
	public Inscripcion traerInscripcion(int idInscripcion) throws HibernateException {
		Inscripcion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Inscripcion) session.get(Inscripcion.class, idInscripcion);
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
	
	// METODO TRAER INSCRIPCIONES
	@SuppressWarnings("unchecked")
	public List<Inscripcion> traerInscripciones() throws HibernateException{
		List<Inscripcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Inscripcion").list();
			for (Inscripcion inscripcion : lista) {
			     Hibernate.initialize(inscripcion.getInstancia());
			}
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