package com.kaiquecosta.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaiquecosta.cursomc.domain.Categoria;
import com.kaiquecosta.cursomc.services.CategoriaService;

//Controlador Rest

@RestController	
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscaCategoriaPorId(@PathVariable Integer id) {
		
		Categoria categoria = categoriaService.buscarCategoriaPorId(id);
		
		return ResponseEntity.ok().body(categoria);
	}
}
