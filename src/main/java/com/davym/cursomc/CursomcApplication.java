package com.davym.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davym.cursomc.domain.Categoria;
import com.davym.cursomc.domain.Cidade;
import com.davym.cursomc.domain.Cliente;
import com.davym.cursomc.domain.Endereco;
import com.davym.cursomc.domain.Estado;
import com.davym.cursomc.domain.Produto;
import com.davym.cursomc.domain.enuns.TipoCliente;
import com.davym.cursomc.repositories.CategoriaRepository;
import com.davym.cursomc.repositories.CidadeRepository;
import com.davym.cursomc.repositories.ClienteRepository;
import com.davym.cursomc.repositories.EnderecoRepository;
import com.davym.cursomc.repositories.EstadoRepository;
import com.davym.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
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
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto (null,"Impressora", 800.00);
		Produto p3 = new Produto (null,"Mouse",80.00);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	     categoriaRepository.flush();
	     produtoRepository.flush();
	 
	     cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	     cat2.getProdutos().add(p2);
	 
	     p1.getCategorias().add(cat1);
	     p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	     p3.getCategorias().add(cat1);
	     
	     categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	     produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	     
	     
	     Estado est1 = new Estado(null,"Minas Gerais");
	     Estado est2 = new Estado(null, "São Paulo");
	     
	     Cidade c1 = new Cidade (null,"Uberlândia",est1);
	     Cidade c2 = new Cidade (null,"São Paulo",est2);
	     Cidade c3 = new Cidade (null,"Campinas",est2);
	     
	     est1.getCidades().addAll(Arrays.asList(c1));
	     est2.getCidades().addAll(Arrays.asList(c2,c3));
	     
	     estadoRepository.saveAll(Arrays.asList(est1,est2));
	     cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	     
	     Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
	     cli1.getTelefones().addAll(Arrays.asList("38975465","982275448"));
	     Endereco e1 = new Endereco(null, "rua Castelo Negro", "152", "Cambója", "Casa", "38220834", cli1, c1);
	     Endereco e2 = new Endereco(null, "rua Castelo Azul", "12", "braója", "Apartamento", "38550814", cli1, c2);
	     
	     cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	     clienteRepository.saveAll(Arrays.asList(cli1));
	     enderecoRepository.saveAll(Arrays.asList(e1, e2));
	 }
}
