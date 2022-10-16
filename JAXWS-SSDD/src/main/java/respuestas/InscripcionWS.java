package respuestas;

public class InscripcionWS {
	
	private int idInscripcion;
	private String descripcion;
	private String instancia;
	
	public InscripcionWS(int idInscripcion, String descripcion, String instancia) {
		super();
		this.idInscripcion = idInscripcion;
		this.descripcion = descripcion;
		this.instancia = instancia;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
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
