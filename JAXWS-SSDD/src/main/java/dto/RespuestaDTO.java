package dto;

public class RespuestaDTO {
	
	private String error;
	private String estado;
	
	public RespuestaDTO(String error, String estado) {
		super();
		this.error = error;
		this.estado = estado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
