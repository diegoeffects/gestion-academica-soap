package respuestas;

import java.util.List;

public class EstudiantesMateriaWS {
	
	private String error;
	private String estado;
	private String idInstancia;
	private List<EstudianteMateriaWS> estudiantesInscriptos;
	
	public EstudiantesMateriaWS(String error, String estado, String idInstancia) {
		super();
		this.error = error;
		this.estado = estado;
		this.idInstancia = idInstancia;
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

	public String getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}

	public List<EstudianteMateriaWS> getEstudiantesInscriptos() {
		return estudiantesInscriptos;
	}

	public void setEstudiantesInscriptos(List<EstudianteMateriaWS> estudiantesInscriptos) {
		this.estudiantesInscriptos = estudiantesInscriptos;
	}
	
}
