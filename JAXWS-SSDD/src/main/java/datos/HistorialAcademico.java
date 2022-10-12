package datos;

public class HistorialAcademico {
	
	private int idHistorialAcademico;
	private Usuario usuario;
	private Comision comision;
	private int nota;
	private String fecha;
	
	public HistorialAcademico() {} // CONSTRUCTOR HIBERNATE

	public HistorialAcademico(Usuario usuario, Comision comision, int nota, String fecha) {
		super();
		this.usuario = usuario;
		this.comision = comision;
		this.nota = nota;
		this.fecha = fecha;
	}

	public int getIdHistorialAcademico() {
		return idHistorialAcademico;
	}

	public void setIdHistorialAcademico(int idHistorialAcademico) {
		this.idHistorialAcademico = idHistorialAcademico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "HistorialAcademico [idHistorialAcademico=" + idHistorialAcademico + ", usuario=" + usuario
				+ ", comision=" + comision + ", nota=" + nota + ", fecha=" + fecha + "]";
	}
	
}
