package com.rafaelcortez.cursospringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelcortez.cursospringboot.domain.Categoria;
import com.rafaelcortez.cursospringboot.domain.Cidade;
import com.rafaelcortez.cursospringboot.domain.Cliente;
import com.rafaelcortez.cursospringboot.domain.Endereco;
import com.rafaelcortez.cursospringboot.domain.Estado;
import com.rafaelcortez.cursospringboot.domain.Produto;
import com.rafaelcortez.cursospringboot.domain.enums.TipoCliente;
import com.rafaelcortez.cursospringboot.repositories.CategoriaRepositiry;
import com.rafaelcortez.cursospringboot.repositories.CidadeRepositiry;
import com.rafaelcortez.cursospringboot.repositories.ClienteRepositiry;
import com.rafaelcortez.cursospringboot.repositories.EnderecoRepositiry;
import com.rafaelcortez.cursospringboot.repositories.EstadoRepositiry;
import com.rafaelcortez.cursospringboot.repositories.ProdutoRepositiry;

@SpringBootApplication
public class CursospringbootApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepositiry categoriaRepository;
	
	@Autowired
	private ProdutoRepositiry produtoRepository;
	
	@Autowired
	private CidadeRepositiry cidadeRepository;
	
	@Autowired
	private EstadoRepositiry estadoRepository;
	
	@Autowired
	private ClienteRepositiry clienteRepository;
	
	@Autowired
	private EnderecoRepositiry enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "38727012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
