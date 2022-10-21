package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetalleInscripcion;

public class DetalleInscripcionDao {
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
	
	// METODO TRAER DETALLE INSCRIPCION
	public DetalleInscripcion traerDetalleInscripcion(int idDetalleInscripcion) throws HibernateException {
		DetalleInscripcion objeto = null;
		try {
			iniciaOperacion();
			objeto = (DetalleInscripcion) session.get(DetalleInscripcion.class, idDetalleInscripcion);
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
	
	// METODO TRAER DETALLES INSCRIPCION
	@SuppressWarnings("unchecked")
	public List<DetalleInscripcion> traerDetallesInscripcion() throws HibernateException{
		List<DetalleInscripcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleInscripcion").list();
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
	
	// METODO TRAER DETALLES INSCRIPCION POR ESTUDIANTE
	@SuppressWarnings("unchecked")
	public List<DetalleInscripcion> traerDetallesInscripcionPorEstudiante(int idUsuario) throws HibernateException{
		List<DetalleInscripcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleInscripcion di where di.usuario=" + idUsuario).list();
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
	
	// METODO TRAER DETALLES INSCRIPCION ACTIVAS POR ESTUDIANTE
	@SuppressWarnings("unchecked")
	public List<DetalleInscripcion> traerDetallesInscripcionActivasPorEstudiante(int idUsuario) throws HibernateException{
		List<DetalleInscripcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleInscripcion di where di.usuario=" + idUsuario + " and di.baja=0").list();
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
	
	
	// METODO TRAER DETALLES INSCRIPCION POR COMISION
	@SuppressWarnings("unchecked")
	public List<DetalleInscripcion> traerDetallesInscripcionPorComision(int idComision) throws HibernateException{
		List<DetalleInscripcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleInscripcion di where di.comision=" + idComision + " and di.baja=0").list();
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
	
	// METODO AGREGAR DETALLE INSCRIPCION
	public int agregarDetalleInscripcion(DetalleInscripcion detalleInscripcion){
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(detalleInscripcion).toString()); // CAPTURA EL ULTIMO ID USADO
			tx.commit(); // VUELVE LA TRANSACCION HACIA ATRAS
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close(); 
			}
		return id;
	}
	
	// METODO BAJA DETALLE INSCRIPCION
	public boolean bajaDetalleInscripcionBaja(DetalleInscripcion objeto) throws HibernateException {
		
		boolean baja = false;
		
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
			baja = true;
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		
		return baja;
		
	}
	
}