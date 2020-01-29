package cl.fjborquez.preguntas.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Pregunta {
	@Id
	@GeneratedValue
	private Long id;
	private String pregunta;
	private String descripcion;
	private Boolean esInicial;
	@Relationship("DAN_RESPUESTA")
	private List<Respuesta> respuestas;

	@Relationship(type = "AGRUPA", direction = Relationship.INCOMING)
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsInicial() {
		return esInicial;
	}

	public void setEsInicial(Boolean esInicial) {
		this.esInicial = esInicial;
	}
}
