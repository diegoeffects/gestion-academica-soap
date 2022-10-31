package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	
	UsuarioDao dao = new UsuarioDao(); // CREA UN DAO "INSTANCIA DE HIBERNATE"
	
	// METODO TRAER USUARIO
	public Usuario traerUsuario(int idUsuario) {
		return dao.traerUsuario(idUsuario);
	}
	
	// METODO TRAER ESTUDIANTE
	public Usuario traerEstudiante(int idUsuario) {
		return dao.traerEstudiante(idUsuario);
	}
	
	// METODO TRAER USUARIOS
	public List<Usuario> traerUsuarios() {
		return dao.traerUsuarios();
	}
	
	// METODO MODIFICAR USUARIO
	public Usuario actualizarDatosUsuario(int idUsuario, String correo, String celular, String clave) throws Exception {
		
		Usuario objeto = dao.traerUsuario(idUsuario);
		
		if (objeto == null) {
			throw new Exception("MENSAJE: El ID ingresado no correponde a un usuario valido");
		} // end_if
		
		objeto.setCorreo(correo);
		objeto.setCelular(celular);
		objeto.setClave(clave);
		
		if(dao.actualizarDatosUsuario(objeto)){
			objeto = dao.traerUsuario(idUsuario);
		}
	
		return objeto;
		
	}

}