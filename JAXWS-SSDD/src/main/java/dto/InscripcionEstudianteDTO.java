package dto;

public class InscripcionEstudianteDTO {
	
	private String idDetalleInscripcion;
	private String materia;
	private String docente;
	private String idInscripcion;
	private String turno;
	private String idDia;
	private String diaHorario;
	private String anio;
	private String estado;
	
	public InscripcionEstudianteDTO(String idDetalleInscripcion, String materia, String docente, String idInscripcion,
			String turno, String idDia, String diaHorario, String anio, String estado) {
		super();
		this.idDetalleInscripcion = idDetalleInscripcion;
		this.materia = materia;
		this.docente = docente;
		this.idInscripcion = idInscripcion;
		this.turno = turno;
		this.idDia = idDia;
		this.diaHorario = diaHorario;
		this.anio = anio;
		this.estado = estado;
	}
	
	public String getIdDetalleInscripcion() {
		return idDetalleInscripcion;
	}

	public void setIdDetalleInscripcion(String idDetalleInscripcion) {
		this.idDetalleInscripcion = idDetalleInscripcion;
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

	public String getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(String idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getIdDia() {
		return idDia;
	}

	public void setIdDia(String idDia) {
		this.idDia = idDia;
	}

	public String getDiaHorario() {
		return diaHorario;
	}

	public void setDiaHorario(String diaHorario) {
		this.diaHorario = diaHorario;
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
