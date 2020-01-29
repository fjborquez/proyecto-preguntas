package cl.fjborquez.preguntas.services;

import org.springframework.stereotype.Service;

import cl.fjborquez.preguntas.repository.PreguntaRepository;

@Service
public class PreguntaService {
	private final PreguntaRepository preguntaRepository;
	
	public PreguntaService(PreguntaRepository preguntaRepository) {
		this.preguntaRepository = preguntaRepository;
	}
}
