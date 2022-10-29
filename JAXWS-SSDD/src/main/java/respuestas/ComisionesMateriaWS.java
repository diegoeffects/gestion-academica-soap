package respuestas;

import java.util.List;

public class ComisionesMateriaWS {
	
	private String error;
	private String estado;
	private List<ComisionMateriaWS> comisiones;
	
	public ComisionesMateriaWS(String error, String estado) {
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

	public List<ComisionMateriaWS> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<ComisionMateriaWS> comisiones) {
		this.comisiones = comisiones;
	}
	
}
