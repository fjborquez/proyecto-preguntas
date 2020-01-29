package cl.fjborquez.preguntas.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.fjborquez.preguntas.domain.Categoria;
import cl.fjborquez.preguntas.services.CategoriaService;

@Controller
public class AdminCategoriaController {
	private CategoriaService categoriaService;
	
	public AdminCategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/admin/categoria")
	public String list(Model model) {
		model.addAttribute("categorias", categoriaService.buscarTodos());
		model.addAttribute("titulo", "Lista de categorias");
		model.addAttribute("agregarUri", "/admin/categoria/add");
		model.addAttribute("sinRegistros", "No hay categorias disponibles");
		
		return "categoria/list";
	}
	
	@GetMapping("/admin/categoria/add")
	public String addView(Model model) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("titulo", "Agregar categoria");
		model.addAttribute("volverUri", "/admin/categoria");
		model.addAttribute("formUri", "/admin/categoria/add");
		
		return "categoria/view";
	}

	@PostMapping("/admin/categoria/add")
	public String add(@ModelAttribute Categoria categoria, Model model) {
		categoriaService.guardar(categoria);
		
		return list(model);
	}
	
	@GetMapping("/admin/categoria/{id}/edit")
	public String editView(@PathVariable("id") Long id, Model model) {
		Categoria categoria = new Categoria();
		Optional<Categoria> categoriaEditable;
		
		categoriaEditable = categoriaService.buscarPorId(id);
		
		if (categoriaEditable.isPresent()) {
			categoria = categoriaEditable.get();
		}
		
		model.addAttribute("categoria", categoria);
		model.addAttribute("titulo", "Editar categoria");
		model.addAttribute("volverUri", "/admin/categoria");
		model.addAttribute("formUri", "/admin/categoria/" + categoria.getId() + "/edit");
		
		return "categoria/view";
	}
	
	@PostMapping("/admin/categoria/{id}/edit")
	public String edit(@ModelAttribute Categoria categoria, Model model) {
		categoriaService.guardar(categoria);
		
		return list(model);
	}
	
	@GetMapping("/admin/categoria/{id}/delete")
	public String delete(@PathVariable("id") Long id, Model model) {
		categoriaService.eliminar(id);
		
		return list(model);
	}
	
	// TODO: Uri de editar y eliminar desde controlador
	// TODO: No permitir vacio al editar y agregar
}
