package dao;

import java.util.List;

import org.hibernate.Hibernate;
//import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.HistorialAcademico;

public class HistorialAcademicoDao {
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
	
	// METODO TRAER HISTORIAL ACADEMICO
	public HistorialAcademico traerHistorialAcacademico(int idHistorialAcademico) throws HibernateException {
		HistorialAcademico objeto = null;
		try {
			iniciaOperacion();
			objeto = (HistorialAcademico) session.get(HistorialAcademico.class, idHistorialAcademico);
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
	
	// TRAER HISTORIAL ACADEMICO POR ESTUDIANTE
	@SuppressWarnings("unchecked")
	public List<HistorialAcademico> traerHistorialAcademicoPorEstudiante(int idUsuario) throws HibernateException {
		List<HistorialAcademico> lista = null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from HistorialAcademico ha where ha.usuario =" + idUsuario).list();
			for (HistorialAcademico historialAcademico : lista) {
			     Hibernate.initialize(historialAcademico.getUsuario());
			     Hibernate.initialize(historialAcademico.getComision());
			}
		}
		finally {
			session.close();
		}
		return lista;	
	}
	
}