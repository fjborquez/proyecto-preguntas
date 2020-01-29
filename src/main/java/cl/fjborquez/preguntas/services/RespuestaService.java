package cl.fjborquez.preguntas.services;

import org.springframework.stereotype.Service;

import cl.fjborquez.preguntas.repository.RespuestaRepository;

@Service
public class RespuestaService {
	private final RespuestaRepository respuestaRepository;
	
	public RespuestaService(RespuestaRepository respuestaRepository) {
		this.respuestaRepository = respuestaRepository;
	}
}
