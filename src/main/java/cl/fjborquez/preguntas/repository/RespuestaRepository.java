package cl.fjborquez.preguntas.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import cl.fjborquez.preguntas.domain.Respuesta;

public interface RespuestaRepository extends Neo4jRepository<Respuesta, Long>{

}
