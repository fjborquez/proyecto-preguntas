package cl.fjborquez.preguntas.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import cl.fjborquez.preguntas.domain.Pregunta;

@Repository
public interface PreguntaRepository extends Neo4jRepository<Pregunta, Long> {

}
