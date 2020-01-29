package cl.fjborquez.preguntas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.fjborquez.preguntas.domain.Categoria;
import cl.fjborquez.preguntas.repository.CategoriaRepository;

@Service
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public Categoria guardar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> buscarTodos() {
		return (List<Categoria>) categoriaRepository.findAll();
	}
	
	public Optional<Categoria> buscarPorId(Long id) {
		return categoriaRepository.findById(id);
	}
	
	public void eliminar(Long id) {
		categoriaRepository.deleteById(id);
	}
}
