package datos;

public class DetalleInscripcion {
	
	private int idDetalleInscripcion;
	private Inscripcion inscripcion;
	private Comision comision;
	private Usuario usuario;
	private String fechaInscripcion;
	private boolean baja;
	
	public DetalleInscripcion() {} // CONSTRUCTOR HIBERNATE

	public DetalleInscripcion(Inscripcion inscripcion, Comision comision, Usuario usuario, String fechaInscripcion, boolean baja) {
		super();
		this.inscripcion = inscripcion;
		this.comision = comision;
		this.usuario = usuario;
		this.fechaInscripcion = fechaInscripcion;
		this.baja = baja;
	}
	
	public int getIdDetalleInscripcion() {
		return idDetalleInscripcion;
	}

	public void setIdDetalleInscripcion(int idDetalleInscripcion) {
		this.idDetalleInscripcion = idDetalleInscripcion;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	@Override
	public String toString() {
		return "DetalleInscripcion [idDetalleInscripcion=" + idDetalleInscripcion + ", inscripcion=" + inscripcion
				+ ", comision=" + comision + ", usuario=" + usuario + ", fechaInscripcion=" + fechaInscripcion
				+ ", baja=" + baja + "]";
	}
	
}
