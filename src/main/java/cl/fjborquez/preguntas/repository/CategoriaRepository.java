package cl.fjborquez.preguntas.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import cl.fjborquez.preguntas.domain.Categoria;

@Repository
public interface CategoriaRepository extends Neo4jRepository<Categoria, Long> {

}
