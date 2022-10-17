package respuestas;

public class PlanillaMateriasWS {
	
	private String carrera;
	private String descripcion;
	private int idInstancia;
	private String instancia;
	private String turno;
	
	public PlanillaMateriasWS(String carrera, String descripcion, int idInstancia, String instancia, String turno) {
		super();
		this.carrera = carrera;
		this.descripcion = descripcion;
		this.idInstancia = idInstancia;
		this.instancia = instancia;
		this.turno = turno;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(int idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
}
