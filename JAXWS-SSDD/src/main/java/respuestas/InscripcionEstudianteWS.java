package respuestas;

public class InscripcionEstudianteWS {
	
	private String idDetalleEstudiante;
	private String materia;
	private String docente;
	private String descripcion;
	private String turno;
	private String anio;
	private String estado;
	
	public InscripcionEstudianteWS(String idDetalleEstudiante, String materia, String docente, String descripcion,
			String turno, String anio, String estado) {
		super();
		this.idDetalleEstudiante = idDetalleEstudiante;
		this.materia = materia;
		this.docente = docente;
		this.descripcion = descripcion;
		this.turno = turno;
		this.anio = anio;
		this.estado = estado;
	}

	public String getIdDetalleEstudiante() {
		return idDetalleEstudiante;
	}

	public void setIdDetalleEstudiante(String idDetalleEstudiante) {
		this.idDetalleEstudiante = idDetalleEstudiante;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
