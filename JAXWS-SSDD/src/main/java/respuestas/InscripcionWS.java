package respuestas;

public class InscripcionWS {
	
	private String idInscripcion;
	private String descripcion;
	private String idInstancia;
	private String instancia;
	
	public InscripcionWS(String idInscripcion, String descripcion, String idInstancia, String instancia) {
		super();
		this.idInscripcion = idInscripcion;
		this.descripcion = descripcion;
		this.idInstancia = idInstancia;
		this.instancia = instancia;
	}

	public String getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(String idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}
	
}
