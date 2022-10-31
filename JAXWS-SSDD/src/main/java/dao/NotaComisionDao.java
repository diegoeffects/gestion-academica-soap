package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.NotaComision;

public class NotaComisionDao {
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
	
	// METODO TRAER NOTA COMISION
	public NotaComision traerNotaComision(int idNotaComision) throws HibernateException {
		NotaComision objeto = null;
		try {
			iniciaOperacion();
			objeto = (NotaComision) session.get(NotaComision.class, idNotaComision);
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
	
	// METODO TRAER NOTAS COMISION POR COMISION
	@SuppressWarnings("unchecked")
	public List<NotaComision> traerNotasComisionPorComision(int idComision) throws HibernateException{
		List<NotaComision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from NotaComision nc where nc.comision = " + idComision).list();
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
	
	// METODO TRAER NOTAS COMISION POR COMISION Y USUARIO
	@SuppressWarnings("unchecked")
	public List<NotaComision> traerNotasComisionPorComisionYUsuario(int idComision, int idUsuario) throws HibernateException{
		List<NotaComision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from NotaComision nc where nc.comision = " + idComision + " and nc.usuario = " + idUsuario).list();
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
	
	// METODO TRAER NOTAS COMISION POR USUARIO
	@SuppressWarnings("unchecked")
	public List<NotaComision> traerNotasComisionCursadaPorUsuario(int idUsuario) throws HibernateException{
		List<NotaComision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from NotaComision nc where nc.usuario = " + idUsuario + " and nc.tipoNota = 10").list();
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
	
	// METODO TRAER NOTAS COMISION DEFINITIVAS POR USUARIO
	@SuppressWarnings("unchecked")
	public List<NotaComision> traerNotasComisionDefinitivasPorUsuario(int idUsuario) throws HibernateException{
		List<NotaComision> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from NotaComision nc where nc.usuario = " + idUsuario + " and nc.tipoNota = 12").list();
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
	
	// AGREGAR NOTA COMISION
	public int agregarNota(NotaComision objeto) {
		int id = 0;
		try {
			iniciaOperacion(); //Crea la sesion y la transaccion 
			id = Integer.parseInt(session.save(objeto).toString()); //Agregamos el objeto 
			tx.commit(); //Y lo guardo tambien en la base de datos. 
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close(); //Cerramos la sesion 
		}
		return id;	
	}
	
	
}