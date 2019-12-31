package com.kaiquecosta.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaiquecosta.cursomc.domain.Cliente;
import com.kaiquecosta.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscaClientePorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscaCliente(id);
		
		return ResponseEntity.ok().body(cliente);
	}

}
