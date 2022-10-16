package datos;

public class Usuario {
	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String dni;
	private String correo;
	private String celular;
	private String usuario;
	private String clave;
	private boolean forzarClave;
	private Carrera carrera;
	private TipoUsuario tipoUsuario;

	public Usuario() {} // CONSTRUCTOR HIBERNATE

	public Usuario(String nombre, String apellido, String dni, String correo, String celular,
			String usuario, String clave, boolean forzarClave, Carrera carrera, TipoUsuario tipoUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.celular = celular;
		this.usuario = usuario;
		this.clave = clave;
		this.forzarClave = forzarClave;
		this.carrera = carrera;
		this.tipoUsuario = tipoUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isForzarClave() {
		return forzarClave;
	}

	public void setForzarClave(boolean forzarClave) {
		this.forzarClave = forzarClave;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", correo=" + correo + ", celular=" + celular + ", usuario=" + usuario + ", clave=" + clave
				+ ", forzarClave=" + forzarClave + ", carrera=" + carrera + "]";
	}
	
}
