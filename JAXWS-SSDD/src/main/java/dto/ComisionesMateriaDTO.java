package dto;

import java.util.List;

public class ComisionesMateriaDTO {
	
	private String error;
	private String estado;
	private List<ComisionMateriaDTO> comisiones;
	
	public ComisionesMateriaDTO(String error, String estado) {
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

	public List<ComisionMateriaDTO> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<ComisionMateriaDTO> comisiones) {
		this.comisiones = comisiones;
	}
	
}
