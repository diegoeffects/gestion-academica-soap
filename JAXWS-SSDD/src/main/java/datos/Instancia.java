package datos;

public class Instancia {
	
	private int idInstancia;
	private String instancia;
	
	public Instancia() {} // CONSTRUCTOR HIBERNATE

	public Instancia(String instancia) {
		super();
		this.instancia = instancia;
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

	@Override
	public String toString() {
		return "Instancia [idInstancia=" + idInstancia + ", instancia=" + instancia + "]";
	}
	
}
