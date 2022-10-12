package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	
	UsuarioDao dao = new UsuarioDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER USUARIO
	public Usuario traerUsuario(int idUsuario) {
		
		Usuario objeto = dao.traerUsuario(idUsuario);
		return objeto;
		
	}
	
	// METODO TRAER USUARIOS
	public List<Usuario> traerUsuarios() {
		return dao.traerUsuarios();
	}
	
	// METODO MODIFICAR USUARIO
	public Usuario actualizarDatosUsuario(int idUsuario, String correo, String celular) throws Exception {
		
		Usuario objeto = dao.traerUsuario(idUsuario);
		
		if (objeto == null) {
			throw new Exception("MENSAJE: El ID ingresado no correponde a un usuario valido");
		} // end_if
		
		objeto.setCorreo(correo);
		objeto.setCelular(celular);
		
		if(dao.actualizarDatosUsuario(objeto)){
			objeto = dao.traerUsuario(idUsuario);
		}
	
		return objeto;
		
	}
	
	// METODO MODIFICAR USUARIO
	public Usuario actualizarDatosUsuario(int idUsuario, String nombre, String apellido, String dni, String correo, String celular) throws Exception {
		
		Usuario objeto = dao.traerUsuario(idUsuario);
		
		if (objeto == null) {
			throw new Exception("MENSAJE: El ID ingresado no correponde a un usuario valido");
		} // end_if
		
		objeto.setNombre(nombre);
		objeto.setApellido(apellido);
		objeto.setDni(dni);
		objeto.setCelular(celular);
		objeto.setCorreo(correo);
		
		if(dao.actualizarDatosUsuario(objeto)){
			objeto = dao.traerUsuario(idUsuario);
		}
	
		return objeto;
		
	}

}