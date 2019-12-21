package com.kaiquecosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiquecosta.cursomc.domain.Categoria;
import com.kaiquecosta.cursomc.repositores.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarCategoriaPorId(Integer id){
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElse(null);
	}
}
