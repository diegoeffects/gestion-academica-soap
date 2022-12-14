package datos;

public class Turno {
	
	private int idTurno;
	private String turno;
	
	public Turno() {} // CONSTRUCTOR HIBERNATE

	public Turno(String turno) {
		super();
		this.turno = turno;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", turno=" + turno + "]";
	}
	
}
