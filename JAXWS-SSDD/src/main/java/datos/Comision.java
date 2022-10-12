package datos;

public class Comision {
	
	private int idComision;
	private Inscripcion inscripcion;
	private Turno turno;
	private Materia materia;
	private Usuario usuario;
	private Dia dia;
	private String rangoHorario;
	private int comision;
	private String anio;
	
	public Comision() {} // CONSTRUCTOR HIBERNATE

	public Comision(Inscripcion inscripcion, Turno turno, Materia materia, Usuario usuario, Dia dia,
			String rangoHorario, int comision, String anio) {
		super();
		this.inscripcion = inscripcion;
		this.turno = turno;
		this.materia = materia;
		this.usuario = usuario;
		this.dia = dia;
		this.rangoHorario = rangoHorario;
		this.comision = comision;
		this.anio = anio;
	}

	public int getIdComision() {
		return idComision;
	}

	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public String getRangoHorario() {
		return rangoHorario;
	}

	public void setRangoHorario(String rangoHorario) {
		this.rangoHorario = rangoHorario;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Comision [idComision=" + idComision + ", inscripcion=" + inscripcion + ", turno=" + turno + ", materia="
				+ materia + ", usuario=" + usuario + ", dia=" + dia + ", rangoHorario=" + rangoHorario + ", comision="
				+ comision + ", anio=" + anio + "]";
	}
	
}
