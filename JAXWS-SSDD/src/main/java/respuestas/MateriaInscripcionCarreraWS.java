package respuestas;

public class MateriaInscripcionCarreraWS {
	
	private String idComision;
	private String materia;
	private String docente;
	private String turno;
	private String idDia;
	private String diaHorario;
	
	public MateriaInscripcionCarreraWS(String idComision, String materia, String docente, String turno, String idDia,
			String diaHorario) {
		super();
		this.idComision = idComision;
		this.materia = materia;
		this.docente = docente;
		this.turno = turno;
		this.idDia = idDia;
		this.diaHorario = diaHorario;
	}

	public String getIdComision() {
		return idComision;
	}

	public void setIdComision(String idComision) {
		this.idComision = idComision;
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
	
}
