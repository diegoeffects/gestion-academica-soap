package dto;

public class ComisionMateriaDTO {
	
	private String idComision;
	private String comision;
	
	public ComisionMateriaDTO(String idComision, String comision) {
		super();
		this.idComision = idComision;
		this.comision = comision;
	}

	public String getIdComision() {
		return idComision;
	}

	public void setIdComision(String idComision) {
		this.idComision = idComision;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}
	
}
