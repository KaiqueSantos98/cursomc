package com.kaiquecosta.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kaiquecosta.cursomc.domain.Categoria;
import com.kaiquecosta.cursomc.domain.Cidade;
import com.kaiquecosta.cursomc.domain.Cliente;
import com.kaiquecosta.cursomc.domain.Endereco;
import com.kaiquecosta.cursomc.domain.Estado;
import com.kaiquecosta.cursomc.domain.Produto;
import com.kaiquecosta.cursomc.domain.enums.TipoCliente;
import com.kaiquecosta.cursomc.repositores.CategoriaRepository;
import com.kaiquecosta.cursomc.repositores.CidadeRepository;
import com.kaiquecosta.cursomc.repositores.ClienteRepository;
import com.kaiquecosta.cursomc.repositores.EnderecoRepository;
import com.kaiquecosta.cursomc.repositores.EstadoRepository;
import com.kaiquecosta.cursomc.repositores.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Populando categorias e produtos
		 */		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		/*
		 * Associar categoria com produtos
		 */		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		/*
		 * Associar produtos com categorias
		 */		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		/*
		 * Salvando atraves do Repository
		 */		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		/*
		 * Populando Estados e Cidades
		 */	
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		/*
		 * Associar cliente e endereco
		 */	
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com.br", "23233232421", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2354-2131", "92354-2131"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "Auto 3", "Jardim", "32890-213", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3232-3890", cli1, c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		 
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
