package respuestas;

public class ComisionBWS {
	
	private int idMateria;
	private String materia;
	private String comision;
	private String docente;
	private String horario;
	
	public ComisionBWS(int idMateria, String materia, String comision, String docente, String horario) {
		super();
		this.idMateria = idMateria;
		this.materia = materia;
		this.comision = comision;
		this.docente = docente;
		this.horario = horario;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
