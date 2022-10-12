package respuestas;

public class PlanillaMateriasWS {
	
	private String carrera;
	private String descripcion;
	private String instancia;
	
	public PlanillaMateriasWS(String carrera, String descripcion, String instancia) {
		super();
		this.carrera = carrera;
		this.descripcion = descripcion;
		this.instancia = instancia;
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

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}
	
}
