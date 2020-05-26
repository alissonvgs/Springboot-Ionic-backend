package com.alissonvgs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alissonvgs.domain.Categoria;
import com.alissonvgs.domain.Cidade;
import com.alissonvgs.domain.Cliente;
import com.alissonvgs.domain.Endereco;
import com.alissonvgs.domain.Estado;
import com.alissonvgs.domain.Produto;
import com.alissonvgs.domain.enums.TipoCliente;
import com.alissonvgs.repositories.CategoriaRepository;
import com.alissonvgs.repositories.CidadeRepository;
import com.alissonvgs.repositories.ClienteRepository;
import com.alissonvgs.repositories.EnderecoRepository;
import com.alissonvgs.repositories.EstadoRepository;
import com.alissonvgs.repositories.ProdutoRepository;

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
		 Categoria cat1 = new Categoria(null, "Informática");
		 Categoria cat2 = new Categoria(null, "Escritório");
		 
		 Produto p1 = new Produto(null, "Computador", 4000.00);
		 Produto p2 = new Produto(null, "Impressora", 800.00);
		 Produto p3 = new Produto(null, "Mouse", 200.00);
		 
		 cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		 cat2.getProdutos().addAll(Arrays.asList(p2));
		 
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat1));
	 
		 categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		 produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		 
		 Estado est1 =  new Estado(null, "Minha Gerais");
		 Estado est2 = new Estado(null, "São Paulo");
		 
		 Cidade c1 = new Cidade(null, "Umberlândia", est1);
		 Cidade c2 = new Cidade(null, "São Paulo", est2);
		 Cidade c3 = new Cidade(null, "Campinas", est2);
		 
		 est1.getCidades().addAll(Arrays.asList(c1));
		 est2.getCidades().addAll(Arrays.asList(c2, c3));
		 
		 estadoRepository.saveAll(Arrays.asList(est1, est2));
		 cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		 
		 Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "31241312", TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("13411135", "245243245"));
		 
		 Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Centro", "58345000", cli1, c1);
		 Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Casa", "Centro", "58355000", cli1, c2);
		 
		 cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		 
		 clienteRepository.saveAll(Arrays.asList(cli1));
		 enderecoRepository.saveAll(Arrays.asList(e1, e2));
	
	}

}
